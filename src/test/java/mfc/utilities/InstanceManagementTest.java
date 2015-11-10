package mfc.utilities;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class InstanceManagementTest {

    @Test
    public void testNewAtomicMap() {
        Map<String,String> mapTest = InstanceManager.newAtomicMap();
        assertTrue(mapTest != null);
    }

    @Test
    public void testNewNotAtomicMap() {
        Map<String,String> mapTest = InstanceManager.newNotAtomicMap();
        assertTrue(mapTest != null);
    }

    @Test
    public void testNewMap() {
        Map<String,String> mapTest = InstanceManager.newMap();
        assertTrue(mapTest != null);
    }

    @Test
    public void testNewAtomicList() {
        List<String> listTest = InstanceManager.newAtomicList();
        assertTrue(listTest != null);
    }

    @Test
    public void testNewNotAtomicList() {
        List<String> listTest = InstanceManager.newNotAtomicList();
        assertTrue(listTest != null);
    }

    @Test
    public void testNewList() {
        List<String> listTest = InstanceManager.newList();
        assertTrue(listTest != null);
    }

}
