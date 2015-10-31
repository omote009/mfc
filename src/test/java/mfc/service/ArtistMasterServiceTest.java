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

}
