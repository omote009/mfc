package mfc.enums;

import static org.junit.Assert.*;
import mfc.consts.Defaults;

import org.junit.Test;

public class ConstantUrlTest {

    @Test
    public void testConstUrl(){
        if(Defaults.isPublic()==true){
            assertTrue("http://music-fan.club/mfc/".equals(ConstantUrl.ROOTURL.get()));
        }else{
            assertTrue("http://localhost:8080/mfc/".equals(ConstantUrl.ROOTURL.get()));
        }
    }

}
