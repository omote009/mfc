package mfc.service;

import java.util.List;

import mfc.entity.SenseParamMr;
import mfc.utilities.InstanceManager;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.util.StringUtil;

public class SenseParamMrService extends AbstractService<SenseParamMr> {
    /**
     * 曲キーを元に曲の動画を示すオブジェクトを１件返す
     * @param paramKey
     * @return
     */
    public final SenseParamMr fetchSingle(final String paramKey,final String subKey){
        if(StringUtil.isBlank(paramKey) || StringUtil.isBlank(subKey)){
            return null;
        }
        return select().where(new SimpleWhere().eq("paramKey", paramKey).eq("subKey", subKey)).getSingleResult();
    }

    /**
     * 同じparamKeyの内容をリストで返す
     * @param artistCode
     * @return
     */
    public final List<SenseParamMr> fetchListFronArtistCode(final String paramKey){
        List<SenseParamMr> ret = InstanceManager.newNotAtomicList();
        if(StringUtil.isBlank(paramKey)){
            return ret;
        }
        return select().where(new SimpleWhere().eq("paramKey", paramKey)).getResultList();
    }

    /**
     * 同じキーのレコードがあれば更新、なければ挿入する。
     *
     * @param song
     * @return
     */
    public final int add(final SenseParamMr paramMr){
        if(paramMr == null){
            return 0;
        }
        SenseParamMr chk = fetchSingle(paramMr.getParamKey(),paramMr.getSubKey());
        if(chk == null){
            return insert(paramMr);
        }else{
            return update(paramMr);
        }
    }

    /**
     * キーを指定して削除する。
     *
     * @param songKey
     * @return
     */
    public final int remove(final String paramKey,final String subKey){
        if(StringUtil.isBlank(paramKey) || StringUtil.isBlank(subKey)){
            return 0;
        }
        SenseParamMr chk = fetchSingle(paramKey,subKey);
        if(chk == null){
            return 0;
        }else{
            return delete(chk);
        }
    }

    public final int remove(final SenseParamMr obj){
        if(obj == null){
            return 0;
        }
        SenseParamMr chk = fetchSingle(obj.getParamKey(),obj.getSubKey());
        if(chk == null){
            return 0;
        }else{
            return delete(chk);
        }

    }

}
