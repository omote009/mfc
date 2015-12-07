package mfc.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.seasar.framework.util.StringUtil;

public final class WrapperRegexManager {

    private WrapperRegexManager() {

    }

    /**
     * 文字列がパターンに一致するとTRUEを返す。<br />
     * パターンには正規表現を使用する。<br />
     *
     * @param チェック対象文字列
     * @param 正規表現パターン
     * @return 一致したらTRUE
     *
     */
    public static boolean isMatched(final String targetString,
            final String regexpPattern) {
        if (StringUtil.isBlank(targetString)) {
            return false;
        }

        if (StringUtil.isBlank(regexpPattern)) {
            return false;
        }

        Pattern p = Pattern.compile(regexpPattern);
        Matcher m = p.matcher(targetString);
        return m.find();
    }

}
