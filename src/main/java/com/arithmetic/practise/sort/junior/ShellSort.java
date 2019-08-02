package com.arithmetic.practise.sort.junior;

import java.util.Arrays;

/**
 * <P>
 * Description: 希尔排序，是在插入排序的基础上进行改进的排序算法.
 * </P>
 * <p>
 * 这种算法是利用插入排序对部分有序数组的效率更高的特点，将排序内循环的增量按h序列依次变化来完成整个排序。
 * h序列：是一个按大小顺序倒序排列的数组，数组的最后一个元素是1. 本类中使用的h序列是(3的k次方 - 1)/2 的序列。其中k是倒数第几个元素。
 * </p>
 * <p>
 * CALLED BY: 齐霞飞
 * </P>
 * <p>
 * UPDATE BY: 齐霞飞
 * </P>
 * <p>
 * CREATE DATE: 2017年8月21日
 * </P>
 * <p>
 * UPDATE DATE: 2017年8月21日
 * </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class ShellSort {

    public static <T> void sort(final Comparable<T>[] a) {
        final int size = a.length;
        // 先计算出h最大
        int hMax = 1;
        while (hMax < size / 3) {
            hMax = hMax * 3 + 1;
        }
        while (hMax > 0) {
            for (int i = hMax; i < size; i++) {
                for (int j = i; j >= hMax && less(a[j], a[j - hMax]); j--) {
                    exchange(a, j, j - hMax);
                }
            }
            hMax /= 3;
        }

    }

    /**
     * 判断a是否小于b.
     *
     * @param a 被比较数
     * @param b 比较数
     * @return true，a小于b， false， a不小于b
     */
    private static <T> boolean less(final Comparable<T> a, final Comparable<T> b) {
        return a.compareTo((T) b) < 0;
    }

    /**
     * 交换数组a的索引为i和索引为j的两个元素位置.
     *
     * @param a 要交换的数组
     * @param i 交换的其中一个元素索引
     * @param j 交换的另一个元素索引
     */
    private static <T> void exchange(final Comparable<T>[] a, final int i, final int j) {
        Comparable<T> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 判断数组是否已经排好序.
     *
     * @param a 待检查数组
     * @return true- 已排序 ,false - 未排序
     */
    public static <T> boolean isSorted(final Comparable<T>[] a) {
        for (int i = 0, len = a.length - 1; i < len; i++) {
            if (less(a[i + 1], a[i]))
                return false;
        }
        return true;
    }
}
