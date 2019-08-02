package com.arithmetic.practise.foundation.analysis.arithmetics;

public class P1410 {

    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length;
        int index = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = a[mid];
            if (midValue == key) {
                if (index == -1 || mid < index) {
                    index = mid;
                }
                hi = mid - 1;
            } else if (midValue < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return index;
    }
}
