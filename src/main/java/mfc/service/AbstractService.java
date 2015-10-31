package mfc.service;

import org.seasar.extension.jdbc.service.S2AbstractService;
/*
import mfc.consts.Defaults;
import mfc.dto.LoginedUserDto;
import mfc.utils.MfcStringUtil;
import org.seasar.extension.jdbc.SqlLog;
*/

/**
 * Serviceクラスのラッパー<br />
 * 必要に応じて、メソッドを追加する。<br />
 *
 * @author omote
 *
 */
public class AbstractService<T> extends S2AbstractService<T> {


    protected AbstractService() {
        super();
    }

    /*
     * 前バージョンとの互換性維持のためコメントで残している。
     * マージするときは、このブロックコメントを解除する。


    @Resource
    protected UserTransaction userTransaction;


    // サービス用のロガー
    protected Logger log = Logger.getLogger(AbstractService.class);

    // SQLのログを出力する
    protected SqlLogRegistry sqlLogRegistry = SqlLogRegistryLocator.getInstance();


     @Resource
    protected LoginedUserDto loginedUserDto;

    *//**
     * SQLのイメージと実行時間のログを出力する<br />
     *
     * @param start
     * @param end
     *//*
    public void sqlLogWrite(final long start,final long end) {
        if(Defaults.isPublic() == false){
            SqlLog sqlLog = sqlLogRegistry.getLast();
            log.info(MfcStringUtil.toSqlLog(sqlLog));
            log.info(MfcStringUtil.toFormattedTimeInStringForLog(end - start));
        }

    }

    *//**
     * SQL エラー発生時のログ
     *//*
    public void sqlErrorLogWrite(final Exception e) {
        log.error("SQL ERROR!:",e);
    }

    *//**
     * エラー発生時のメッセージ
     *//*
    private String message;

    *//**
     * @return message
     *//*
    public String getMessage() {
        return message;
    }

    *//**
     * @param message セットする message
     *//*
    public void setMessage(String message) {
        this.message = message;
    }

*/


}
