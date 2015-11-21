package mfc.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class WrapperRegexManagerTest {

    @Test
    public void testIsMatched() {
        assertTrue(WrapperRegexManager.isMatched("ポタリMUSICVIDEOOFFICIALCHANNELYOUTUBE", ".*(PV|MV|MUSICVIDEO|ミュージックビデオ).*"));
        assertFalse(WrapperRegexManager.isMatched("ポタリOFFICIALCHANNELYOUTUBE", ".*(PV|MV|MUSICVIDEO|ミュージックビデオ).*"));
    }

    @Test
    public void testEscapeRegexPasethese(){
        assertTrue("Alex".equals(YouTubeManager.escapeRegexParentheses("Alex")));
        assertTrue("植田真梨恵".equals(YouTubeManager.escapeRegexParentheses("植田真梨恵")));
        System.out.println(YouTubeManager.escapeRegexParentheses("[Alexandros]"));
        assertTrue("Alexandros".equals(YouTubeManager.escapeRegexParentheses("[Alexandros]")));
    }

}
