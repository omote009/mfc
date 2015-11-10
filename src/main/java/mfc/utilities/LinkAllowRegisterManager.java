package mfc.utilities;

import org.seasar.framework.util.StringUtil;

public class LinkAllowRegisterManager {

    private LinkAllowRegisterManager(){

    }

    /**
     * @param url
     * @return yuoTubeのURLならTRUE
     */
    public static boolean isYouTube(final String url){
        boolean ret = false;
        if(StringUtil.isBlank(url)){
            return false;
        }

        String pattern = ".*(youtube|youtu\\.be|y2u\\.be).*";
        ret = WrapperRegexManager.isMatched(url, pattern);
        return ret;
    }

    /**
     * @param url
     * @return GyaoのURLならTRUE
     */
    public static boolean isGyao(final String url){
        boolean ret = false;

        if(StringUtil.isBlank(url)){
            return false;
        }
        String pattern = ".*(gyao).*";
        ret = WrapperRegexManager.isMatched(url, pattern);
        return ret;
    }

    /**
     * @param url
     * @return　DMotionのURLならTRUE
     */
    public static boolean isDmotion(final String url){
        boolean ret = false;
        if(StringUtil.isBlank(url)){
            return false;
        }

        String pattern = ".*(dailymotion|pideo\\.net).*";
        ret = WrapperRegexManager.isMatched(url, pattern);
        return ret;
    }

    /**
     * @param url
     * @return MuzixのURLならTRUE
     */
    public static boolean isMuzix(final String url){
        boolean ret = false;
        if(StringUtil.isBlank(url)){
            return false;
        }
        String pattern = ".*(mu-zix).*";
        ret = WrapperRegexManager.isMatched(url, pattern);
        return ret;
    }

    /**
     * @param url
     * @return　ニコニコ動画のURLならTRUE
     */
    public static boolean isNoco(final String url){
         boolean ret = false;
         if(StringUtil.isBlank(url)){
             return false;
         }
         String pattern = ".*(nicovideo).*";
         ret = WrapperRegexManager.isMatched(url, pattern);
         return ret;
     }

    /**
     * @param url
     * @return SoundCloudのURLならTRUE
     */
    public static boolean isSound(final String url){
         boolean ret = false;
         if(StringUtil.isBlank(url)){
             return false;
         }

         String pattern = ".*(soundcloud).*";
         ret = WrapperRegexManager.isMatched(url, pattern);
         return ret;
     }

    /**
     * @param url
     * @return AudioReafのURLならTRUE
     */
    public static boolean isAudio(final String url){
         boolean ret = false;
         if(StringUtil.isBlank(url)){
             return false;
         }

         String pattern = ".*(audioleaf).*";
         ret = WrapperRegexManager.isMatched(url, pattern);
         return ret;
     }

    /**
     * @param url
     * @return UストリームのURLならTRUE
     */
    public static boolean isUstream(final String url){
         boolean ret = false;
         if(StringUtil.isBlank(url)){
             return false;
         }

         String pattern = ".*(ustream).*";
         ret = WrapperRegexManager.isMatched(url, pattern);
         return ret;
     }


}
