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

}
