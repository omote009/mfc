package mfc.utilities;

import static org.junit.Assert.*;
import mfc.consts.Defaults;

import org.junit.Test;

public class YouTubeManagerTest {

    @Test
    public void testToUrlForYoutubeApi() {
        System.out.println(YouTubeManager.toUrlForYoutubeApi("XXXXXXX", true));
        assertTrue("http://www.youtube.com/embed/XXXXXXX?enablejsapi=1&origin=http://example.com".equals(YouTubeManager.toUrlForYoutubeApi("XXXXXXX", true)));
        System.out.println(YouTubeManager.toUrlForYoutubeApi("XXXXXXX", false));
        assertTrue("http://www.youtube.com/embed/XXXXXXX?enablejsapi=1&origin=http://example.com&autoplay=1".equals(YouTubeManager.toUrlForYoutubeApi("XXXXXXX", false)));
    }

    @Test
    public void testToMfcMoviePlayerUrl() {
        if(Defaults.isPublic()){
               assertTrue("http://music-fan.club/mfc/moviePlay/?key=XXXXXX&sel=AAAAAA".equals(YouTubeManager.toMfcMoviePlayerUrl("XXXXXX", "AAAAAA")));
        }else{
            System.out.println(YouTubeManager.toMfcMoviePlayerUrl("XXXXXX", "AAAAAA"));
            assertTrue("http://localhost:8080/mfc/moviePlay?key=XXXXXX&sel=AAAAAA".equals(YouTubeManager.toMfcMoviePlayerUrl("XXXXXX", "AAAAAA")));
        }
    }

    @Test
    public void testGetNormalUrl() {
        assertTrue("http://www.youtube.com/watch?v=".equals(YouTubeManager.getNormalUrl()));

    }

    @Test
    public void testToNomalUrlFromShortUrl() {
        assertTrue("https://www.youtube.com/watch?v=XXXXXX".equals(YouTubeManager.toNomalUrlFromShortUrl("http://y2u.be/XXXXXX")));
        assertTrue("https://www.youtube.com/watch?v=XXXXXX".equals(YouTubeManager.toNomalUrlFromShortUrl("http://youtu.be/XXXXXX")));
    }


    @Test
    public void testGetMovieKeyOfYoutube() {
        assertTrue("j4dMnAPZu70".equals(YouTubeManager.getMovieKeyOfYoutube("http://www.youtube.com/watch?v=j4dMnAPZu70")));
        assertTrue("j4dMnAPZu70".equals(YouTubeManager.getMovieKeyOfYoutube("http://y2u.be/j4dMnAPZu70")));
        assertTrue("j4dMnAPZu70".equals(YouTubeManager.getMovieKeyOfYoutube("http://youtu.be/j4dMnAPZu70")));
        assertTrue("j4dMnAPZu70".equals(YouTubeManager.getMovieKeyOfYoutube("https://www.youtube.com/watch?v=j4dMnAPZu70")));

    }

    @Test
    public void testGetUrlOfThumbnailImageFromYoutube() {
        assertTrue("http://img.youtube.com/vi/LG1wmrW9afY/default.jpg".equals(YouTubeManager.getUrlOfThumbnailImageFromYoutube("https://www.youtube.com/watch?v=LG1wmrW9afY")));
        assertTrue("http://img.youtube.com/vi/LG1wmrW9afY/default.jpg".equals(YouTubeManager.getUrlOfThumbnailImageFromYoutube("http://y2u.be/LG1wmrW9afY")));
        if(Defaults.isPublic()){
            assertTrue("http://music-fan.club/mfc/movie_video.png".equals(YouTubeManager.getUrlOfThumbnailImageFromYoutube("http://gyao.yahoo.co.jp/player/00101/v11521/v0871400000000541758/")));
        }else{
            assertTrue("http://localhost:8080/mfc/movie_video.png".equals(YouTubeManager.getUrlOfThumbnailImageFromYoutube("http://gyao.yahoo.co.jp/player/00101/v11521/v0871400000000541758/")));
        }
     }

    @Test
    public void testTitle(){
        System.out.println(YouTubeManager.trimForVideoTitle("UPLIFT SPICE「マイノリティパレード」 - YouTube", "UPLIFT SPICE"));
        assertTrue("「マイノリティパレード」 ".equals(YouTubeManager.trimForVideoTitle("UPLIFT SPICE「マイノリティパレード」 - YouTube", "UPLIFT SPICE")));
        System.out.println(YouTubeManager.trimForVideoTitle("植田真梨恵「彼に守ってほしい10のこと」PV - YouTube", "植田真梨恵"));
        assertTrue("「彼に守ってほしい10のこと」PV".equals(YouTubeManager.trimForVideoTitle("植田真梨恵「彼に守ってほしい10のこと」PV - YouTube", "植田真梨恵")));
        System.out.println(YouTubeManager.trimForVideoTitle("[Alexandros] - Run Away (MV) - YouTube", "Alexandros"));
        assertTrue("Run Away (MV)".equals(YouTubeManager.trimForVideoTitle("[Alexandros] - Run Away (MV) - YouTube", "Alexandros")));
        System.out.println(YouTubeManager.trimForVideoTitle("Superfly『Beautiful』Music Video - YouTube", "Superfly"));
        assertTrue("『Beautiful』Music Video".equals(YouTubeManager.trimForVideoTitle("Superfly『Beautiful』Music Video - YouTube", "Superfly")));
    }

    @Test
    public void testGetMoviekeyFromSearchResult(){
        System.out.println(YouTubeManager.getMoviekeyOfYoutubeFromSearchResult("/url?url=https://www.youtube.com/watch%3Fv%3D0LPxWYF4h7Q&amp;rct=j&amp;frm=1&amp;q=&amp;esrc=s&amp;sa=U&amp;ved=0CB8QtwIwAmoVChMIiODUw7SCyQIVAlumCh21FArG&amp;usg=AFQjCNGKIKH8n7SQFYRrH4qGj53w7-ZdZw"));
        assertTrue("0LPxWYF4h7Q".equals(YouTubeManager.getMoviekeyOfYoutubeFromSearchResult("/url?url=https://www.youtube.com/watch%3Fv%3D0LPxWYF4h7Q&amp;rct=j&amp;frm=1&amp;q=&amp;esrc=s&amp;sa=U&amp;ved=0CB8QtwIwAmoVChMIiODUw7SCyQIVAlumCh21FArG&amp;usg=AFQjCNGKIKH8n7SQFYRrH4qGj53w7-ZdZw")));
    }

}
