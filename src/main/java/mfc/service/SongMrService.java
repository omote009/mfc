package mfc.service;

import java.util.List;

import mfc.entity.SongMr;
import mfc.utilities.InstanceManager;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.util.StringUtil;

public class SongMrService extends AbstractService<SongMr> {

    /**
     * 曲キーを元に曲の動画を示すオブジェクトを１件返す
     * @param songKey
     * @return
     */
    public final SongMr fetchSingle(final String songKey){
        if(StringUtil.isBlank(songKey)){
            return null;
        }
        return select().where(new SimpleWhere().eq("songKey", songKey)).getSingleResult();
    }

    /**
     * 同じアーティストの曲をリストで返す
     * @param artistCode
     * @return
     */
    public final List<SongMr> fetchListFronArtistCode(final String artistCode){
        List<SongMr> ret = InstanceManager.newNotAtomicList();
        if(StringUtil.isBlank(artistCode)){
            return ret;
        }
        return select().where(new SimpleWhere().eq("artistCode", artistCode)).getResultList();
    }

    /**
     * 同じキーのレコードがあれば更新、なければ挿入する。
     *
     * @param song
     * @return
     */
    public final int add(final SongMr song){
        if(song == null){
            return 0;
        }
        SongMr chk = fetchSingle(song.getSongKey());
        if(chk == null){
            return insert(song);
        }else{
            return update(song);
        }
    }

    /**
     * キーを指定して削除する。
     *
     * @param songKey
     * @return
     */
    public final int remove(final String songKey){
        if(StringUtil.isBlank(songKey)){
            return 0;
        }
        SongMr chk = fetchSingle(songKey);
        if(chk == null){
            return 0;
        }else{
            return delete(chk);
        }

    }

    public final int remove(final SongMr obj){
        if(obj == null){
            return 0;
        }
        SongMr chk = fetchSingle(obj.getSongKey());
        if(chk == null){
            return 0;
        }else{
            return delete(chk);
        }

    }

}
