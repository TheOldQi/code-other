package com.arithmetic.practise.foundation;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.arithmetic.practise.utils.RandomUtils;

/**
 * Hello world!
 */
public class Practises {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 练习1.1.1
        // practise111();
        // 练习1.1.2
        // practise112();
        // 练习1.1.3
        // practise113(in);
        // 练习1.1.5
        // practise115(in);
        // 练习1.1.6
        // practise116();
        // 练习1.1.7
        // practise117a();
        // practise117b();
        // practise117c();
        // 练习1.1.8
        // practise118();
        // 练习1.1.9
        // practise119(in);
        // 练习1.1.11
        // practise1111();
        // 练习1.1.12
        // practise1112();
        // 练习1.1.13
        // practise1113();
        // 练习1.1.14
        // practise1114(in);
        // 练习1.1.15
        // 编写一个静态方法，接收一个整型数组a[]和一个整数m并返回一个大小为M的数组，其中第i个元素的值为整数i在参数数组中出现的次数
        // int[] arr1115 = practise1115(new int[] { 1, 2, 3, 1, 5, 9, 6, 1, 5,
        // 4, 6, 4, 8, 7, 9, 4, 3, 4, 8, 9, 6, 58, 18,
        // 16, 15, 17, 12, 11, 13, 15, 16 }, 20);
        // System.out.println("练习1.1.15数组结果" + Arrays.toString(arr1115));
        // 练习1.1.16
        // String str11116 = practise1116(6);
        // System.out.println("练习1.1.16的递归结果:" + str11116);
        // 练习1.1.18
        // int intPractise1118Add = practise1118Add(2, 25);
        // System.out.println(intPractise1118Add);
        // int intPractise1118Multiply = practise1118Multiply(2, 25);
        // System.out.println(intPractise1118Multiply);
        // 练习1.1.19 斐波那契
        // long beginTime = System.currentTimeMillis();
        // for (int i = 0; i < 100; i++) {
        // System.out.println(
        // "fibonacci:位置" + i + ",结果 : " + fibonacci(i) + "总耗时:" +
        // (System.currentTimeMillis() - beginTime));
        // }
        // beginTime = System.currentTimeMillis();
        // for (int i = 0; i < 100; i++) {
        // System.out.println("fibonacciBetter:位置" + i + ",结果 : " +
        // Long.toString(fibonacciBetter(i)) + "总耗时:"
        // + (System.currentTimeMillis() - beginTime));
        // }
        // 练习1.1.20
        // double doulbePractise1120 = practise1120(20);
        // System.out.println("练习1.1.20:" + doulbePractise1120);
        // 练习1.1.27
        // int practise1127N = 20;
        // int practise1127K = 10;
        // double practise1127P = 0.25;
        // double practise1127Result = practise1127(practise1127N,
        // practise1127K, practise1127P);
        // System.out.println("使用递归结果：" + practise1127Result);
        // practise1127Result = practise1127Better(practise1127N, practise1127K,
        // practise1127P);
        // System.out.println("使用循环结果：" + practise1127Result);
        // 练习1.1.30
        // practise1130(100);
        // 练习1.1.35
//		practise1135();
    }

    private static void practise1135() {
        int sides = 6;
        double[] dist = new double[2 * sides + 1];
        for (int i = 1; i <= sides; i++)
            for (int j = 1; j <= sides; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * sides; k++)
            dist[k] /= 36.0;
        for (int i = 2; i < dist.length; i++) {
            System.out.println("点数为" + i + "的概率是：" + dist[i]);
        }
    }

    private static void practise1130(int n) {
        boolean[][] a = new boolean[n][n];
        int x = 0;// x是平方不大于n的最大整数
        for (; (x + 1) * (x + 1) <= n; x++)
            ;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n; j++) {
                for (int k = 2; k <= x; k++) {
                    if (i % k == 0 && j % k == 0) {
                        a[i][j] = a[j][i] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static double practise1127Better(int n, int k, double p) {
        double[][] a = new double[n + 2][k + 2];
        // ... n = 1 k =1
        for (int i = -1; i <= n; i++)
            for (int j = -1; j <= k; j++) {
                if (i == 0 && j == 0) {
                    a[i + 1][j + 1] = 1.0;
                } else if (i < 0 || j < 0) {
                    a[i + 1][j + 1] = 0.0;
                } else {
                    a[i + 1][j + 1] = (1.0 - p) * a[i][j + 1] + p * a[i][j];
                }
            }

        return a[n + 1][k + 1];
    }

    private static int count = 0;

    private static double practise1127(int n, int k, double p) {
        // System.out.println("递归调用次数：" + ++count);
        // if (n == 0 && k == 0)
        // return 1.0;
        // if (n < 0 || k < 0)
        // return 0.0;
        // return (1.0 - p) * practise1127(n - 1, k, p) + p * practise1127(n -
        // 1, k - 1, p);
        return 0.0;
    }

    private static double practise1120(int n) {
        if (n == 1)
            return 0.0;
        return Math.log(n) + practise1120(n - 1);
    }

    private static long fibonacciBetter(int i) {
        if (i == 0 || i == 1)
            return 1l;
        long[] arr = new long[i + 1];
        arr[0] = arr[1] = 1l;
        for (int j = 2; j <= i; j++) {
            if (arr[j - 1] > (Long.MAX_VALUE / 2)) {
                arr[j] = Long.MAX_VALUE;
            } else {
                arr[j] = arr[j - 2] + arr[j - 1];
            }
        }
        return arr[i];
    }

    private static long fibonacci(int i) {
        if (i == 0 || i == 1)
            return 1l;
        return fibonacci(i - 2) + fibonacci(i - 1);

    }

    private static int practise1118Multiply(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return practise1118Multiply(a * a, b / 2);
        return practise1118Multiply(a * a, b / 2) * a;
    }

    private static int practise1118Add(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return practise1118Add(a + a, b / 2);
        return practise1118Add(a + a, b / 2) + a;
    }

    private static String practise1116(int i) {
        if (i <= 0)
            return "";
        return practise1116(i - 3) + i + practise1116(i - 2) + i;

    }

    private static int[] practise1115(int[] is, int i) {
        int[] arr = new int[i];
        for (int value : is) {
            if (value >= 0 && value < i) {
                arr[value]++;
            }
        }
        return arr;
    }

    private static void practise1114(Scanner in) {
        System.out.println("请输入一个大于0的整数N，我给你算出不大于log(2)N的最大整数");
        int n = in.nextInt();
        int currentValue = 1;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            if (i != 0) {
                currentValue *= 2;
            }
            if (currentValue > n) {
                System.out.println("不大于log(2)N的最大整数:" + (i - 1));
                return;
            } else if (currentValue == n) {
                System.out.println("不大于log(2)N的最大整数:" + i);
                return;
            }
        }

    }

    private static void practise1113() {
        int[][] twoDArrayy = new int[10][20];
        // 制造数组
        int value = 1;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 20; j++) {
                twoDArrayy[i][j] = value++;
            }
        // 打印转置之前
        System.out.print("\t");
        for (int i = 0; i < twoDArrayy[0].length; i++) {
            System.out.printf("%d%s\t", i + 1, "列");
        }
        System.out.println();
        for (int i = 0; i < twoDArrayy.length; i++) {
            System.out.printf("%d%s\t", i + 1, "行");
            for (int j = 0; j < twoDArrayy[0].length; j++) {
                System.out.printf("%d\t", twoDArrayy[i][j]);
            }
            System.out.println();
        }
        // 打印转置之后
        System.out.println();
        System.out.print("\t");
        for (int i = 0; i < twoDArrayy.length; i++) {
            System.out.printf("%d%s\t", i + 1, "列");
        }
        System.out.println();
        for (int i = 0; i < twoDArrayy[0].length; i++) {
            System.out.printf("%d%s\t", i + 1, "行");
            for (int j = 0; j < twoDArrayy.length; j++) {
                System.out.printf("%d\t", twoDArrayy[j][i]);
            }
            System.out.println();
        }

    }

    private static void practise1112() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - 1;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);

    }

    private static void practise1111() {
        boolean[][] twoDArray = new boolean[5][10];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 10; j++) {
                if (RandomUtils.random() > 0.5) {
                    twoDArray[i][j] = true;
                } else {
                    twoDArray[i][j] = false;
                }
            }
        for (int i = 0; i < twoDArray.length; i++) {
            System.out.println(Arrays.toString(twoDArray[i]));
        }

        System.out.print("\t");
        for (int i = 0; i < twoDArray[0].length; i++) {
            System.out.printf("%d\t", i + 1);
        }
        System.out.println();
        for (int i = 0; i < twoDArray.length; i++) {
            System.out.printf("%d\t", i + 1);
            for (int j = 0; j < twoDArray[i].length; j++) {
                if (twoDArray[i][j]) {
                    System.out.print("*\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }

    }

    private static void practise119(Scanner in) {
        System.out.println("请输入一个正整数，我将打印出它的二进制数字");
        int number = in.nextInt();
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (number > 0) {
            sb.append(number % 2);
            if (index % 8 == 0) {
                sb.append(" ");
            }

            number /= 2;
            index++;
        }
        StringBuilder valueSb = new StringBuilder(sb.toString());
        System.out.printf("二进制值\t:%s", valueSb.reverse().toString());
        System.out.println();
        if (sb.length() % 9 != 0) {
            for (int i = 0, len = (sb.length() / 9 + 1) * 9 - sb.length() - 1; i < len; i++) {
                sb.append("0");
            }
            System.out.printf("原码\t:%s", sb.reverse().toString());
            System.out.println();
        } else {
            System.out.println("该数字没有原码");
            System.out.printf("比 该数字大1的原码是\t：%s%s", "00000001", sb.reverse().toString());
            System.out.println();
            StringBuilder lessOne = new StringBuilder(sb.reverse().substring(0, sb.length() - 9));
            lessOne.append("11111110");
            System.out.printf("比 该数字小1的原码是\t：%s", lessOne.reverse().toString());
            System.out.println();
        }
    }

    private static void practise118() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    private static void practise117a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        System.out.printf("%.5f\n", t);
        System.out.println();
    }

    private static void practise117c() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);

    }

    private static void practise117b() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        System.out.println(sum);
    }

    private static void practise111() {
        System.out.println((0 + 15) / 2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);
    }

    private static void practise112() {
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");
    }

    private static void practise113(Scanner in) {
        L:
        for (; ; ) {
            System.out.println("请输入3个整数，用空格分隔");
            String inputStr = in.nextLine();
            String[] b = inputStr.split(" ");
            if (b == null || b.length != 3) {
                System.out.println("输入格式有误");
                continue;
            }
            for (int x = 0; x < b.length; x++) {
                for (int i = 0; i < b[x].length(); i++) {
                    if (!Character.isDigit(b[x].charAt(i))) {
                        System.out.println("输入格式有误");
                        continue L;
                    }
                }
                if (x > 0 && !b[x].equals(b[x - 1])) {
                    System.out.println("notequals");
                    return;
                }
            }
            System.out.println("equals");
            return;
        }
    }

    private static void practise115(Scanner in) {
        L115:
        for (; ; ) {
            System.out.println("请输入两个小数，以空格分隔");
            String inputStr115 = in.nextLine();
            String[] inputArray115 = inputStr115.split(" ");
            if (inputArray115 == null || inputArray115.length != 2) {
                System.out.println("输入格式有误");
                continue;
            }
            for (String str : inputArray115) {
                double digit;
                try {
                    digit = Double.parseDouble(str);
                } catch (NumberFormatException e) {
                    System.out.println("输入格式有误");
                    continue L115;
                }
                if (new Double(0.0).compareTo(digit) > 0 || new Double(1.0).compareTo(digit) < 0) {
                    System.out.println("false");
                    return;
                }
            }
            System.out.println("true");
            return;
        }

    }

    private static void practise116() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f += g;
            g = f - g;
        }
    }
}
