package mfc.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class MfcUrlManagerTest {

    @Test
    public void testGetBaseUrlBoolean() {
        assertTrue("http://music-fan.club/mfc/".equals(MfcUrlManager.getBaseUrl(true)));
        assertTrue("http://localhost:8080/mfc/".equals(MfcUrlManager.getBaseUrl(false)));
    }

}
