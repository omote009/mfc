package mfc.service;

import java.util.List;

import mfc.entity.ArtistMr;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.util.StringUtil;

public class ArtistMasterService extends AbstractService<ArtistMr> {

    public final ArtistMr fetchSingle(final String id) {
        if (StringUtil.isBlank(id)) {
            return null;
        }
        return select().where(
                new SimpleWhere()
                        .eq("artistCode", id)
                )
                .getSingleResult();
    }

    public final List<ArtistMr> fetchAll(){
        return select().getResultList();
     }

    public final int addEvaluatePointFromView(final String artistCode){
        int returnCode = 0;
        if(StringUtil.isBlank(artistCode)){
            return 0;
        }
        ArtistMr mr = fetchSingle(artistCode);
        if(mr == null){
            return 0;
        }
        Long tmpValue = mr.getArtistEvaluateValue();
        if(tmpValue == null){
            mr.setArtistEvaluateValue(Long.valueOf(0L));
        }else{
            mr.setArtistEvaluateValue(Long.valueOf(tmpValue.longValue() +1L));
        }
        returnCode = jdbcManager.update(mr).execute();

        return returnCode;
    }



}
