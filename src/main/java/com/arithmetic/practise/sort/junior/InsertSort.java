package com.arithmetic.practise.sort.junior;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.arithmetic.practise.utils.RandomUtils;

/**
 * <P>
 * Description:
 * 插入排序，从两个元素开始，比较大小，如果顺序错误，交换两个元素，然后用第三个元素和第二个元素比再和第一个元素比，只要后一个元素比前一个元素小就交换相邻元素
 * ，直到遍历整个数组， 每次内层循环都可以保证已经比较的数组左侧元素是按顺序排序的.
 * </p>
 * <p>
 * 优势：如果数组是部分有序的，这个算法可能是最快的算法.
 * <p>
 * 这里有一个倒置的概念，比如EXAMPLE中倒置的组合有E-A,X-A,X-M,X-P,X-L,X-E,M-L,M-E,P-L,P-E,L-E共11对。
 * 而插入排序的交换元素次数等于倒置元素数量. 如果数组中的倒置数量小于数组的某个倍数，就说这个数组是部分有序的，下面是几个典型的部分有序数组：
 * 1、数组中每个元素距离它的最终位置都不远。 2、一个有序的大数组接一个小数组。 3、数组中只有几个元素的位置不正确。
 * </p>
 * 劣势：如果元素比较随机，需要N平方/4次比较和N平方/4次交换元素
 * 因为插入排序的交换次数等于倒置对的数量，每次交换对应一次比较，且1到N-1的元素都需要一次额外的比较
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
public class InsertSort {

    public static void main(String[] args) throws ParseException {
//		Double[] a = RandomUtils.randomArray(10000);
//		final long start = System.currentTimeMillis();
//		sort(a);
//		System.out.println("排序耗时：" + (System.currentTimeMillis() - start) + "ms");
//		System.out.println("数组成功排序" + isSorted(a));
//		Thread a = new Thread(new WhileTrue());
//		Thread a2 = new Thread(new WhileTrue());
//		Thread a3 = new Thread(new WhileTrue());
//		Thread a4 = new Thread(new WhileTrue());
//		a.start();
//		a2.start();
//		a3.start();
//		a4.start();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse("20170131"));
        System.out.println("初始时间：" + calendar.get(Calendar.YEAR) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, 1);
        System.out.println("下一个月时间：" + calendar.get(Calendar.YEAR) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, 1);
        System.out.println("下一个月时间：" + calendar.get(Calendar.YEAR) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(String.format("%02d", 1234));


    }

    private static class WhileTrue implements Runnable {

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            while (true) {

            }

        }

    }

    public static <T> void sort(final Comparable<T>[] a) {
        for (int i = 1, len = a.length; i < len; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
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
