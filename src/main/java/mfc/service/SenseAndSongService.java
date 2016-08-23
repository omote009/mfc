package mfc.service;

import java.util.List;

import mfc.entity.SenseAndSong;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.util.StringUtil;

public class SenseAndSongService extends AbstractService<SenseAndSong> {

    /**
     * songKeyを受け取り、１レコードを取得して返す。
     *
     * @param songKey
     * @return
     */
    public final SenseAndSong fetchSingle(final String songKey) {
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
        if (StringUtil.isBlank(songKey)) {
            return null;
        }
        return select().where(new SimpleWhere().eq("songKey", songKey))
                .getSingleResult();

    }

    /**
     * すでにレコードがあれば更新、なければ挿入を行う。
     *
     * @param newRec
     * @return
     */
    public final int add(final SenseAndSong newRec){
        if(newRec == null){
            return 0;
        }
        SenseAndSong chk = fetchSingle(newRec.getSongKey());
        if(chk == null){
            return insert(newRec);
        }else{
            return update(newRec);
        }
    }

    /**
     * キーを指定して一致するレコードを削除する。
     *
     * @param songKey
     * @return
     */
    public final int remove(final String songKey){
        if (StringUtil.isBlank(songKey)) {
            return 0;
        }
           SenseAndSong chk = fetchSingle(songKey);
        if(chk == null){
            return 0;
        }else{
            return delete(chk);
        }

    }

    /**
     * 削除する
     * @param obj
     * @return
     */
    public final int remove(final SenseAndSong obj){
        if(obj == null){
            return 0;
        }

        SenseAndSong chk = fetchSingle(obj.getSongKey());
        if(chk != null){
            return delete(chk);
        }

        return 0;
    }


    /**
     * waitからdelta分の差異の範囲に一致するレコードをリストで取得する。
     *
     * @param wait
     * @param delta
     * @return
     */
    public final List<SenseAndSong> fetchListFromWait(final long wait,final long delta){
        Long maxWait;
        Long minWait;
        long wDelta = 0L;
        if(delta > 0L){
            wDelta = delta;
        }
        if(wait < 0L){
            maxWait = Long.valueOf(0 + wDelta);
        }else{
            maxWait = Long.valueOf(wait + wDelta);
        }

        if((wait - delta) < 0L){
            minWait = Long.valueOf(0L);
        }else{
            minWait = Long.valueOf(wait - delta);
        }
        return select().where(new SimpleWhere().le("wait", maxWait).ge("wait", minWait))
                .getResultList();
    }






}
