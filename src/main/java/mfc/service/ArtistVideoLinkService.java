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
     *         0：すでに同じキーが登録済等の理由で登録レコードなし -2：Googleに接続できなかった
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
        for (ArtistLink record : listFromDb) {
            String videoKey = YouTubeManager.getMovieKeyOfYoutube(record
                    .getLinkUrl());
            // listFromGoogleのタイトルから、タイトルからアーティスト名や／や-などの区切り文字と左右の空白は除去する。
            mapUrlForCheck.put(videoKey, videoKey);
        }

        // タイトルを検査して、MusicVideo,PV,公式などの名称があるものだけを登録対象とする。類似の名前も検査ではぶく。
        for (GoogleSearchResult node : listFromGoogle) {
            // URLからMOVIEキーを取り出し、MAPに同じキーがないばあいだけ登録対象に追加・MAPにも追加
            if (isPvOrMvCheckOK(node.getTitle())) {
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

    private boolean isPvOrMvCheckOK(final String targetTitle) {
        if (StringUtil.isBlank(targetTitle)) {
            return false;
        }

        return WrapperRegexManager.isMatched(
                StringPrescribedManager.convert(targetTitle).toUpperCase(),
                "^.*(PV|MV|MUSICVIDEO|ミュージックビデオ).*$");

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
