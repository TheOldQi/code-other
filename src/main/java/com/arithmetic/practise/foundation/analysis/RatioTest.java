package com.arithmetic.practise.foundation.analysis;

import java.io.IOException;

import com.arithmetic.practise.foundation.analysis.arithmetics.P148Faster;
import com.arithmetic.practise.foundation.analysis.framework.ArrayFromFileTimeTrialer;
import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayAnalysis;
import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayTimeTrialer;
import com.arithmetic.practise.foundation.analysis.framework.superclass.NumberAnalysis;
import com.arithmetic.practise.foundation.analysis.framework.superclass.NumberTimeTrialer;

public class RatioTest {

    /**
     * 倍率测试
     *
     * @param init 初始规模
     * @throws IOException
     */
    public static void test(int init, ArrayTimeTrialer trialer, ArrayAnalysis analyer) throws IOException {
        double prev = trialer.trial(init, analyer);
        System.out.println("size\telapsed\tincrease-ratio");
        for (int i = init << 1; i <= Integer.MAX_VALUE >>> 1; i <<= 1) {
            double thisTime = trialer.trial(i, analyer);
            if (thisTime < -0.00001) {
                break;
            }
            System.out.printf("%6d\t%7.3f\t%5.1f", i, thisTime, Math.abs(prev) < 0.0000001 ? 0.0 : thisTime / prev);
            System.out.println();
            prev = thisTime;
        }
    }

    /**
     * 倍率测试
     *
     * @param init 初始规模
     * @throws IOException
     */
    public static void test(int init, NumberTimeTrialer trialer, NumberAnalysis analyer) throws IOException {
        double prev = trialer.trial(init, analyer);
        System.out.println("size\telapsed\tincrease-ratio");
        for (int i = init << 1; i <= Integer.MAX_VALUE >>> 1; i <<= 1) {
            double thisTime = trialer.trial(i, analyer);
            if (thisTime < -0.00001) {
                break;
            }
            System.out.printf("%6d\t%7.3f\t%5.1f", i, thisTime, Math.abs(prev) < 0.0000001 ? 0.0 : thisTime / prev);
            System.out.println();
            prev = thisTime;
        }
    }

    public static void main(String[] args) throws IOException {
//		 StringBuilder sb = new StringBuilder();
//		 int oneMLen = 1 << 23;
//		 System.out.println(oneMLen);
//		 for (int i = 0; i < oneMLen; i++) {
//		 sb.append((int) (RandomUtils.random() * 10));
//		 }
//		 FileUtils.outPutToTxt("E:/self-study-files/8mints.txt",
//		 sb.toString());
        ArrayTimeTrialer trialer = new ArrayFromFileTimeTrialer();
//		ArrayAnalysis analysis = new P148Faster();
//		test(100, trialer, analysis);
//		analysis = new P148();
//		test(100, trialer, analysis);
    }
}
