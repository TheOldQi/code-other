package com.arithmetic.practise.foundation.analysis.arithmetics;

public class P1437 extends P1443 {


    public static Class<? extends P1443> getClassB() {
        return P1437.class;
    }

//	public static void main(String[] args) {
//		for (int i = 1; i <= Integer.MAX_VALUE >>> 1; i <<= 1) {
//			testInt(i);
//			testInteger(i);
//		}
//	}

    public static void testInt(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            int a = i;
        }
        System.out.printf("不装箱拆箱，%d\t%5.3f", size, (System.currentTimeMillis() - start) / 1000.0);
        System.out.println();
    }

    public static void testInteger(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Integer a = i;
            int b = a;
        }
        System.out.printf("装箱拆箱，%d\t%5.3f", size, (System.currentTimeMillis() - start) / 1000.0);
        System.out.println();
    }

    public static void main(String[] args) {
        Class<?> clazz = getClassB();
        System.out.println(clazz == P1437.class);
        System.out.println(clazz == P1443.class);
    }
}
