package mfc.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import mfc.entity.ArtistLink;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class ArtistMovieLinkServiceTest {

    @Resource
    private ArtistVideoLinkService artistVideoLinkService;

    @Test
    public void testFetcheSingle() {

        ArtistLink link = artistVideoLinkService.fetcheSingle("0FqJ0aYxgM", "GOODLUCK");
        assertTrue(link.getLinkUrl().equals("https://www.youtube.com/watch?v=Y4iZWWGqjsc"));

    }

    @Test
    public void testUpdate(){
        int status = artistVideoLinkService.updateWithJudgement("0FqJ0aYxgM", "INSERTTEST", ("https://www.youtube.com/watch?v=Y4iZWWGqjsc"));
        assertTrue(status >0);

    }

    @Test
    public void testToNormalUrl(){

    }

    @Test
    public void testAutomaticAddVideoLinkFromYoutube(){
        int status = artistVideoLinkService.automaticAddVideoLinkFromYoutube("0OKeOmBsMw");
        System.out.println(Integer.valueOf(status));
        assertTrue(status >0);
    }

}
