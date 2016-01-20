package mfc.service;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import mfc.condition.LiftComparator;
import mfc.utilities.InstanceManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class SimilarArtistServiceTest {

    @Resource
    private SimilarArtistService similarArtistService;

    @Test
    public void testGetListSimilarArtist() {
        List<String> aList = similarArtistService.getListSimilarArtist("YiT1qIskIX");
        assertEquals("4b3eNldJnx",aList.get(0));
        System.out.println(aList.get(0));
        List<String> bList = similarArtistService.getListSimilarArtist("0FqJ0aYxgM");
        System.out.println(bList.get(0));
    }

    @Test
    public void testGetSub001(){
         double confidence = Double.valueOf("2") / Double.valueOf("3") ;
         System.out.println(String.format("%1.10f",confidence) + "_" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         double support = Double.valueOf("2") / Double.valueOf("10") ;
         System.out.println(String.format("%1.10f",support) + "_" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         double lift = confidence / support;
         System.out.println(String.format("%1.10f",lift) + "_" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Test
    public void testCollectionSort(){
        List<String> artistCodeListForSortWork = InstanceManager.newNotAtomicList();
        double support = Double.valueOf("2") / Double.valueOf("10") ;
        artistCodeListForSortWork.add(String.format("%1.10f", support) + "_" + "AAAAA");
        artistCodeListForSortWork.add(String.format("%1.10f", Double.valueOf("1") / Double.valueOf("10")) + "_" + "BBBBB");
        artistCodeListForSortWork.add(String.format("%1.10f", Double.valueOf("3") / Double.valueOf("10")) + "_" + "CCCCC");
        artistCodeListForSortWork.add(String.format("%1.10f", Double.valueOf("4") / Double.valueOf("10")) + "_" + "DDDDD");

        Collections.sort(artistCodeListForSortWork,new LiftComparator());
        String[] chks = artistCodeListForSortWork.get(0).split("_");
        assertEquals("DDDDD",chks[1]);
        for(String aCode : artistCodeListForSortWork){
            String[] tmps = aCode.split("_");
            System.out.println(tmps[1]);
        }
    }

}
