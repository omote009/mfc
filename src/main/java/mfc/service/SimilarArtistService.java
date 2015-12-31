package mfc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mfc.entity.ArtistMr;
import mfc.entity.ArtistTypeList;
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
        if(specifiedArtist != null){
            String targetString = StringPrescribedManager.convertForMatch(specifiedArtist.getArtistApeal());
            // 指定アーティストのキャラに対して、キーワード検索を行う。
            for(String keyword: similarKeywordsList){
                if(WrapperRegexManager.isMatched(targetString, keyword)){
                    // 一致した場合だけキーワードリストに残す
                    similarMatchKeywrdList.add(keyword);
                    // 一致した場合はX（指定アーティスト）を含む要素をカウントアップ
                    Integer i = containXcodeMap.get(artistCode);
                    if(i == null){
                        containXcodeMap.put(artistCode, Integer.valueOf(1));
                    }else{
                        containXcodeMap.put(artistCode, Integer.valueOf(i.intValue() + 1));
                    }
                }
             }

            for(String boxKeyCode : mapOfArtistCodeListInBox.keySet()){
                if(WrapperRegexManager.isMatched(mapOfArtistCodeListInBox.get(boxKeyCode),artistCode)){
                    mapOfMatchedArtistCodeListInBox.put(boxKeyCode, mapOfArtistCodeListInBox.get(boxKeyCode));
                    Integer i2 = containXcodeMap.get(artistCode);
                    if(i2 == null){
                        containXcodeMap.put(artistCode, Integer.valueOf(1));
                    }else{
                        containXcodeMap.put(artistCode, Integer.valueOf(i2.intValue() + 1));
                    }
                }
            }

            // アーティスト情報（全件）を得る
            List<ArtistMr> artistMrList = artistMasterService.fetchAll();
            if(artistMrList !=  null){
                for(ArtistMr mr:artistMrList){
                    // 同一アーティストでなければ処理をする
                    if(!mr.getArtistCode().equals(artistCode)){
                        String targetAppeal = StringPrescribedManager.convertForMatch(mr.getArtistApeal());
                        // アピールに指定アーティストの名前が踏まれていれば、リターンのリストに追加する。（最優先になる）
                        if(isContainArtistNameInAppeal(targetAppeal,specifiedArtist.getArtistName1(),specifiedArtist.getArtistName2())){
                            artistCodeList.add(mr.getArtistCode());
                        }else{
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
            }
      }

          // カウント用のマップ（アーティストコード,


        return artistCodeList;
    }

    /**
     * 名前が含まれているかどうかを検査する
     */
    private boolean isContainArtistNameInAppeal(final String targetAppeal,final String artistName1,final String artistName2){
        if(StringUtil.isBlank(targetAppeal)){
            return false;
         }
        StringBuilder sb = new StringBuilder();
        if(StringUtil.isBlank(artistName1) && StringUtil.isBlank(artistName2)){
            return false;
        }else{
            sb.append("^.*(");
            if(!StringUtil.isBlank(artistName1)){
                sb.append(StringPrescribedManager.convertForMatch(artistName1));
            }
              if(!StringUtil.isBlank(artistName2)){
                  sb.append("|");
                sb.append(StringPrescribedManager.convertForMatch(artistName2));
            }
            sb.append(").*$");
            return WrapperRegexManager.isMatched(targetAppeal, sb.toString());
        }


    }
    /**
     * XとYを共に含むトランザクションの数<br/>
     */


    /**
     * Xを含むトランザクションの数<br/>
     */

    /**
     * 総トランザクション数<br/>
     */

    /**
     * 信頼度を求める<br/>
     * XとYを共に含むトランザクションの数 ÷Xを含むトランザクションの数<br/>
     *
     */

    /**
     * 支持度を求める<br/>
     * XとYを共に含むトランザクションの数 ÷総トランザクション数<br/>
     */

    /**
     * リフト値を求める<br/>
     * 信頼度 ÷ 支持度<br/>
     */

}
