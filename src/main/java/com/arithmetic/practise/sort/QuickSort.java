package com.arithmetic.practise.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2018/6/4</P>
 * <P>UPDATE DATE: 2018/6/4</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = new Random().nextInt(100000);
        }
        long start = System.currentTimeMillis();
        sort(a);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println(Arrays.toString(a));
        a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = new Random().nextInt(100000);
        }
        start = System.currentTimeMillis();
        sortRec(a, 0, a.length - 1);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = new Random().nextInt(100000);
        }
        start = System.currentTimeMillis();
        sort(a);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }


    public static int[] sort(int[] a) {

        LinkedList<Integer> unDealList = new LinkedList<>();
        unDealList.addLast(0);
        unDealList.addLast(a.length - 1);
        while (!unDealList.isEmpty()) {
            int low = unDealList.removeFirst();
            int high = unDealList.removeFirst();
            int tempLow = low;
            int tempHigh = high;
            boolean positive = false;
            while (tempHigh != tempLow) {
                if (!positive) {
                    if (a[tempLow] > a[tempHigh]) {
                        exch(tempLow, tempHigh, a);
                        positive = true;
                        tempLow++;
                    } else {
                        tempHigh--;
                    }
                } else {
                    if (a[tempLow] > a[tempHigh]) {
                        exch(tempLow, tempHigh, a);
                        tempHigh--;
                        positive = false;
                    } else {
                        tempLow++;
                    }
                }

            }

            if ((low + 1) < tempLow) {
                unDealList.addLast(low);
                unDealList.addLast(tempLow - 1);
            }

            if ((high - 1) > tempLow) {
                unDealList.addLast(tempLow + 1);
                unDealList.addLast(high);
            }

        }
        return a;
    }


    public static void sortRec(int[] a, int low, int high) {

        if (low >= high) {
            return;
        }
        int l = low;
        int r = high;
        while (l != r) {
            while (a[l] > a[r]) r--;
            if (l < r) {
                exch(l, r, a);
                l++;
            }
            while (a[l] > a[r]) l++;
            if (l < r) {
                exch(l, r, a);
                r--;
            }
        }
        sortRec(a, low, l - 1);
        sortRec(a, l + 1, r);

    }

    private static void exch(final int i, final int j, final int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
