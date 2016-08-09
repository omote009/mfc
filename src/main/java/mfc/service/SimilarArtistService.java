package mfc.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import mfc.condition.ReverseStringComparator;
import mfc.entity.ArtistMr;
import mfc.entity.ArtistTypeList;
import mfc.sub.SimilarArtistServiceSub;
import mfc.utilities.InstanceManager;
import mfc.utilities.SimilarKeyOperateManager;
import mfc.utilities.StringPrescribedManager;
import mfc.utilities.WrapperRegexManager;

import org.seasar.framework.util.StringUtil;

public class SimilarArtistService extends AbstractService<ArtistTypeList> {

    @Resource
    private ArtistMasterService artistMasterService;

    @Resource
    private ArtistBoxService artistBoxService;

    public final List<String> getListSimilarArtist(final String artistCode,
            final List<String> exclusionArtistList) {
        final int limit = 10;
        return getListSimilarArtist(artistCode, limit, exclusionArtistList);
    }

    public final List<String> getListSimilarArtist(final String artistCode) {
        final int limit = 10;
        return getListSimilarArtist(artistCode, limit);
    }

    public final List<String> getListSimilarArtist(final String artistCode,
            final int limit) {
        List<String> dummyList = InstanceManager.newNotAtomicList();
        return getListSimilarArtist(artistCode, limit, dummyList);
    }

    /**
     * 指定したアーティストの類似アーティストを返す<br/>
     *
     * @param artistCode
     * @return
     */
    public final List<String> getListSimilarArtist(final String artistCode,
            final int limit, final List<String> exclusionArtistList) {

        // return用のリスト／追加された順番が優先順位を示す
        List<String> artistCodeList = InstanceManager.newAtomicList();
        Map<String, String> exclusionArtistMap = InstanceManager.newAtomicMap();

        if (limit <= 0) {
            return artistCodeList;
        }

        if (exclusionArtistList != null) {
            for (String exArtistCode : exclusionArtistList) {
                exclusionArtistMap.put(exArtistCode, exArtistCode);
            }
        }

        // XとY（類似アーティスト候補）の両方を含む要素をカウントする
        Map<String, Integer> containXandYcodeMap = InstanceManager
                .newNotAtomicMap();
        // 指定アーティストに一致したキーワードだけを残すリスト：このキーワード
        List<String> similarMatchKeywrdList = InstanceManager
                .newNotAtomicList();
        // 指定アーティストを含むもののみをセットしたリストを作る
        Map<String, String> mapOfMatchedArtistCodeListInBox = InstanceManager
                .newNotAtomicMap();

        // ファイルから取得して汎用キーワードリスト全件を得る
        List<String> similarKeywordsList = SimilarKeyOperateManager
                .getRegexpPatternList();

        // 指定アーティストの情報を得る
        ArtistMr specifiedArtist = artistMasterService.fetchSingle(artistCode);

        if (specifiedArtist != null) {
            String artistApealStr = specifiedArtist.getArtistApeal();
            if (!StringUtil.isBlank(artistApealStr)) {
                String[] appeals = artistApealStr.split("[,、]");
                String targetString = StringPrescribedManager
                        .convertForMatch(artistApealStr);
                // 汎用キーワードリストを、指定アーティストにマッチするものだけに絞り込む
                for (String keyword : similarKeywordsList) {
                    if (WrapperRegexManager.isMatched(targetString, keyword)) {
                        similarMatchKeywrdList.add(keyword);
                    }
                }

                // 指定アーティストキャラのキーワードを絞り込んだキーワードリストに追加する。
                for (int i = 0; i < appeals.length; i++) {
                    StringBuilder tmpsb = new StringBuilder();
                    tmpsb.append("^.*(");
                    tmpsb.append(appeals[i]);
                    tmpsb.append(").*$");
                    similarMatchKeywrdList.add(tmpsb.toString());
                }
            }

            // BOXリストから登録されたBOXコードとアーティストコードの全件リストを作る
            Map<String, String> mapOfArtistCodeListInBox = artistBoxService
                    .getMapOfSameBoxArtistList();

            // 全件リストを指定アーティストコードを含むBOXコードのみに絞り込む
            for (String boxKeyCode : mapOfArtistCodeListInBox.keySet()) {
                if (WrapperRegexManager.isMatched(mapOfArtistCodeListInBox.get(boxKeyCode), artistCode)) {
                    mapOfMatchedArtistCodeListInBox.put(boxKeyCode,	mapOfArtistCodeListInBox.get(boxKeyCode));
                }
            }

            // アーティスト全件のリストを得る
            List<ArtistMr> artistMrList = artistMasterService.fetchAll();

            if (artistMrList != null) {
                for (ArtistMr mr : artistMrList) {
                    // 同一アーティストは無視する
                    if (!mr.getArtistCode().equals(artistCode)) {
                        if (exclusionArtistMap.get(mr.getArtistCode()) == null) {
                            String targetAppeal = StringPrescribedManager.convertForMatch(mr.getArtistApeal());
                            // アピールに指定アーティストの名前が含まれていれば、リターンのリストに追加する。（最優先になる）
                            if (SimilarArtistServiceSub.isContainArtistNameInAppeal(targetAppeal,specifiedArtist.getArtistName1())) {
                                artistCodeList.add(mr.getArtistCode());
                            } else {
                                // 指定アーティストの名前が、キャラに含まれている場合も同様にリターンのリストに優先的に追加する
                                String specifiedTargetStr = StringPrescribedManager.convertForMatch(specifiedArtist.getArtistApeal());
                                if (SimilarArtistServiceSub.isContainArtistNameInAppeal(specifiedTargetStr,mr.getArtistName1())) {
                                    artistCodeList.add(mr.getArtistCode());
                                } else {
                                    // アーティストのキャラにキーワードが含まれるか検査し、一致したら件数をカウントアップする
                                    int intXy = 0;
                                    for (String key : similarMatchKeywrdList) {
                                        if (WrapperRegexManager.isMatched(
                                                targetAppeal, key)) {
                                            intXy++;
                                        }
                                    }
                                    // アーティストコードがBOXに含まれるかを検査し、一致したらさらに件数をカウントアップする
                                    for (String boxMatchedKeyCode : mapOfMatchedArtistCodeListInBox
                                            .keySet()) {
                                        if (WrapperRegexManager
                                                .isMatched(
                                                        mapOfArtistCodeListInBox
                                                                .get(boxMatchedKeyCode),
                                                        mr.getArtistCode())) {
                                            mapOfMatchedArtistCodeListInBox
                                                    .put(boxMatchedKeyCode,
                                                            mapOfArtistCodeListInBox
                                                                    .get(boxMatchedKeyCode));
                                            intXy++;
                                        }
                                    }
                                    containXandYcodeMap.put(mr.getArtistCode(),
                                            Integer.valueOf(intXy));
                                }
                            }
                        }
                    }
                }
            }

            List<String> artistCodeListForSortWork = InstanceManager
                    .newNotAtomicList();
            // 同じ件数の中での並び順をランダムにするために、乱数発生させる。
            Random randomGen = new Random();
            randomGen.setSeed(artistBoxService.getAllCount());

            for (String artistCodeKey : containXandYcodeMap.keySet()) {

                // 一致件数と乱数を文字列にして、アーティストコードと連結して、リストにおさめる
                int tmp = randomGen.nextInt();
                if (tmp < 0) {
                    tmp = tmp * -1;
                }
                artistCodeListForSortWork.add(String.format("%010d",
                        containXandYcodeMap.get(artistCodeKey).intValue())
                        + String.format("%010d", tmp) + "_" + artistCodeKey);
            }
            // 結果のリストを降順にソートする。（一致件数の大きい順にならべかえる）
            Collections.sort(artistCodeListForSortWork, new ReverseStringComparator());

            // ソートした結果のリストを順に処理し、アーティストコードのみのリストを作る。これをリターンする。
            for (String aCode : artistCodeListForSortWork) {
                // System.out.println(aCode);
                String[] tmps = aCode.split("_");
                artistCodeList.add(tmps[1]);
                if (artistCodeList.size() >= limit) {
                    break;
                }
            }

        } else {
            // アーティスト全件のリストを得る
            List<ArtistMr> artistMrList = artistMasterService.fetchAll();
            // 同じ件数の中での並び順をランダムにするために、乱数発生させる。
            Random randomGen2 = new Random();
            randomGen2.setSeed(Integer
                    .valueOf(
                            (int) (System.currentTimeMillis()
                                    % artistMrList.size() - 1)).intValue());
            // 指定アーティストが取得できなかった時は、単純にランダムなアーティストのリストを返す
            for (int tmpI = 0; tmpI < limit; tmpI++) {
                int tmpInt = randomGen2.nextInt();
                if (tmpInt < 0) {
                    tmpInt = tmpInt * -1;
                }
                tmpInt = tmpInt % (artistMrList.size() - 1);
                String artistAddCode = artistMrList.get(tmpInt).getArtistCode();
                artistCodeList.add(artistAddCode);
            }
        }

        return artistCodeList;
    }
}
