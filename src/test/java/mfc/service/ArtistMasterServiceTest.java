package mfc.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class ArtistMasterServiceTest {


    @Resource
    private ArtistMasterService artistMasterService;

    @Test
    public void testFetchSingle() {
          String testKey = "0kDcUtjryG";
          assertTrue("LAGOON".equals(artistMasterService.fetchSingle(testKey).getArtistName1()));
    }

    @Test
    public void testAddPoint(){
        String testKey = "0kDcUtjryG";
        Long lb =artistMasterService.fetchSingle(testKey).getArtistEvaluateValue();
        long tmpLongBefore = 0L;
        if(lb == null){

        }else{
            tmpLongBefore = lb.longValue();
        }

        artistMasterService.addEvaluatePointFromView(testKey);
        Long la =artistMasterService.fetchSingle(testKey).getArtistEvaluateValue();
        long tmpLongAfter = la.longValue();
        assertTrue((tmpLongBefore +1L)== tmpLongAfter );
        assertTrue(artistMasterService.addEvaluatePointFromView("") == 0);

    }

}
