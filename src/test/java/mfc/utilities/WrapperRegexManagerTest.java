package mfc.utilities;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class WrapperRegexManagerTest {

    public void testIsMatched() {
        assertTrue(WrapperRegexManager.isMatched("ポタリMUSICVIDEOOFFICIALCHANNELYOUTUBE", ".*(PV|MV|MUSICVIDEO|ミュージックビデオ).*"));
        assertFalse(WrapperRegexManager.isMatched("ポタリOFFICIALCHANNELYOUTUBE", ".*(PV|MV|MUSICVIDEO|ミュージックビデオ).*"));
    }

}
