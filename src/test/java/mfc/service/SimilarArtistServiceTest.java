package mfc.service;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import mfc.condition.ReverseStringComparator;
import mfc.dto.ExclusionArtistListDto;
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
        List<String> eList = similarArtistService.getListSimilarArtist("c3Ds0hdo5o");
        assertEquals("oTrdLPcb2k",eList.get(0));
        for(int l=0;l < eList.size();l++){
            System.out.println(eList.get(l));
        }
        ExclusionArtistListDto exclusionArtistListSub = new ExclusionArtistListDto();
        exclusionArtistListSub.addExclusionArtistList("oTrdLPcb2k");
        exclusionArtistListSub.addExclusionArtistList("FoFYHc6SQv");
        List<String> cList = similarArtistService.getListSimilarArtist("c3Ds0hdo5o",exclusionArtistListSub.getExclusionArtistList());
        for(int l=0;l < cList.size();l++){
            System.out.println(cList.get(l));
        }

        List<String> dList = similarArtistService.getListSimilarArtist("RvO4dLFMPw");
        for(int l=0;l < dList.size();l++){
            System.out.println(dList.get(l));
        }
        List<String> fList = similarArtistService.getListSimilarArtist("nZK3iGjFfx");
        for(int l=0;l < fList.size();l++){
            System.out.println(fList.get(l));
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

        Collections.sort(artistCodeListForSortWork,new ReverseStringComparator());
        String[] chks = artistCodeListForSortWork.get(0).split("_");
        assertEquals("DDDDD",chks[1]);
    }

}
