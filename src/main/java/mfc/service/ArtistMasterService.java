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

        return calcEvaluatePoint(artistCode,1L);

    }

    public final int calcEvaluatePoint(final String artistCode,final long value){

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
            if(value < 0){
                if((value * -1L) < tmpValue.longValue()){
                    mr.setArtistEvaluateValue(Long.valueOf(tmpValue.longValue() + value));
                }else{
                    // 元の値より、引く値が大きい時はゼロにしてしまう。
                    mr.setArtistEvaluateValue(Long.valueOf(0L));
                }
            }else{
                mr.setArtistEvaluateValue(Long.valueOf(tmpValue.longValue() + value));
            }

        }
        returnCode = jdbcManager.update(mr).execute();

        return returnCode;
    }



}
