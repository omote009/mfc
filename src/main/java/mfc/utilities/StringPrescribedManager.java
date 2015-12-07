package mfc.utilities;

import java.util.regex.Pattern;

import org.seasar.framework.util.StringUtil;

/**
 * 文字列を比較する時に、一旦プロジェクト規定フォーマットに変換するために利用する。
 *
 * @author omote
 *
 */
public final class StringPrescribedManager {

    private StringPrescribedManager() {

    }

    /**
     * 全角・半角・カナ混じり文を読込、規定ののフォーマットに統一する。<br>
     * <br>
     * プロジェクト規定のフォーマット。<br>
     * １）全角漢字。<br>
     * ２）全角カタカナ<br>
     * ３）半角英字 ４）半角数字<br>
     *
     * @param inputedString
     *            変換前文字列
     * @return 変換後文字列
     */
    public static String convert(final String inputedString) {

        if (StringUtil.isBlank(inputedString)) {
            return "";
        }

        // 半角カタカナは全角カタカナに変換
        StringBuilder returnStringBuilder = new StringBuilder(
                hanToZenKanaStr(inputedString));

        // 書式にあわせて変換をかける
        for (int i = 0; i < returnStringBuilder.length(); i++) {
            char c = returnStringBuilder.charAt(i);
            // ひらがなを全角カタカナに変換する
            if (c >= 'ぁ' && c <= 'ん') {
                returnStringBuilder.setCharAt(i, (char) (c - 'ぁ' + 'ァ'));
            }

            // 全角アルファベットを半角アルファベットに変換する
            if (c >= 'ａ' && c <= 'ｚ') {
                returnStringBuilder.setCharAt(i, (char) (c - 'ａ' + 'a'));
            } else if (c >= 'Ａ' && c <= 'Ｚ') {
                returnStringBuilder.setCharAt(i, (char) (c - 'Ａ' + 'A'));
            }
            // 全角数字を半角数字に変換する。
            if (c >= '０' && c <= '９') {
                returnStringBuilder.setCharAt(i, (char) (c - '０' + '0'));
            }
            // 全角＠記号を半角@記号に変換する。
            if (c == '＠') {
                returnStringBuilder.setCharAt(i, '@');
            }
        }
        return returnStringBuilder.toString();
    }

    /**
     * 比較用規定文字列に変換。括弧、空白などを詰め、英字はすべて大文字に変換する。
     *
     * @param str
     * @return
     */
    public static String convertForMatch(final String str) {
        return convert(prescribedTrim(str)).toUpperCase();
    }

    /**
     * 比較用規定文字列に変換。空白などを詰め、英字はすべて大文字に変換する。
     *
     * @param str
     * @return
     */
    public static String convertForMatchOtherThanParentheses(final String str) {
        return convert(prescribedTrimOtherThanParentheses(str)).toUpperCase();
    }


    /**
     * 文字列の空白や_などを取り除き、圧縮する。
     *
     * @param inputedString
     * @return 空白などを取り除いた文字列
     */
    public static String prescribedTrim(final String inputedString) {
        if (StringUtil.isBlank(inputedString)) {
            return "";
        }

        String trimedString = StringUtil.ltrim(StringUtil.rtrim(inputedString));
        String regex = "[\\s|　|・|;|:|：|；|＿|_|．|\\.|\\t|\\-|－|\\\\|\\(|\\)|「|」|『|』|【|】|\\(|\\)|（|）|\\[|\\]|《|》|\\\"|”]";
        Pattern p = Pattern.compile(regex);
        return p.matcher(trimedString).replaceAll("");
    }

    /**
     * 文字列の空白や_などを取り除き、圧縮する。
     *
     * @param inputedString
     * @return 空白などを取り除いた文字列
     */
    public static String prescribedTrimOtherThanParentheses(final String inputedString) {
        if (StringUtil.isBlank(inputedString)) {
            return "";
        }

        String trimedString = StringUtil.ltrim(StringUtil.rtrim(inputedString));
        String regex = "[\\s|　|・|;|:|：|；|＿|_|．|\\.|\\t|\\-|－|\\\\|\\\"|”]";
        Pattern p = Pattern.compile(regex);
        return p.matcher(trimedString).replaceAll("");
    }

    /**
     * 文字列中の半角カタカナを全角カタカナに変換する。<br>
     *
     * @param hanKanaString
     *            変換前文字列
     * @return 変換後文字列
     */
    public static String hanToZenKanaStr(final String hanKanaString) {
        if (hanKanaString == null) {
            return "";
        }
        if (hanKanaString.length() == 0) {
            return hanKanaString;
        } else if (hanKanaString.length() == 1) {
            return hanToZenkanaChar(hanKanaString.charAt(0)) + "";
        } else {
            StringBuilder result = new StringBuilder(hanKanaString);
            int i = 0;
            for (i = 0; i < result.length() - 1; i++) {
                char originalChar1 = result.charAt(i);
                char originalChar2 = result.charAt(i + 1);
                char margedChar = hanToZenKanaMergeChar(originalChar1,
                        originalChar2);
                if (margedChar != originalChar1) {
                    result.setCharAt(i, margedChar);
                    result.deleteCharAt(i + 1);
                } else {
                    char convertedChar = hanToZenkanaChar(originalChar1);
                    if (convertedChar != originalChar1) {
                        result.setCharAt(i, convertedChar);
                    }
                }
            }
            if (i < result.length()) {
                char originalChar1 = result.charAt(i);
                char convertedChar = hanToZenkanaChar(originalChar1);
                if (convertedChar != originalChar1) {
                    result.setCharAt(i, convertedChar);
                }
            }
            return result.toString();
        }

    }

    /*
    *//**
     * 全角カタカナを半角カタカナに変換する。<br>
     *
     * @param zenKanaStr
     *            変換前文字列
     * @return 変換後文字列
     */
    /*
     * public static String zenToHanKanaStr(String zenKanaStr) { if (zenKanaStr
     * == null) { return ""; } if (zenKanaStr.isEmpty()) { return ""; }
     * StringBuilder result = new StringBuilder(); for (int i = 0; i <
     * zenKanaStr.length(); i++) { char originalChar = zenKanaStr.charAt(i);
     * String convertedChar = zenToHankanaChar(originalChar);
     * result.append(convertedChar); } return result.toString();
     *
     * }
     *//**
     * 全角ひらがなから全角カタカナへ。<br>
     *
     * @param zenHiraganaStr
     *            変換前文字列
     * @return 変換後文字列
     */
    /*
     * public static String hiraKanaToZenKanaStr(String zenHiraganaStr) { if
     * (zenHiraganaStr == null) { return ""; } if (zenHiraganaStr.isEmpty()) {
     * return ""; } StringBuilder result = new StringBuilder(zenHiraganaStr);
     * for (int i = 0; i < result.length(); i++) { char c = result.charAt(i); if
     * (c >= 'ぁ' && c <= 'ん') { result.setCharAt(i, (char) (c - 'ぁ' + 'ァ')); } }
     * return result.toString(); }
     *//**
     * 全角カタカナから全角ひらがなへ。<br>
     *
     * @param zenKanaStr
     *            変換前文字列
     * @return 変換後文字列
     */
    /*
     * public static String zenKanaToHiraKanaStr(String zenKanaStr) { if
     * (zenKanaStr == null) { return ""; } if (zenKanaStr.isEmpty()) { return
     * ""; } StringBuilder result = new StringBuilder(zenKanaStr); for (int i =
     * 0; i < result.length(); i++) { char c = result.charAt(i); if (c >= 'ァ' &&
     * c <= 'ン') { result.setCharAt(i, (char) (c - 'ァ' + 'ぁ')); } else if (c ==
     * 'ヵ') { result.setCharAt(i, 'か'); } else if (c == 'ヶ') {
     * result.setCharAt(i, 'け'); } else if (c == 'ヴ') { result.setCharAt(i,
     * 'う'); result.insert(i + 1, '゛'); i++; } } return result.toString(); }
     *//**
     * 全角アルファベットら半角アルファベットへ。<br>
     *
     * @param zenAlphaStr
     *            変換前文字列
     * @return 変換後文字列
     */
    /*
     * public static String zenAlphaToHanStr(String zenAlphaStr) { if
     * (zenAlphaStr == null) { return ""; } if (zenAlphaStr.isEmpty()) { return
     * ""; } StringBuilder result = new StringBuilder(zenAlphaStr); for (int i =
     * 0; i < result.length(); i++) { char c = result.charAt(i); if (c >= 'ａ' &&
     * c <= 'ｚ') { result.setCharAt(i, (char) (c - 'ａ' + 'a')); } else if (c >=
     * 'Ａ' && c <= 'Ｚ') { result.setCharAt(i, (char) (c - 'Ａ' + 'A')); } }
     * return result.toString(); }
     *//**
     * 半角アルファベットから全角アルファベットへ。<br>
     *
     * @param hanAlphaStr
     *            変換前文字列
     * @return 変換後文字列
     */
    /*
     * public static String hanAlphaToZenStr(String hanAlphaStr) { if
     * (hanAlphaStr == null) { return ""; } if (hanAlphaStr.isEmpty()) { return
     * ""; } StringBuilder result = new StringBuilder(hanAlphaStr); for (int i =
     * 0; i < hanAlphaStr.length(); i++) { char c = hanAlphaStr.charAt(i); if (c
     * >= 'a' && c <= 'z') { result.setCharAt(i, (char) (c - 'a' + 'ａ')); } else
     * if (c >= 'A' && c <= 'Z') { result.setCharAt(i, (char) (c - 'A' + 'Ａ'));
     * } } return result.toString(); }
     *//**
     * 半角数字から全角数字へ。<br>
     *
     * @param hanNumStr
     *            変換前文字列
     * @return 変換後文字列
     */
    /*
     * public static String hanNumToZenStr(String hanNumStr) { if (hanNumStr ==
     * null) { return ""; } if (hanNumStr.isEmpty()) { return ""; }
     * StringBuilder result = new StringBuilder(hanNumStr); for (int i = 0; i <
     * hanNumStr.length(); i++) { char c = hanNumStr.charAt(i); if (c >= '0' &&
     * c <= '9') { result.setCharAt(i, (char) (c - '0' + '０')); } } return
     * result.toString(); }
     *//**
     * 全角数字を半角数字に変換する。<br>
     *
     * @param zenNumStr
     *            変換元文字列
     * @return 変換後文字列
     */
    /*
     * public static String zenNumToHanStr(String zenNumStr) { if (zenNumStr ==
     * null) { return ""; } if (zenNumStr.isEmpty()) { return ""; }
     * StringBuilder result = new StringBuilder(zenNumStr); for (int i = 0; i <
     * result.length(); i++) { char c = result.charAt(i); if (c >= '０' && c <=
     * '９') { result.setCharAt(i, (char) (c - '０' + '0')); } } return
     * result.toString(); }
     */
    /**
     * 変換用半角カナテーブル。<br>
     */
    private static final char[] HAN_KANA_TBL = { '｡', '｢', '｣', '､', '･', 'ｦ',
            'ｧ', 'ｨ', 'ｩ', 'ｪ', 'ｫ', 'ｬ', 'ｭ', 'ｮ', 'ｯ', 'ｰ', 'ｱ', 'ｲ', 'ｳ',
            'ｴ', 'ｵ', 'ｶ', 'ｷ', 'ｸ', 'ｹ', 'ｺ', 'ｻ', 'ｼ', 'ｽ', 'ｾ', 'ｿ', 'ﾀ',
            'ﾁ', 'ﾂ', 'ﾃ', 'ﾄ', 'ﾅ', 'ﾆ', 'ﾇ', 'ﾈ', 'ﾉ', 'ﾊ', 'ﾋ', 'ﾌ', 'ﾍ',
            'ﾎ', 'ﾏ', 'ﾐ', 'ﾑ', 'ﾒ', 'ﾓ', 'ﾔ', 'ﾕ', 'ﾖ', 'ﾗ', 'ﾘ', 'ﾙ', 'ﾚ',
            'ﾛ', 'ﾜ', 'ﾝ', 'ﾞ', 'ﾟ' };

    /**
     * 変換用全角カナテーブル。<br>
     */
    private static final char[] ZEN_AKANA_TBL = { '。', '「', '」', '、', '・', 'ヲ',
            'ァ', 'ィ', 'ゥ', 'ェ', 'ォ', 'ャ', 'ュ', 'ョ', 'ッ', 'ー', 'ア', 'イ', 'ウ',
            'エ', 'オ', 'カ', 'キ', 'ク', 'ケ', 'コ', 'サ', 'シ', 'ス', 'セ', 'ソ', 'タ',
            'チ', 'ツ', 'テ', 'ト', 'ナ', 'ニ', 'ヌ', 'ネ', 'ノ', 'ハ', 'ヒ', 'フ', 'ヘ',
            'ホ', 'マ', 'ミ', 'ム', 'メ', 'モ', 'ヤ', 'ユ', 'ヨ', 'ラ', 'リ', 'ル', 'レ',
            'ロ', 'ワ', 'ン', '゛', '゜' };

    /**
     * 作業用半角カナテーブルの最初の文字を定義。<br>
     */
    private static final char HAN_AKANA_FIRST_CHAR = HAN_KANA_TBL[0];

    /**
     * 作業用半角カナテーブルの最後の文字を定義。<br>
     */
    private static final char HAN_KANA_LAST_CHAR = HAN_KANA_TBL[HAN_KANA_TBL.length - 1];

    /**
     * 半角カタカナから全角カタカナへ変換。<br>
     *
     * @param hanKana
     *            変換前の文字
     * @return 変換後の文字
     */
    protected static char hanToZenkanaChar(final char hanKana) {
        if (hanKana >= HAN_AKANA_FIRST_CHAR && hanKana <= HAN_KANA_LAST_CHAR) {
            return ZEN_AKANA_TBL[hanKana - HAN_AKANA_FIRST_CHAR];
        } else {
            return hanKana;
        }
    }

    /**
     * 半角カタカナから全角カタカナへ変換する処理で使う内部処理用メソッド。<br>
     * <br>
     * 2文字目が濁点・半濁点で、1文字目に加えることができる場合は、合成した文字を返す。<br>
     * 合成ができないときは、1文字目のみを変換して返す。<br>
     *
     * @param hanKana1
     *            変換前の1文字目
     * @param hanKana2
     *            変換前の2文字目
     * @return 変換後の文字
     */
    protected static char hanToZenKanaMergeChar(final char hanKana1, final char hanKana2) {
        if (hanKana2 == 'ﾞ') {
            if (" ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎ ".indexOf(hanKana1) > 0) {
                switch (hanKana1) {
                case 'ｶ':
                    return 'ガ';
                case 'ｷ':
                    return 'ギ';
                case 'ｸ':
                    return 'グ';
                case 'ｹ':
                    return 'ゲ';
                case 'ｺ':
                    return 'ゴ';
                case 'ｻ':
                    return 'ザ';
                case 'ｼ':
                    return 'ジ';
                case 'ｽ':
                    return 'ズ';
                case 'ｾ':
                    return 'ゼ';
                case 'ｿ':
                    return 'ゾ';
                case 'ﾀ':
                    return 'ダ';
                case 'ﾁ':
                    return 'ヂ';
                case 'ﾂ':
                    return 'ヅ';
                case 'ﾃ':
                    return 'デ';
                case 'ﾄ':
                    return 'ド';
                case 'ﾊ':
                    return 'バ';
                case 'ﾋ':
                    return 'ビ';
                case 'ﾌ':
                    return 'ブ';
                case 'ﾍ':
                    return 'ベ';
                case 'ﾎ':
                    return 'ボ';
                default:
                    break;
                }
            }
        } else if (hanKana2 == 'ﾟ') {
            if (" ﾊﾋﾌﾍﾎ ".indexOf(hanKana1) > 0) {
                switch (hanKana1) {
                case 'ﾊ':
                    return 'パ';
                case 'ﾋ':
                    return 'ピ';
                case 'ﾌ':
                    return 'プ';
                case 'ﾍ':
                    return 'ペ';
                case 'ﾎ':
                    return 'ポ';
                default:
                    break;
                }
            }
        }
        return hanKana1;
    }

    /**
     * 全角カナから半角カナへ変換する時に使う変換用テーブル。<br>
     * <br>
     * 全角カタカナ。<br>
     */
    /*
     * private static final char[] ZEN_KANA_A = { 'ァ', 'ア', 'ィ', 'イ', 'ゥ', 'ウ',
     * 'ェ', 'エ', 'ォ', 'オ', 'カ', 'ガ', 'キ', 'ギ', 'ク', 'グ', 'ケ', 'ゲ', 'コ', 'ゴ',
     * 'サ', 'ザ', 'シ', 'ジ', 'ス', 'ズ', 'セ', 'ゼ', 'ソ', 'ゾ', 'タ', 'ダ', 'チ', 'ヂ',
     * 'ッ', 'ツ', 'ヅ', 'テ', 'デ', 'ト', 'ド', 'ナ', 'ニ', 'ヌ', 'ネ', 'ノ', 'ハ', 'バ',
     * 'パ', 'ヒ', 'ビ', 'ピ', 'フ', 'ブ', 'プ', 'ヘ', 'ベ', 'ペ', 'ホ', 'ボ', 'ポ', 'マ',
     * 'ミ', 'ム', 'メ', 'モ', 'ャ', 'ヤ', 'ュ', 'ユ', 'ョ', 'ヨ', 'ラ', 'リ', 'ル', 'レ',
     * 'ロ', 'ヮ', 'ワ', 'ヰ', 'ヱ', 'ヲ', 'ン', 'ヴ', 'ヵ', 'ヶ' };
     *//**
     * 全角カナから半角カナへ変換する時に使う変換用テーブル。<br>
     * <br>
     * 半角カタカナ。<br>
     */
    /*
     * private static final String[] HANK_KANA_A = { "ｧ", "ｱ", "ｨ", "ｲ", "ｩ",
     * "ｳ", "ｪ", "ｴ", "ｫ", "ｵ", "ｶ", "ｶﾞ", "ｷ", "ｷﾞ", "ｸ", "ｸﾞ", "ｹ", "ｹﾞ", "ｺ",
     * "ｺﾞ", "ｻ", "ｻﾞ", "ｼ", "ｼﾞ", "ｽ", "ｽﾞ", "ｾ", "ｾﾞ", "ｿ", "ｿﾞ", "ﾀ", "ﾀﾞ",
     * "ﾁ", "ﾁﾞ", "ｯ", "ﾂ", "ﾂﾞ", "ﾃ", "ﾃﾞ", "ﾄ", "ﾄﾞ", "ﾅ", "ﾆ", "ﾇ", "ﾈ", "ﾉ",
     * "ﾊ", "ﾊﾞ", "ﾊﾟ", "ﾋ", "ﾋﾞ", "ﾋﾟ", "ﾌ", "ﾌﾞ", "ﾌﾟ", "ﾍ", "ﾍﾞ", "ﾍﾟ", "ﾎ",
     * "ﾎﾞ", "ﾎﾟ", "ﾏ", "ﾐ", "ﾑ", "ﾒ", "ﾓ", "ｬ", "ﾔ", "ｭ", "ﾕ", "ｮ", "ﾖ", "ﾗ",
     * "ﾘ", "ﾙ", "ﾚ", "ﾛ", "ﾜ", "ﾜ", "ｲ", "ｴ", "ｦ", "ﾝ", "ｳﾞ", "ｶ", "ｹ" };
     *//**
     * 全角カナから半角カナへの変換時に使う。テーブルの最初の文字を示す。<br>
     */
    /*
     * private static final char ZEN_KANA_FIRST_CHAR_A = ZEN_KANA_A[0];
     *//**
     * 全角カナから半角カナへの変換時に使う。テーブルの最後の文字を示す。<br>
     */
    /*
     * private static final char ZEN_KANA_LAST_CHAR_A =
     * ZEN_KANA_A[ZEN_KANA_A.length - 1];
     *//**
     * 全角カナから半角カナへの変換の内部処理。<br>
     *
     * @param zenKanaChar
     *            変換元文字列
     * @return 変換後文字列
     */
    /*
     * protected static String zenToHankanaChar(char zenKanaChar) { if
     * (zenKanaChar >= ZEN_KANA_FIRST_CHAR_A && zenKanaChar <=
     * ZEN_KANA_LAST_CHAR_A) { return HANK_KANA_A[zenKanaChar -
     * ZEN_KANA_FIRST_CHAR_A]; } else { return String.valueOf(zenKanaChar); } }
     */
}
