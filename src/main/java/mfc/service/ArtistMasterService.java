package mfc.service;

import mfc.entity.ArtistMr;

import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.util.StringUtil;

public class ArtistMasterService extends AbstractService<ArtistMr> {

    public ArtistMr fetchSingle(final String id){
        if(StringUtil.isBlank(id)){
            return null;
        }
        return select().where(
                    new SimpleWhere()
                        .eq("artistCode",id)
                )
                .getSingleResult();
    }




}