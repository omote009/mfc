package mfc.service;

import mfc.entity.RelevantData;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.util.StringUtil;

public class RelevantDataService extends AbstractService<RelevantData> {
    /**
     * songKeyを受け取り、１レコードを取得して返す。
     *
     * @param relevantKey
     * @return
     */
    public final RelevantData fetchSingle(final String relevantKey) {
        /*
         * SenseAndSong sg = new SenseAndSong(); sg.setSongKey("Xyz01Abcdef");
         * sg.setParamStr01("1111110000"); sg.setParamStr02("0000000000");
         * sg.setParamStr03("1111111100"); sg.setParamStr04("0000000000");
         * sg.setParamStr05("0000000000"); sg.setParamStr06("0000000000");
         * sg.setParamStr07("0000000000"); sg.setParamStr08("0000000000");
         * sg.setParamStr09("0000000000"); sg.setParamStr10("0000000000");
         * sg.setParamStr11("0000000000"); sg.setParamStr12("0000000000");
         * sg.setParamStr13("0000000000"); sg.setParamStr14("0000000000");
         * sg.setParamStr15("0000000000"); sg.setWait(14L); return sg;
         */
        if (StringUtil.isBlank(relevantKey)) {
            return null;
        }
        return select().where(new SimpleWhere().eq("relevantKey", relevantKey))
                .getSingleResult();

    }

    /**
     * すでにレコードがあれば更新、なければ挿入を行う。
     *
     * @param newRec
     * @return
     */
    public final int add(final RelevantData newRec){
        if(newRec == null){
            return 0;
        }
        RelevantData chk = fetchSingle(newRec.getRelevantKey());
        if(chk == null){
            return insert(newRec);
        }else{
            return update(newRec);
        }
    }

    /**
     * キーを指定して一致するレコードを削除する。
     *
     * @param relevantKey
     * @return
     */
    public final int remove(final String relevantKey){
        if (StringUtil.isBlank(relevantKey)) {
            return 0;
        }
        RelevantData chk = fetchSingle(relevantKey);
        if(chk == null){
            return 0;
        }else{
            return delete(chk);
        }

    }

    public final int remove(final RelevantData obj){
        if(obj == null){
            return 0;
        }
        RelevantData chk = fetchSingle(obj.getRelevantKey());
        if(chk == null){
            return 0;
        }else{
            return delete(chk);
        }
    }

}
