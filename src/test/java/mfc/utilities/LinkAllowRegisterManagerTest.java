package mfc.utilities;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class LinkAllowRegisterManagerTest {

    public void testIsYouTube() {
        assertTrue(LinkAllowRegisterManager.isYouTube("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isYouTube("http://youtu.be/XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isYouTube("http://y2u.be/XKzuI52V7iE"));
    }

    public void testIsGyao() {
        assertFalse(LinkAllowRegisterManager.isGyao("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isGyao("http://gyao.yahoo.co.jp/music-live/player/kazuyoshi-saito"));
    }

    public void testIsDmotion() {
        assertFalse(LinkAllowRegisterManager.isDmotion("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isDmotion("http://www.dailymotion.com/video/x3cpwx9_ice-age-collision-course-cosmic-scrat-tastrophe_shortfilms"));
    }

    public void testIsMuzix() {
        assertFalse(LinkAllowRegisterManager.isMuzix("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isMuzix("http://mu-zix.com/detail.php?id=4175"));
    }

    public void testIsNoco() {
        assertFalse(LinkAllowRegisterManager.isNoco("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isNoco("http://www.nicovideo.jp/watch/sm27518668?ref=search_tag_video"));
    }

    public void testIsSound() {
        assertFalse(LinkAllowRegisterManager.isSound("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isSound("https://soundcloud.com/"));
    }

    public void testIsAudio() {
        assertFalse(LinkAllowRegisterManager.isAudio("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isAudio("https://www.audioleaf.com/notinmyname/"));
    }

    public void testIsUstream() {
        assertFalse(LinkAllowRegisterManager.isUstream("https://www.youtube.com/watch?v=XKzuI52V7iE"));
        assertTrue(LinkAllowRegisterManager.isUstream("http://www.ustream.tv/channel/nachtpiraat"));
    }

}
