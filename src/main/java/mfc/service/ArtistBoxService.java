package mfc.service;

import java.util.List;
import java.util.Map;

import mfc.entity.ArtistTypeList;
import mfc.utilities.InstanceManager;

public class ArtistBoxService extends AbstractService<ArtistTypeList> {

    public final Map<String,String> getMapOfSameBoxArtistList(){
        Map<String,String> returnMap = InstanceManager.newAtomicMap();
        List<ArtistTypeList> boxArtistList = select().getResultList();
        if(boxArtistList != null){
            for(ArtistTypeList a : boxArtistList){
                StringBuilder sb = new StringBuilder();
                String tmp = returnMap.get(a.getMusicTypeCode());
                if(tmp == null){
                    sb.append(a.getArtistCode());
                }else{
                    sb.append(tmp);
                    sb.append(",");
                    sb.append(a.getArtistCode());
                }
                returnMap.put(a.getMusicTypeCode(), sb.toString());
            }
        }
        return returnMap;
    }

    public final int getAllCount(){
        long tmpCount = select().getCount();
        if(tmpCount > (long)Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else{
            return (int)tmpCount;
        }
    }

}
