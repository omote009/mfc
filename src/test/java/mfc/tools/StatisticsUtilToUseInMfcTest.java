package mfc.tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatisticsUtilToUseInMfcTest {

    @Test
    public void testGetDoubleArrayFromStr() {
        String s = "111111000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        double[] sb = StatisticsUtilToUseInMfc.getDoubleArrayFromStr(s);
        assertEquals(sb.length, 150);
        assertEquals(sb[0], 1L, 0.1);
        assertEquals(sb[149], 1L, 0.1);
    }

    @Test
    public void testGetConcatenationArray() {
        String s = "111111000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        double[] sb = StatisticsUtilToUseInMfc.getDoubleArrayFromStr(s);
        double[] sbw = StatisticsUtilToUseInMfc.getConcatenationArray(sb, sb);
        assertEquals(sbw.length, 300);
        assertEquals(sbw[0], 1L, 0.1);
        assertEquals(sbw[299], 1L, 0.1);
    }

    @Test
    public void testGetAverage() {
        String s = "111111000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        double[] sb = StatisticsUtilToUseInMfc.getDoubleArrayFromStr(s);
        double ave = StatisticsUtilToUseInMfc.getAverage(sb);
        System.out.println(ave);
        assertEquals(ave, 0.0933333333, 0.000001);
    }

    @Test
    public void testGetVariance() {
        String s = "111111000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        double[] sb = StatisticsUtilToUseInMfc.getDoubleArrayFromStr(s);
        double v = StatisticsUtilToUseInMfc.getVariance(sb);
        System.out.println(v);
        assertEquals(v, 0.0851901566, 0.001);
    }

    @Test
    public void testGetStandardDiviation() {
        String s = "111111000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        double[] sb = StatisticsUtilToUseInMfc.getDoubleArrayFromStr(s);
        double v = StatisticsUtilToUseInMfc.getStandardDiviation(sb);
        System.out.println(v);
        assertEquals(v, 0.2908989897, 0.00001);

    }

    @Test
    public void testGetCorrelationCoefficient() {
        String s1 = "111111000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        double[] sb1 = StatisticsUtilToUseInMfc.getDoubleArrayFromStr(s1);
        String s2 = "111111000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        double[] sb2 = StatisticsUtilToUseInMfc.getDoubleArrayFromStr(s2);
        double coef = StatisticsUtilToUseInMfc.getCorrelationCoefficient(sb1, sb2);
        System.out.println(coef);
        assertEquals(coef, 0.9625334, 0.001);
        double coef2 = StatisticsUtilToUseInMfc.getCorrelationCoefficient(sb1, sb1);
        System.out.println(coef2);
        assertEquals(coef2, 1L, 0.001);


    }

}
