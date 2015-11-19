package mfc.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringPrescribedManagerTest {

    @Test
    public void testConvert() {
        String converted = StringPrescribedManager.convert("植田真梨恵(ｳｴﾀﾞﾏﾘｴ）らいぶ 「Ｓ・Ｏ・Ｓ」１２３４５６");
        assertTrue(converted.equals("植田真梨恵(ウエダマリエ）ライブ 「S・O・S」123456"));
    }

    @Test
    public void testConvertForMatch() {
        String converted = StringPrescribedManager
                .convertForMatch("【植田真梨恵】(ｳｴﾀﾞﾏﾘｴ）らいぶ 「Ｓ・Ｏ・Ｓ」１２３４５６");
        System.out.println(converted);
        assertTrue(converted.equals("植田真梨恵ウエダマリエライブSOS123456"));
    }

}
