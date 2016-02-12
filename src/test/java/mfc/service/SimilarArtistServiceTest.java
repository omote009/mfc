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
        List<String> bList = similarArtistService.getListSimilarArtist("XuEnDyJ3Ck");
        for(int i=0;i < bList.size();i++){
            System.out.println(bList.get(i));
        }
        List<String> cList = similarArtistService.getListSimilarArtist("c3Ds0hdo5o");
        for(int l=0;l < cList.size();l++){
            System.out.println(cList.get(l));
        }
        List<String> eList = similarArtistService.getListSimilarArtist("c3Ds0hdo5o",1);
        assertEquals("oTrdLPcb2k",eList.get(0));
        List<String> dList = similarArtistService.getListSimilarArtist("vBMhEQYagi");
        for(int l=0;l < dList.size();l++){
            System.out.println(dList.get(l));
        }
        List<String> fList = similarArtistService.getListSimilarArtist("");
        for(int l=0;l < fList.size();l++){
            System.out.println(dList.get(l));
        }

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
    }

}
