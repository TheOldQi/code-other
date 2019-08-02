package com.arithmetic.practise.sort.junior;

/**
 * <p>
 * Description: 所有排序算法都可以参照这个格式建立，复制该类后改名然后修改实现即可.
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
public class Example {

    public static <T extends Comparable> void sort(final T[] a) {

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
    public static <T extends Comparable> boolean isSorted(final T[] a) {
        for (int i = 0, len = a.length - 1; i < len; i++) {
            if (less(a[i + 1], a[i]))
                return false;
        }
        return true;
    }
}
