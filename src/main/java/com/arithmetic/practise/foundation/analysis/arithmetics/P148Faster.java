package com.arithmetic.practise.foundation.analysis.arithmetics;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayAnalysis;

public class P148Faster implements ArrayAnalysis {

    @Override
    public void exec(int[] a) {
        int sum = 0;
        Arrays.sort(a);
        int currInt = a[0];
        int startIndex = 0;
        for (int i = 0, len = a.length; i < len; i++) {
            if (a[i] != currInt) {
                int count = i - startIndex;
                sum += count * (count - 1) / 2; // 数学归纳法算出上一个相等int值两两组合数量
                startIndex = i;
                currInt = a[i];
            } else if (i == len - 1) {
                int count = i - startIndex + 1;
                sum += count * (count - 1) / 2; // 数学归纳法算出上一个相等int值两两组合数量
            }
        }

        System.out.println("找到的相同的整数对数量:" + sum);
    }

}
