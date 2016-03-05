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

    @Test
    public void testCalcPoint(){
        String testKey = "ahlw3JZhob";
        Long lb =artistMasterService.fetchSingle(testKey).getArtistEvaluateValue();
        long tmpLongBefore = 0L;
        if(lb == null){

        }else{
            tmpLongBefore = lb.longValue();
        }

        artistMasterService.calcEvaluatePoint(testKey, 2L);
          Long la =artistMasterService.fetchSingle(testKey).getArtistEvaluateValue();
        long tmpLongAfter = la.longValue();
        assertTrue((tmpLongBefore +2L)== tmpLongAfter );

        artistMasterService.calcEvaluatePoint(testKey, -2L);
          Long la2 =artistMasterService.fetchSingle(testKey).getArtistEvaluateValue();
        long tmpLongAfter2= la2.longValue();
        assertTrue((tmpLongAfter -2L)== tmpLongAfter2 );

        artistMasterService.calcEvaluatePoint(testKey, -99L);
          Long la3 =artistMasterService.fetchSingle(testKey).getArtistEvaluateValue();
        assertTrue(la3.longValue()== 0L);

    }

}
