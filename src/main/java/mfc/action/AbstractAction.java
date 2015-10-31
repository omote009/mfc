package mfc.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
/*
 * 前バージョンとの互換性維持のためコメントで残している。
 * マージするときは、このブロックコメントを解除する。
import mfc.consts.Returns;
import mfc.dto.ArtistMrSessionControlDto;
import mfc.dto.CommonSessionDto;
import mfc.dto.EventEntrySessionParamDto;
import mfc.dto.EventSessionParamDto;
import mfc.dto.EventSiteSessionControlDto;
import mfc.dto.LoginedUserDto;
import mfc.dto.MessageSessionControlDto;
import mfc.dto.MyFavoriteSessionDto;
import mfc.dto.MyPageSessionControlDto;
import mfc.dto.PagingSessionControlDto;
import mfc.dto.ReturnSessionControlDto;
import mfc.dto.TopPageSessionControlDto;
import mfc.form.AbstractForm;
import mfc.service.LoginCheckService;
import mfc.service.LongLiveControlService;
import mfc.service.PrefectureListService;
import mfc.service.UserMrService;
import mfc.utils.MyDateUtil;*/

 /**
 *  アクションの基底クラス
 *
 * @version 1.1
 * @author omote
 *
 */
public class AbstractAction {

    // クッキー情報を操作するためのMAP
    @Resource
    public Map<String, Cookie> cookie;

/*
 * 前バージョンとの互換性維持のためコメントで残している。
 * マージするときは、このブロックコメントを解除する。
 *
 * @ActionForm
    @Resource(name = "abstractForm")
    protected AbstractForm form;

    //**********************************************************************************
    // Common service
    //*********************************************************************************

    // ログインユーザ情報（セッションスコープ）
    @Resource
    public LoginedUserDto loginedUserDto;

    // ログイン認証を行うサービス
    @Resource
    public LoginCheckService loginCheckService;

    // ログイン情報保存処理用
    @Resource
    public LongLiveControlService longLiveControlService;

    // ユーザMRに対する取り出し・更新操作を行う。
    @Resource
    protected UserMrService userMrService;

    //************************************************************************************
    // HTTP
    //***********************************************************************************

    // サーブレットリクエストを受け取って格納するクラス
    @Resource
    public HttpServletRequest request;

    // サーブレットレスポンスを格納するクラス
    @Resource
    public HttpServletResponse response;

    // リクエストパラメータを受け取るマップ
    @Resource
    public Map<String, String> requestScope;


    // オプションパラメータを受け取るマップ
    @Resource
    public Map<String, String> reqParams;

    // 県リスト取得
    @Resource
    protected PrefectureListService prefectureListService;

    //************************************************************************************
    //  DTOS
    //*************************************************************************************

    // 汎用共通セッション管理情報。 直リンクで動作に問題が出る場合に直リンクを禁止するための情報などを置く
    @Resource
    public CommonSessionDto commonSessionDto;

    // 画面間情報受け渡し用
    @Resource
    public TopPageSessionControlDto topPageSessionControlDto;

    // 画面間情報受け渡し用
    @Resource
    public ArtistMrSessionControlDto artistMrSessionControlDto;

    // 複数の画面から遷移する画面で戻り先をコントロールする
    @Resource
    public ReturnSessionControlDto returnSessionControlDto;

    // 画面間でメッセージのやりとりをする場合に利用する。
    @Resource
    public MessageSessionControlDto messageSessionControlDto;

    // イベントエントリー画面遷移時の情報を引き継ぐためのクラス
    @Resource
    public EventEntrySessionParamDto eventEntrySessionParamDto;

    // ライブ・イベント用検索条件保存DTOクラス（セッションスコープ）
    @Resource
    public EventSessionParamDto eventSessionParamDto;

    @Resource
    protected EventSiteSessionControlDto eventSiteSessionControlDto;

    @Resource
    public MyFavoriteSessionDto myFavoriteSessionDto;

    @Resource
    protected MyPageSessionControlDto myPageSessionControlDto;

    @Resource
    public PagingSessionControlDto pagingSessionControlDto;

    //**********************************************************************************************
    // LOG
    //*********************************************************************************************

    Logger log = Logger.getLogger(AbstractAction.class);

     *//**
     * RUNTIMEEXCEPTION　に対応したエラーメッセージ<br />
     * DBアクセスを下位で行っているAction内のメソッドは全てTry・Catchで囲むことをルールとしている。<br />
     * 特に何もしない場合でも、このメソッドでログに書き出す。<br />
     * Serviceクラス内でSQLの例外チェックは行っているが、SQL構文エラー等実行時例外は拾えないのでここで拾う。<br />
     *//*
    public void errorLogWrite(final Exception e) {

        log.error("RuntimeException):", e);
    }

    *//**
     * ログインに関するログ記録
     *
     * @param id
     * @param status
     *//*
    public void logWriteLoginStatus(final String id, final boolean status) {
        StringBuilder sb = new StringBuilder();
        if (status) {
            // Login OK
            sb.append("00:");
        } else {
            // Login NG
            sb.append("10:");
        }
        sb.append(id);
        sb.append(":");
        sb.append(MyDateUtil.getCurrentDatetimeInString());
        log.info(sb.toString());
    }

    *//**
     * ログインに関するログ記録(継続）
     *
     * @param id
     * @param status
     *//*
    public void logWriteLoginEvenStatus(final String id, final boolean status) {
        StringBuilder sb = new StringBuilder();
        if (status) {
            // Login OK
            sb.append("01:");
        } else {
            // Login NG
            sb.append("11:");
        }
        sb.append(id);
        sb.append(":");
        sb.append(MyDateUtil.getCurrentDatetimeInString());
        log.info(sb.toString());
    }

    *//**
     * ログオフに関するログ記録
     *
     * @param id
     * @param status
     *//*
    public void logWriteLogOffStatus(final String id, final boolean status) {
        StringBuilder sb = new StringBuilder();
        if (status) {
            // LOGOFF OK
            sb.append("30:");
        } else {
            // LOGOFF NG
            sb.append("40:");
        }
        sb.append(id);
        sb.append(":");
        sb.append(MyDateUtil.getCurrentDatetimeInString());
        log.info(sb.toString());

    }

    *//**
     * 会員登録に関するログ記録
     *
     * @param id
     * @param status
     *//*
    public void logWriteSignupStatus(final String id, final boolean status) {
        StringBuilder sb = new StringBuilder();
        if (status) {
            // Signup Entry OK
            sb.append("50:");
        } else {
            // Signup Entry NG
            sb.append("60:");
        }
        sb.append(id);
        sb.append(":");
        sb.append(MyDateUtil.getCurrentDatetimeInString());
        log.info(sb.toString());

    }

    //*******************************************************************
    //
    //*******************************************************************

    *//**
     * Overtide用。あってもなくても良いメソッドだが、消す作業が面倒なので残している」。<br />
     * 単純にトップ画面に戻る。<br />
     *
     * @return JSP_NAME
     *//*
    @Execute(validator = false)
    public String index() {
        return Returns.TO_TOPPAGE;
    }
*/
}
