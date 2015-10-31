package mfc.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReturnTest {

    @Test
    public void returnTest(){
        assertTrue("/artistMrEntry/".equals(ReturnTo.ARTIST_MR_ENTRY.get()));
        assertTrue("artistMrEntry.jsp".equals(ReturnJsp.ARTIST_MR_ENTRY.get()));
    }

}
