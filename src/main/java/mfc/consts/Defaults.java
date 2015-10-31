package mfc.consts;

/*import mfc.utils.MfcStringUtil;

import org.seasar.framework.util.StringUtil;
*/

/**
 * Formの共通の初期値を管理するクラス<br />
 * 定数でなくgetterにしているのは、将来的に初期値を外出しにすることを考えているため。<br />
 * プロパティファイルがいいか、DBがいいかは思案中。<br />
 *
 * @author omote
 *
 */
public class Defaults {

    private Defaults() {

    }

    //　開発時　false　本番リリース時　true　に修正
    public static boolean isPublic(){
        return false;
    }

    /*// ページあたりの一覧表示上限行数
    public static Integer getDefaultPageSize(){
        return Integer.valueOf(50);
    }

    //　スーパーユーザタイプ
    public static String getUserTypeA(){
        return "A";
    }

    //　ユーザID登録時のミニマム文字数
    public static int getMinUserIdLength(){
        return 3;
    }

    //　ユーザID登録時のミニマム文字数
    public static int getMaxUserNameLength(){
        return 150;
    }

    //　パスワード登録時のミニマム文字数
    public static int getMinPasswordLength(){
        return 10;
    }


    *//**
     * チケットIDの桁数<br />
     *
     * @return
     *//*
    public static int getTicketIdLength(){
        return 18;
    }

    *//**
     * イベントIDの桁数<br />
     *
     * @return
     *//*
    public static int getEventIdLength(){
        return 15;
    }

    *//**
     * アーティストコードの桁数<br />
     * @return
     *//*
    public static int getArtistCodeLength(){
        return 10;
    }

    *//**
     * アーティストコードの桁数<br />
     * @return
     *//*
    public static int getEventSiteCodeLength(){
        return 9;
    }

    public static String getLongLiveKey(){
        return "LONGLIVEID";
    }

    *//**
     *  SElECTリストの先頭に置くキー（００）を返す
     *//*
    public static String getDefaultSelectedKeyValue() {
        return MfcStringUtil.toZeroFillNumberInt(0, 2);
    }

    *//**
     *  SElECTリストの先頭に置くキー文字列（すべて）を返す
     *//*
    public static String getDefaultSelectedTitleValue() {
        return "すべて";
    }

    *//**
     * 共通 SELECTのオプションにセットする文字数最大値の初期値<br />
     * これ以上の長さにならないようにカットする
     *//*
    public static int getOptionMaxLength() {
        return 14;
    }

    *//**
     * [SubL] 県のSELECTリストで選択されたKEYを収める文字列<br />
     * 		  初期値は　27（大阪府）
     *//*
    public static String getPrefectureSelectedInitialValue() {
        return  "27";
    }

    *//**
     * [SubL] 県のSELECTリストで選択されたKEYを収める文字列<br />
     * 		  初期値は　27（大阪府）
     *//*
    public static String getMinicipalitySelectedInitialValue() {
        return  "2710";
    }

    *//**
     * [SubL] 音楽ジャンルの選択初期値<br />
     * 		  初期値は　0000000001　ブルース
     *//*
    public static String getCategorySelectedInitialValue() {
        return getDefaultSelectedKeyValue();
    }

    *//**
     * [SubL] 音楽タイプの選択初期値<br />
     * 		  初期値は　0000000001　ブルース
     *//*
    public static String getTypeSelectedInitialValue() {
        return getDefaultSelectedKeyValue();
    }


    *//**
     * [SubL] 日付の表示期間を指定する<br />
     * 		  初期値は７
     *//*
    public static String getSearchInputDateInDueTime() {
        return "30";
    }


    *//**
     *  TEXT入力の初期値（空文字列）を返す
     *//*
    public static String getDefaultTextValue() {
        return "";
    }


    *//**
     * ライブハウスで料金検索で入力された文字列の初期値FROM
     *//*
    public static String getIndexSubLFeeSearchInputFrom() {
        return  "";
    }

    *//**
     * ライブハウスで料金検索で入力された文字列の初期値To
     *//*
    public static String getIndexSubLFeeSearchInputTo() {
        return "";
    }

    *//**
     * ライブイベントリストのメイン表示欄の最大文字数
     *//*
    public static Integer getEventListMaxLength() {
        return 45;
    }

    public static Integer getEventListMaxLongLength() {
        return 55;
    }
    *//**
     * フッターに表示するニュースの最大行数
     *//*
    public static int getNewsMaxRow() {
        return 10;
    }

    *//**
     * デフォルト画像名（ユーザ画像）
     *//*
    public static String getDefaultUserImageFileName() {
        return "avatar.jpg";
    }

    *//**
     * 一回で付与可能な得点の最大値
     *//*
    public static Long getMaxEvalValue() {
        return 5L;
    }

    *//**
     * booleanに対応する(TRUE)<br />
     *//*
    public static String getTrue() {
        return "1";
    }

    *//**
     * booleanに対応する（FALSE)<br />
     * @return
     *//*
    public static String getFalse() {
        return "0";
    }

    *//**
     * イベント　及び　イベントサイトで音楽イベントに対応する。<br />
     * @return
     *//*
    public static String getEventType(){
        return "1";
    }

    *//**
     * イベント　及び　イベントサイトでセッションに対応する。<br />
     * @return
     *//*
    public static String getSessionType(){
        return "2";
    }

    *//**
     * アーティストランク一覧に表示するしきい値
     * @return
     *//*
    public static Long getDefaultsArtistRankBorder(){
        return Long.valueOf(1L);
    }


    *//**
     * ファイルアップロードの最大サイズ<br />
     * @return
     *//*
    public static int getFileUploadMaxSize(){
        return 1048546;
    }

    *//**
     * セッションイベントのパート別募集で特に楽器等を指定しない場合にわりあてるダミーコード。<br />
     * @return
     *//*
    public static String getPartsOtherCode(){

        return "ZOTHER";

    }
    public static String getPartsOtherName(){
        return "特にパートを指定しない。";
    }

    public static String getDefaultUserImageFileName(final String Sex){
        if(StringUtil.isBlank(Sex)){
            return "";
        }else{
            if(Sex.equals("WOMAN")){
                return "woman.png";
            }else{
                return "man.png";
            }
        }
    }

    public static String getCheckedDefaultUserBirthYear(final String birthYear){

        if(StringUtil.isNumber(birthYear)){
            Long check = Long.valueOf(birthYear);
            if(check > 1900L && check < 2099L ){
                return birthYear;
            }
        }
        return "9999";
    }

    public static String getDefaultUrlTitle(){
        return PropConst.get("mfc.artist_mr_entry.url_title");
    }
*/



}
