package com.arithmetic.practise.foundation.analysis.framework;

import java.io.IOException;
import java.util.Arrays;

import com.arithmetic.practise.foundation.analysis.arithmetics.P1410;
import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayAnalysis;
import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayTimeTrialer;
import com.arithmetic.practise.utils.FileUtils;
import com.arithmetic.practise.utils.StopWatch;

/**
 * 实验程序
 *
 * @author qixiafei
 */
public class ArrayFromFileTimeTrialer implements ArrayTimeTrialer {

    private static final int[] a;

    static {
        String trialData = "";
        try {
            trialData = FileUtils.readTxt("E:/self-study-files/1mints.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        a = new int[trialData.length()];
        int index = 0;
        for (Character c : trialData.toCharArray()) {
            a[index++] = Character.getNumericValue(c);
        }
        Arrays.sort(a);
        System.out.println(P1410.binarySearch(a, 1));
        System.out.println(Arrays.binarySearch(a, 1));
    }

    /**
     * 计算规模n的时候算法执行时间
     *
     * @param n
     * @return
     * @throws IOException
     */
    @Override
    public double trial(int initSize, ArrayAnalysis analysis) throws IOException {
        if (initSize >= a.length) {
            return -1.0;
        }
        int[] b = new int[initSize];
        System.arraycopy(a, 0, b, 0, initSize);
        StopWatch watch = new StopWatch();
        analysis.exec(b);
        return watch.elapsedTime();
    }

}
