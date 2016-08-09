package mfc.tools;

import static org.junit.Assert.*;

import java.util.List;

import mfc.entity.RelevantData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class SearchMusicInEmotionTest {


    @Test
    public void testGetSongKeyListFromEmotionRelevantDataInt() {
        RelevantData sg = new RelevantData(); sg.setRelevantKey("xxxxxxxxx001");
        sg.setRelevantName("VVVVVVVVV");
        sg.setParamStr01("1111110000"); sg.setParamStr02("0000000000");
        sg.setParamStr03("1111111100"); sg.setParamStr04("0000000000");
        sg.setParamStr05("0000000000"); sg.setParamStr06("0000000000");
        sg.setParamStr07("0000000000"); sg.setParamStr08("0000000000");
        sg.setParamStr09("0000000000"); sg.setParamStr10("0000000000");
        sg.setParamStr11("0000000000"); sg.setParamStr12("0000000000");
        sg.setParamStr13("0000000000"); sg.setParamStr14("0000000000");
        sg.setParamStr15("0000000000"); sg.setWait(14L);

        SearchMusicInEmotion searchMusicInEmotion = new SearchMusicInEmotion();
        List<String> t = searchMusicInEmotion.getSongKeyListFromEmotion(sg, 5, true);
        assertEquals(t.get(0),"xxxxxxxxx003");
        assertEquals(t.get(1),"xxxxxxxxx002");
        assertEquals(t.size(),2);

    }

}
