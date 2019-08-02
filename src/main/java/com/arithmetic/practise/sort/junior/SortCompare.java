package com.arithmetic.practise.sort.junior;

import com.arithmetic.practise.utils.RandomUtils;
import com.arithmetic.practise.utils.StopWatch;

/**
 * <p>
 * Description: 比较排序算法.
 * </P>
 * <p>
 * CALLED BY: 齐霞飞
 * </P>
 * <p>
 * UPDATE BY: 齐霞飞
 * </P>
 * <p>
 * CREATE DATE: 2017年8月24日
 * </P>
 * <p>
 * UPDATE DATE: 2017年8月24日
 * </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class SortCompare {

    public static void main(String[] args) {
        String alg = "Insert";
        String alg2 = "Shell";
        int size = 1000;
        int t = 1000;
        double algTime = timeRandomInput(alg, size, t);
        double alg2Time = timeRandomInput(alg2, size, t);
        System.out.printf("For %d times sort %d length random Array \n", t, size);
        System.out.printf(" %s 's elapsed time is %.1f time than %s \n ", alg, algTime / alg2Time, alg2);
    }

    /**
     * 对指定算法进行t次随机数排序，返回执行总时间.
     *
     * @param alg  算法类型
     * @param size 数组大小
     * @param t    执行次数
     * @return 总时间
     */
    private static double timeRandomInput(String alg, int size, int t) {
        double total = 0.0;
        Double[] a = new Double[size];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < size; j++)
                a[j] = RandomUtils.uniform(0.0, 1);
            total += time(alg, a);
        }
        return total;
    }

    /**
     * 对数组进行指定算法排序的耗时.
     *
     * @param alg
     * @param a
     * @return 耗时
     */
    private static double time(String alg, Comparable[] a) {
        StopWatch stopWatch = new StopWatch();
        switch (alg) {
            case "Insert":
                InsertSort.sort(a);
                break;
            case "Select":
                SelectSort.sort(a);
                break;
            case "Shell":
                ShellSort.sort(a);
                break;
        }

        return stopWatch.elapsedTime();
    }
}
