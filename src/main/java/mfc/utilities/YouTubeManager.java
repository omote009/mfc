package mfc.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.seasar.framework.util.StringUtil;

public final class YouTubeManager {

    private YouTubeManager(){

    }

    /**
     * ユーチューブAPIで利用可能なURLを返す。<br/>
     *
     * @param movieKey
     * @param isMobile
     * @return ユーチューブAPIで利用可能なURL
     */
    public static String toUrlForYoutubeApi(final String movieKey,
            final boolean isMobile) {
        if (StringUtil.isBlank(movieKey)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("http://www.youtube.com/embed/");
        sb.append(movieKey);

        if (isMobile) {
            sb.append("?enablejsapi=1&origin=http://example.com");
        } else {
            sb.append("?enablejsapi=1&origin=http://example.com&autoplay=1");
        }
        return sb.toString();

    }

    /**
     * 独自ムービープレーヤー（ユーチューブAPIを利用）へのリンク用URLを返す。
     *
     * @param movieKey
     * @param artistCode
     * @return 独自ムービープレーヤー（ユーチューブAPIを利用）へのリンク用URL
     */
    public static String toMfcMoviePlayerUrl(final String movieKey,
            final String artistCode) {
        if (StringUtil.isBlank(movieKey)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MfcUrlManager.getBaseUrl());
        sb.append("moviePlay");
        sb.append("?key=");
        sb.append(movieKey);
        if (!StringUtil.isBlank(artistCode)) {
            sb.append("&sel=");
            sb.append(artistCode);
        }
        return sb.toString();
    }

    public static String getNormalUrl() {
        return "http://www.youtube.com/watch?v=";
    }

    /**
     * ユーチューブの短縮URLをノーマルなURLに戻す
     *
     * @param youtubeShortUrl
     * @return
     */
    public static String toNomalUrlFromShortUrl(final String youtubeShortUrl) {

        String bpat = "http:\\/\\/youtu\\.be\\/|http:\\/\\/y2u\\.be\\/";
        Pattern p = Pattern.compile(bpat);
        Matcher pre = p.matcher(youtubeShortUrl);
        return pre.replaceAll("https://www.youtube.com/watch?v=");

    }

    /**
     * ユーチューブのURLからムービーキーだけを取り出す。
     *
     * @param youtubeUrl
     * @return　ユーチューブのムービーキー
     */
    public static String getMovieKeyOfYoutube(final String youtubeUrl) {
        if (StringUtil.isBlank(youtubeUrl)) {
            return "";
        }
        String retKey = "";
        if (LinkAllowRegisterManager.isYouTube(youtubeUrl)) {

            String urlTmp = toNomalUrlFromShortUrl(youtubeUrl);

            // ここから解析処理
            String[] tmp = urlTmp.split("\\?");
            if (tmp.length > 1) {
                String[] tmp2 = tmp[1].split("&");
                String pat = "v=(.*)";
                Pattern p1 = Pattern.compile(pat);
                for (int i = 0; i < tmp2.length; i++) {
                    Matcher m = p1.matcher(tmp2[i]);
                    if (m.find()) {
                        retKey = m.group(1);
                    }
                }
            }
        } else {
            retKey = "";
        }

        return retKey;

    }

    public static String getMoviekeyOfYoutubeFromSearchResult(
            final String searchResultUrl) {

        if (StringUtil.isBlank(searchResultUrl)) {
            return "";
        }

        String pat = "^.*www\\.youtube\\.com.*%3Fv%3D(.*?)&amp.*$";

        Pattern p1 = Pattern.compile(pat);
        Matcher m = p1.matcher(searchResultUrl);
        if (m.find()) {
            return m.group(1);
        } else {
            return "";
        }

    }

    /**
     * ユーチューブのサムネイル画像を取得するためのURLを返す。
     *
     * @param url
     * @return　ユーチューブのサムネイル画像を取得するためのURL
     */
    public static String getUrlOfThumbnailImageFromYoutube(final String url) {
        String retUrl = "http://img.youtube.com/vi/Video%20ID/default.jpg";
        if (StringUtil.isBlank(url)) {
            return retUrl;
        }

        if (LinkAllowRegisterManager.isYouTube(url)) {
            // 短縮URLをもとに戻す
            String urlTmp = toNomalUrlFromShortUrl(url);

            // ここから解析処理
            String[] tmp = urlTmp.split("\\?");
            if (tmp.length > 1) {
                String[] tmp2 = tmp[1].split("&");
                String pat = "v=(.*)";
                Pattern p1 = Pattern.compile(pat);
                for (int i = 0; i < tmp2.length; i++) {
                    Matcher m = p1.matcher(tmp2[i]);
                    if (m.find()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("http://img.youtube.com/vi/");
                        sb.append(m.group(1));
                        sb.append("/default.jpg");
                        retUrl = sb.toString();
                    }
                }
            }
        } else {
            String baseUrl = MfcUrlManager.getBaseUrl();

            if (LinkAllowRegisterManager.isUstream(url)) {
                retUrl = baseUrl + "movie_ustream.png";
            }

            if (LinkAllowRegisterManager.isAudio(url)) {
                retUrl = baseUrl + "movie_sound.png";
            }

            if (LinkAllowRegisterManager.isSound(url)) {
                retUrl = baseUrl + "movie_sound.png";
            }

            if (LinkAllowRegisterManager.isNoco(url)) {
                retUrl = baseUrl + "movie_niko.png";
            }

            if (LinkAllowRegisterManager.isDmotion(url)) {
                retUrl = baseUrl + "movie_video.png";
            }
            if (LinkAllowRegisterManager.isMuzix(url)) {
                retUrl = baseUrl + "movie_video.png";
            }
            if (LinkAllowRegisterManager.isGyao(url)) {
                retUrl = baseUrl + "movie_video.png";
            }

        }

        return retUrl;
    }

    public static String trimForVideoTitle(final String targetString,
            final String eraceString) {
        if (StringUtil.isBlank(targetString) || StringUtil.isBlank(eraceString)) {
            return targetString;
        }

        String trimedTargetString = StringUtil.ltrim(StringUtil
                .rtrim(targetString));
        String trimedEraceString = StringUtil.ltrim(StringUtil
                .rtrim(eraceString));
        String regex = escapeRegexParentheses(trimedEraceString)
               //+ "|[\\]\\]]"
               // + StringPrescribedManager.convertForMatch(trimedEraceString)
                + "|YouTube|[\\-\\[\\]【】]";
        Pattern p = Pattern.compile(regex);
        return StringUtil.rtrim(StringUtil.ltrim(p.matcher(trimedTargetString).replaceAll("")));

    }

    /**
     * 正規表現に利用する文字をエスケープした文字列を出力する
     */
    public static String escapeRegexParentheses(final String sourceString){
        if(StringUtil.isBlank(sourceString)){
            return "";
        }
        String returnFirst = sourceString.replaceAll("[\\[\\]]", "");
       return returnFirst;

    }

}
