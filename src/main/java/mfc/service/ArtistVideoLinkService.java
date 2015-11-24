package mfc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mfc.beans.GoogleSearchResult;
import mfc.entity.ArtistLink;
import mfc.entity.ArtistMr;
import mfc.utilities.InstanceManager;
import mfc.utilities.LinkAllowRegisterManager;
import mfc.utilities.StringPrescribedManager;
import mfc.utilities.WrapperRegexManager;
import mfc.utilities.YouTubeManager;
import mfc.webtools.GoogleHttpClient;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.util.StringUtil;

public class ArtistVideoLinkService extends AbstractService<ArtistLink> {

    @Resource
    private ArtistMasterService artistMasterService;

    /**
     *
     * @param artistCode
     * @return DBに自動追加したレコード数<br>
     *         0：すでに同じキーが登録済等の理由で登録レコードなし <br/>
     *         -2: Googleから1件も取得できなかった（拒否）または、接続できなかった
     *
     */
    public int automaticAddVideoLinkFromYoutube(final String artistCode) {
        if (StringUtil.isBlank(artistCode)) {
            return 0;
        }

        ArtistMr artist = artistMasterService.fetchSingle(artistCode);
        if (artist == null) {
            return 0;
        } else {

            // DBから登録済のリンクのリストを取得する
            List<ArtistLink> movieListFromDb = fetcheList(artistCode);
            if (movieListFromDb == null) {
                // とりあえずNULLではなくす
                movieListFromDb = InstanceManager.newNotAtomicList();
            }

            // youtubeから動画を検索する。
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(artist.getArtistName1());
            sb.append("\"");
            sb.append(" site:www.youtube.com");
            GoogleHttpClient httpClient = new GoogleHttpClient();
            System.out.println(sb.toString());
            List<GoogleSearchResult> listFromGoogle = httpClient
                    .responseFromGoogle(sb.toString());
            if (listFromGoogle == null || listFromGoogle.isEmpty()) {
                return -2;
            }

            // 登録可能な動画リストを取得する
            List<ArtistLink> listForBatchInsert = getRagisterableVideoLinkList(
                    listFromGoogle, movieListFromDb, artist.getArtistName1(),
                    artistCode);

            if (listForBatchInsert == null || listForBatchInsert.isEmpty()) {
                return 0;
            }
            // 登録可能な動画リストをバッチ挿入する
            int[] status = jdbcManager.insertBatch(listForBatchInsert)
                    .execute();
            int statusForReturn = 0;
            for (int i = 0; i < status.length; i++) {
                statusForReturn = statusForReturn + status[i];
            }

            return statusForReturn;

        }

    }

    private List<ArtistLink> getRagisterableVideoLinkList(
            final List<GoogleSearchResult> listFromGoogle,
            final List<ArtistLink> listFromDb, final String artistName,
            final String artistCode) {
        List<ArtistLink> registerableMovieList = InstanceManager
                .newNotAtomicList();
        Map<String, String> mapUrlForCheck = InstanceManager.newNotAtomicMap();

        // youtubeの動画のみ、listFromDb からmovieキーを取り出し、比較用MAPを生成する。
        if (listFromDb != null) {
            for (ArtistLink record : listFromDb) {
                String videoKey = YouTubeManager.getMovieKeyOfYoutube(record
                        .getLinkUrl());
                // listFromGoogleのタイトルから、タイトルからアーティスト名や／や-などの区切り文字と左右の空白は除去する。
                mapUrlForCheck.put(videoKey, videoKey);
            }
        }

        // タイトルを検査して、MusicVideo,PV,公式などの名称があるものだけを登録対象とする。類似の名前も検査ではぶく。
        for (GoogleSearchResult node : listFromGoogle) {
            // URLからMOVIEキーを取り出し、MAPに同じキーがないばあいだけ登録対象に追加・MAPにも追加
            // System.out.println(node.getTitle());
            if (isPvOrMvCheckOK(node.getTitle(), artistName)) {
                if (LinkAllowRegisterManager.isYouTube(node.getUrl())) {
                    String videoKeyFromGoogle = YouTubeManager
                            .getMoviekeyOfYoutubeFromSearchResult(node.getUrl());
                    if (!StringUtil.isBlank(videoKeyFromGoogle)) {
                        if (mapUrlForCheck.get(videoKeyFromGoogle) == null) {
                            ArtistLink newRecord = new ArtistLink();
                            newRecord.setArtistCode(artistCode);
                            newRecord.setDispName(YouTubeManager
                                    .trimForVideoTitle(node.getTitle(),
                                            artistName)
                                    + "(Auto)");
                            newRecord.setLinkUrl(YouTubeManager.getNormalUrl()
                                    + videoKeyFromGoogle);
                            newRecord.setUpdateUserId("Auto Registerd!!");
                            registerableMovieList.add(newRecord);
                            mapUrlForCheck.put(videoKeyFromGoogle,
                                    videoKeyFromGoogle);
                        }
                    }
                }
            }
        }
        return registerableMovieList;
    }

    protected boolean isPvOrMvCheckOK(final String targetTitle,
            final String artistName) {
        if (StringUtil.isBlank(targetTitle) || StringUtil.isBlank(artistName)) {
            return false;
        }

        boolean checkStatus = false;
        String convertedArtistName = StringPrescribedManager.convertForMatch(artistName);
        checkStatus = WrapperRegexManager.isMatched(
                StringPrescribedManager.convertForMatch(targetTitle), "^("
                        + convertedArtistName
                        + "|MV"
                        + convertedArtistName
                        + ").*");

        if(checkStatus == false){
            checkStatus = WrapperRegexManager.isMatched(
                    StringPrescribedManager.convertForMatch(targetTitle), "^.*("
                            + "BY"
                            + convertedArtistName
                            + "|\\/"
                            + convertedArtistName
                            + ").*");
        }

        if (checkStatus == true) {
            checkStatus = WrapperRegexManager.isMatched(StringPrescribedManager
                    .convert(targetTitle).toUpperCase(),
                    "^.*(MV|MUSICVIDEO|MUSIC VIDEO|ミュージックビデオ|ミュージック.ビデオ).*$");
            if (checkStatus == true) {
                boolean checkStatusOmit = WrapperRegexManager
                        .isMatched(
                                StringPrescribedManager.convert(targetTitle)
                                        .toUpperCase(),
                                "^.*(踊ッテミタ|新PV|新.PV|PV公開|PV.公開|PV解禁|PV.解禁|PV.秘密|PV作成|PV.作成|"
                                        + "PV密着|PV.密着|PV画像|[『【「（〈\\(《｛\\[]AMV|SUDDENATTACK|手書.PV|手書PV|[『【「｛\\(（〈《\\[]OPV|"
                                        + "新MV|新.MV|MV公開|MV.公開|MV解禁|MV.解禁|MV.秘密|MV作成|"
                                        + "MV.作成|MV密着|MV.密着|SPECIAL MV|取材|カバー|コピー|主題歌|"
                                        + "PV特集|MV特集|PV集|MV集|厳選PV|厳選MV|"
                                        + "ニュース|歌ッテミタ|吹奏楽|PV.MV.フル|MV.PV.フル|フル.MV|フル.PV|フル.FULL|"
                                        + "吹奏楽|コメント|MV.MAKING|メイキング|MV.作.|[0-9]{1,2}月[0-9]{1,2}日|"
                                        + "[『【「（\\(〈《｛\\[]HD|1080PHD|720PHD|1080IHD|[『【「（｛〈\\(《\\[]COVER|MV.COVER|"
                                        + "PV.COVER|メドレー|カラオケ|歌詞付|傑作集|傑作選|MV.COPY|COPY.OF|PV.COPY|"
                                        + "[『【「（｛〈\\(《\\[]COPY|AMV\\/|HMV|"
                                        + "弾イテミタ|COVER[\\)\\]）』】」》｝]|COVER.MV|COVER.PV|COPY.MV|"
                                        + "COPY.PV|[『【「（｛〈\\(《\\[]MMD|MMD[\\)\\]）』】」》｝]|HD[\\)\\]）』】」》｝]|"
                                        + "予告編|特典DVD|ALBUM TRAILER|告知|メンバー紹介|オ知ラセ|配信開始|"
                                        + "1[0-9][0-9][0-9]X|修正版|ビデオヲ公開|HMV共催|[0-9]開催|"
                                        + "ビデオ解禁|ビデオ.解禁|ビデオ公開|ビデオ作成|ビデオ.作成|ビデオ特集|ビデオ集|"
                                        + "[0-9]{1,2}\\/[0-9]{1,2}|FULL.フル|"
                                        + "MVデ|MVガ|MVヲ|MVハ|MV！|\\.WMV|ミュージックビデオハ|"
                                        + "ミュージックビデオガ|ミュージックビデオヲ|新ミュージックビデオ|新.ミュージックビデオ).*$");
                if (checkStatusOmit == true) {
                    checkStatus = false;
                }
            }
        }

        return checkStatus;

    }

    public List<ArtistLink> fetcheList(final String artistCode) {

        if (StringUtil.isBlank(artistCode)) {
            return null;
        }

        return select().where(new SimpleWhere().eq("artistCode", artistCode))
                .getResultList();

    }

    public ArtistLink fetcheSingle(final String artistCode,
            final String displayTitle) {

        if (StringUtil.isBlank(artistCode) || StringUtil.isBlank(displayTitle)) {
            return null;
        }

        return select().where(
                new SimpleWhere().eq("artistCode", artistCode).eq("dispName",
                        displayTitle)).getSingleResult();

    }

    public int updateWithJudgement(final String artistCode,
            final String displayTitle, final String movieUrl) {

        if (StringUtil.isBlank(artistCode) || StringUtil.isBlank(displayTitle)
                || StringUtil.isBlank(movieUrl)) {
            return 0;
        }

        ArtistLink newLink = new ArtistLink();
        newLink.setArtistCode(artistCode);
        newLink.setDispName(displayTitle);
        newLink.setLinkUrl(movieUrl);
        newLink.setUpdateUserId("auto");

        ArtistLink link = fetcheSingle(artistCode, displayTitle);
        if (link == null) {
            return jdbcManager.insert(newLink).execute();

        } else {
            int deleteStatus = jdbcManager.delete(link).execute();
            if (deleteStatus > 0) {

                return jdbcManager.insert(newLink).execute();
            } else {
                return 0;
            }

        }

    }

}
