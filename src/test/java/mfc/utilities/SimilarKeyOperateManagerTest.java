package mfc.utilities;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SimilarKeyOperateManagerTest {

    @Test
    public void testGetRegexpPatternList() {
        List<String> testList = SimilarKeyOperateManager.getRegexpPatternList();
        assertNotNull(testList);
        assertEquals(testList.get(0),"^.*(女|ガール|GIRL|女性|WOMAN|FEMAIL).*$");
      /*  for(String s : testList){
            System.out.println(s);
        }*/
    }

}
