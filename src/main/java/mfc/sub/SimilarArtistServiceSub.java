package mfc.sub;

import mfc.utilities.StringPrescribedManager;
import mfc.utilities.WrapperRegexManager;

import org.seasar.framework.util.StringUtil;

public class SimilarArtistServiceSub {

    private SimilarArtistServiceSub(){

    }

     /**
     * 名前が含まれているかどうかを検査する
     */
    public static boolean isContainArtistNameInAppeal(final String targetAppeal,final String artistName1,final String artistName2){
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
     * 名前が含まれているかどうかを検査する
     */
    public static boolean isContainArtistNameInAppeal(final String targetAppeal,final String artistName1){
        if(StringUtil.isBlank(targetAppeal)){
            return false;
         }
        StringBuilder sb = new StringBuilder();
        if(StringUtil.isBlank(artistName1)){
            return false;
        }else{
            sb.append("^.*(");
            sb.append(StringPrescribedManager.convertForMatch(artistName1));
            sb.append(").*$");
            return WrapperRegexManager.isMatched(targetAppeal, sb.toString());
        }
    }

}
