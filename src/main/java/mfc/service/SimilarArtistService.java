package mfc.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mfc.condition.LiftComparator;
import mfc.entity.ArtistMr;
import mfc.entity.ArtistTypeList;
import mfc.sub.SimilarArtistServiceSub;
import mfc.utilities.InstanceManager;
import mfc.utilities.SimilarKeyOperateManager;
import mfc.utilities.StringPrescribedManager;
import mfc.utilities.WrapperRegexManager;

public class SimilarArtistService extends AbstractService<ArtistTypeList> {

    @Resource
    private ArtistMasterService artistMasterService;

    @Resource
    private ArtistBoxService artistBoxService;

    /**
     * 指定したアーティストの類似アーティストを30件返す<br/>
     *
     * @param artistCode
     * @return
     */
    public final List<String> getListSimilarArtist(final String artistCode){
        // return用のリスト／追加された順番が優先順位を示す
        List<String> artistCodeList = InstanceManager.newAtomicList();

        // X（指定アーティスト）を含む要素をカウントする
        Map<String,Integer> containXcodeMap = InstanceManager.newNotAtomicMap();
        // XとY（類似アーティスト候補）の両方を含む要素をカウントする
        Map<String,Integer> containXandYcodeMap = InstanceManager.newNotAtomicMap();

        // ファイルから取得してキーワードリストを得る
        List<String> similarKeywordsList = SimilarKeyOperateManager.getRegexpPatternList();
        // 指定アーティストに一致したキーワードだけを残すリスト：このキーワード
        List<String> similarMatchKeywrdList = InstanceManager.newNotAtomicList();

        // BOXリストから取得して同一BOXキーに含まれるアーティストコードのリストを作る
        Map<String,String> mapOfArtistCodeListInBox = artistBoxService.getMapOfSameBoxArtistList();
        // 上記のうち、指定アーティストを含むもののみをセットしたリストを作る
        Map<String,String> mapOfMatchedArtistCodeListInBox = InstanceManager.newNotAtomicMap();

        // 指定アーティストの情報を得る
        ArtistMr specifiedArtist = artistMasterService.fetchSingle(artistCode);
        /* Xを含むトランザクションの数   */
        //Integer containXcodeTransactionCount = Integer.valueOf(0);
        Integer totalTransactionCount = Integer.valueOf(0);
        if(specifiedArtist != null){
            String targetString = StringPrescribedManager.convertForMatch(specifiedArtist.getArtistApeal());
            /* Xを含むトランザクションの数(テンポラリ作業）   */
            //int containXcodeTransactionCounter = 0;
            // 指定アーティスト（X）と同じキャラを含むアーティストの数をXを含むトランザクションの一部とみなす。
            for(String keyword: similarKeywordsList){
                if(WrapperRegexManager.isMatched(targetString, keyword)){
                    // 一致した場合だけキーワードリストに残す
                    similarMatchKeywrdList.add(keyword);
                    // 一致した場合はX（指定アーティスト）を含む要素をカウントアップ
                    //containXcodeTransactionCounter++;
                }
             }

            for(String boxKeyCode : mapOfArtistCodeListInBox.keySet()){
                if(WrapperRegexManager.isMatched(mapOfArtistCodeListInBox.get(boxKeyCode),artistCode)){
                    mapOfMatchedArtistCodeListInBox.put(boxKeyCode, mapOfArtistCodeListInBox.get(boxKeyCode));
                    //containXcodeTransactionCounter++;
                }
            }
            /* Xを含むトランザクションの数   */
            //containXcodeTransactionCount = Integer.valueOf(containXcodeTransactionCounter);

            // アーティスト情報（全件）を得る
            List<ArtistMr> artistMrList = artistMasterService.fetchAll();

            if(artistMrList !=  null){
                // アーティストボックス情報全件の件数を得る
                /* 総トランザクション数
                 * アーティストリストの件数　＋　ボックスのすべての件数
                 */
                totalTransactionCount = Integer.valueOf(artistMrList.size()+ artistBoxService.getAllCount());
                for(ArtistMr mr:artistMrList){
                    // 同一アーティストでなければ処理をする
                    if(!mr.getArtistCode().equals(artistCode)){
                        String targetAppeal = StringPrescribedManager.convertForMatch(mr.getArtistApeal());
                        // アピールに指定アーティストの名前が踏まれていれば、リターンのリストに追加する。（最優先になる）
                        if(SimilarArtistServiceSub.isContainArtistNameInAppeal(targetAppeal,specifiedArtist.getArtistName1(),specifiedArtist.getArtistName2())){
                            artistCodeList.add(mr.getArtistCode());
                        }else{
                            /**
                             * XとYを共に含むトランザクションの数<br/>
                             */
                            // 類似テキスト検索を行う。一致したらカウントアップする
                            for(String key: similarMatchKeywrdList){
                                if(WrapperRegexManager.isMatched(targetString, key)){
                                    Integer tmpXy = containXandYcodeMap.get(mr.getArtistCode());
                                    if(tmpXy == null){
                                        containXandYcodeMap.put(mr.getArtistCode(), Integer.valueOf(1));
                                    }else{
                                        containXandYcodeMap.put(mr.getArtistCode(), Integer.valueOf(tmpXy.intValue() + 1));
                                    }
                                }
                            }
                            // BOXで指定アーティストコードを含む場合は、XYをカウントアップする
                            for(String boxMatchedKeyCode : mapOfMatchedArtistCodeListInBox.keySet()){
                                if(WrapperRegexManager.isMatched(mapOfArtistCodeListInBox.get(boxMatchedKeyCode),mr.getArtistCode())){
                                    mapOfMatchedArtistCodeListInBox.put(boxMatchedKeyCode, mapOfArtistCodeListInBox.get(boxMatchedKeyCode));
                                    Integer tmpXy2 = containXcodeMap.get(mr.getArtistCode());
                                    if(tmpXy2 == null){
                                        containXandYcodeMap.put(mr.getArtistCode(), Integer.valueOf(1));
                                    }else{
                                        containXandYcodeMap.put(mr.getArtistCode(), Integer.valueOf(tmpXy2.intValue() + 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                totalTransactionCount = Integer.valueOf(artistBoxService.getAllCount());
            }
      }
      List<String> artistCodeListForSortWork = InstanceManager.newNotAtomicList();
      for(String artistCodeKey : containXandYcodeMap.keySet()) {

          // 信頼度 confidence を求める.XとYを共に含むトランザクションの数 ÷Xを含むトランザクションの数
          //double confidence = Double.valueOf(containXandYcodeMap.get(artistCodeKey).toString()).doubleValue() / Double.valueOf(containXcodeTransactionCount.toString()).doubleValue();

          // 支持度 support を求める.XとYを共に含むトランザクションの数 ÷総トランザクション数
          double support = Double.valueOf(containXandYcodeMap.get(artistCodeKey).toString()).doubleValue() / Double.valueOf(totalTransactionCount.toString()).doubleValue();

          // リフト値 lift を求める.信頼度 ÷ 支持度
          //double lift = confidence / support;
          // リフト値を整数の15桁の文字列になおして、アーティストコードと連結して、リストにおさめる
          artistCodeListForSortWork.add(String.format("%1.10f", support) + "_" + artistCodeKey);
      }
      // 結果のリストを降順にソートする。（リフト値の大きい順にならべかえる）
      Collections.sort(artistCodeListForSortWork,new LiftComparator());

      // ソートした結果のリストを順に処理し、アーティストコードのみのリストを作る。これをリターンする。
      for(String aCode : artistCodeListForSortWork){
          String[] tmps = aCode.split("_");
          artistCodeList.add(tmps[1]);
      }

      return artistCodeList;
    }
}
