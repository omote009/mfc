package mfc.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.seasar.framework.util.StringUtil;

/**
 * 分散・標準偏差・相関係数などMFCで利用する統計機能を集めたユーティリティクラス<br/>
 *
 * @author 正
 *
 */
public class StatisticsUtilToUseInMfc {

     /**
     * 文字列に含まれる数字をdoubleの配列に格納して返す
     *
     * @param baseStr
     * @return
     */
    public static double[] getDoubleArrayFromStr(final String baseStr){
        // 空文字列なら最小の空配列を返す
        if(StringUtil.isBlank(baseStr)){
            return new double[1];
        }
        double[] workArray = new double[baseStr.length()];
        String regex = "[0123456789]";
        Pattern pat = Pattern.compile(regex);
        for (int i = 0; i < baseStr.length(); i++) {
            String numStr = Character.toString(baseStr.charAt(i));
            // 数字以外は無視する。
            Matcher m = pat.matcher(numStr);
            if(m.find()){
                workArray[i] = Double.valueOf(numStr).doubleValue();
            }
        }
        return workArray;
    }

    /**
     * doubleの２つの配列を連結した配列を返す。
     *
     * @param arrayA
     * @param arrayB
     * @return
     */
    public static double[] getConcatenationArray(final double[] arrayA,final double[] arrayB){
        if(arrayA == null){
            if(arrayB == null){
                return null;
            }else{
                return arrayB;
            }
        }else{
            if(arrayB == null){
                return arrayA;
            }
        }

        double[] ret = new double[arrayA.length + arrayB.length];
        for(int i = 0; i < arrayA.length; i++){
            ret[i] = arrayA[i];
        }
        int i2 = 0;
        for(int j = arrayA.length;j < arrayA.length + arrayB.length; j++){
            ret[j] = arrayB[i2];
            i2++;
        }
        return ret;
    }

    /**
     * doubleの配列の平均を求める
     *
     * @param baseArray
     * @return
     */
    public static double getAverage(final double[] baseArray){
        double workLength = 0.0;
        double workAverage = 0.0;
        if(baseArray == null){
            return workAverage;
        }

        // 平均値を求めるための加算用変数
        double tmpA = 0.0;
        for (int i = 0; i < baseArray.length; i++) {
            tmpA = tmpA + baseArray[i];
            workLength++;
        }
        workAverage = tmpA / workLength;
        return workAverage;
    }

    /**
     * 分散を求めて返す
     *
     * @param baseArray
     * @return
     */
    public static double getVariance(final double[] baseArray){
        double variance = 0.0;
        if (baseArray == null) {
            return variance;
        }
        // 平均を求める
        double workAverage = getAverage(baseArray);

        double workSum = 0.0;
        double workLength = 0.0;
        double tmpE = 0.0;
        for (int i = 0; i < baseArray.length; i++) {
            tmpE = baseArray[i] - workAverage;
            // 分散を計算するための階乗の累計をとる
            workSum = workSum + (tmpE * tmpE);
            workLength++;
        }

        // 分散を求める
         if (workSum > 0.0 && workLength > 0.0) {
            variance = workSum / workLength;
        }
        return variance;
    }

    /**
     * 標準偏差を計算する。
     *
     * @param baseArray
     * @return
     */
    public static double getStandardDiviation(final double[] baseArray) {
        double standardDeviation = 0.0;
        if (baseArray == null) {
            return standardDeviation;
        }

        // 分散を求める
        double variance = getVariance(baseArray);

        // 標準偏差を求める
        if(variance > 0.0){
            standardDeviation = Math.sqrt(variance);
        }
        return standardDeviation;
    }

    /**
     * doubleの配列２つを受け取り、相関係数を計算して返す。
     *
     * @param arrayA
     * @param arrayB
     * @return
     */
    public static double getCorrelationCoefficient(final double[] arrayA,final double[] arrayB){
        if(arrayA == null || arrayB == null){
            return 0.0;
        }
        double[] coArray = getConcatenationArray(arrayA,arrayB);
        double average = getAverage(coArray);
        double workStandardDeviationA = getStandardDiviation(arrayA);
        double workStandardDeviationB = getStandardDiviation(arrayB);
        double workSum = 0.0;
        double workLength = 0.0;

        // 配列の短い方にあわせて計算する
        if(arrayA.length > arrayB.length){
            for(int i = 0; i < arrayB.length; i++){
                workSum = workSum + (arrayA[i] - average) * (arrayB[i] - average);
                workLength++;
            }
        }else{
               for(int i = 0; i < arrayA.length; i++){
                workSum = workSum + (arrayA[i] - average) * (arrayB[i] - average);
                workLength++;
            }
        }

        if(workSum > 0.0 && workLength > 0.0){
            // 共分散を求める
            double covariance = workSum / workLength;
            // 相関係数を求める
            double correlationCoefficient = covariance / (workStandardDeviationA * workStandardDeviationB);
            return correlationCoefficient;
        }else{
            return 0.0;
        }

    }
}
