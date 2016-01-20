package mfc.service;

import static org.junit.Assert.*;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class ArtistBoxServiceTest {

    @Resource
    private ArtistBoxService artistBoxService;

    @Test
    public void testGetMapOfSameBoxArtistList(){
        Map<String,String> testResult = artistBoxService.getMapOfSameBoxArtistList();
        assertNotNull(testResult);
        assertEquals(testResult.get("000000007"),"7F8P1jKOND,Y2bulsE3Ss,aUUIoqbwsf,ViPp2KvYHb");
    }

    @Test
    public void testGetAllCount(){
        System.out.println(artistBoxService.getAllCount());
    }

}
