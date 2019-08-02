package com.arithmetic.practise.sort.junior;

import java.util.Arrays;

import com.arithmetic.practise.utils.RandomUtils;

/**
 * <p>
 * Description: 选择排序，每次遍历剩余数组元素找到最小值放在遍历范围之内的第一个元素.
 * </P>
 * * <p>
 * 优势：几乎没有，算法比较简单易懂.
 * 劣势：就算数组是有序的，也需要N平方/2次比较
 * </P>
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
public class SelectSort {

    public static void main(String[] args) {
        Double[] a = RandomUtils.randomArray(10000);
        final long start = System.currentTimeMillis();
        sort(a);
        System.out.println("排序耗时" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("排序是否成功：" + isSorted(a));

    }

    public static <T extends Comparable> void sort(final T[] a) {
        for (int i = 0, len = a.length; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exchange(a, i, minIndex);
        }
    }

    /**
     * 判断a是否小于b.
     *
     * @param a 被比较数
     * @param b 比较数
     * @return true，a小于b， false， a不小于b
     */
    private static <T extends Comparable> boolean less(final T a, final T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换数组a的索引为i和索引为j的两个元素位置.
     *
     * @param a 要交换的数组
     * @param i 交换的其中一个元素索引
     * @param j 交换的另一个元素索引
     */
    private static <T extends Comparable> void exchange(final T[] a, final int i, final int j) {
        T temp = a[i];
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
