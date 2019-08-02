package com.arithmetic.practise;

public class Test {

    public static void main(String[] args) {
//        int i = -1;
//        printBinary("0x0f0f0f0f:", 0x0f0f0f0f);
//        while (true) {
//            printBinary("i:", i);
//            printBinary("bitCount:", bitCount(new Integer(1)));
////			if ((((i >>> 4) + i) & 0x0f0f0f0f) != ((i & 0x0f0f0f0f) + ((i >>> 4) & 0x0f0f0f0f))) {
////				printBinary("if front:", (((i >>> 4) + i) & 0x0f0f0f0f));
////				printBinary("if background:", ((i & 0x0f0f0f0f) + ((i >>> 4) & 0x0f0f0f0f)));
////				System.out.println("break:" + i);
////				break;
////			}
////			System.out.println(i);
//            i--;
//        }
    }


    public static int bitCount(int i) {
        i = ((i >>> 1) & 0x55555555) + (i & 0x55555555);
        i = ((i >>> 2) & 0x33333333) + (i & 0x33333333);
        i = ((i >>> 4) + i) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    public static void printBinary(String prefix, int i) {
        StringBuilder sb = new StringBuilder();
        if (i < 0) {
            sb.append("1");
            i = -i;
        } else {
            sb.append("0");
        }
        for (int j = 1; j < 32; j++) {
            if ((i << j) < 0) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        System.out.println(prefix + "binary format :" + sb);
    }
}
