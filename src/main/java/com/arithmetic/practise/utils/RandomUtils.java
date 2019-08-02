package com.arithmetic.practise.utils;


/**
 * 随机数工具类
 *
 * @author qixiafei
 */
public class RandomUtils {

    /**
     * 设置随机生成器的种子
     *
     * @param seed 种子
     */
    public static void setSeed(long seed) {

    }

    /**
     * 随机生成的0-1之间(不包含边界)的实数
     *
     * @return 随机生成数
     */
    public static double random() {

        return Math.random();
    }

    /**
     * 随机生成0到n之间(不包含边界)的整数
     *
     * @param n 上限不包含
     * @return 随机生成数
     */
    public static int uniform(int n) {

        return (int) (random() * n);
    }

    /**
     * 随机生成lo-hi之间的整数
     *
     * @param lo 下限不包含
     * @param hi 上限不包含
     * @return 随机生成数
     */
    public static int uniform(int lo, int hi) {
        return lo + (int) (random() * (hi - lo));
    }

    /**
     * 随机生成lo-hi之间的实数
     *
     * @param lo 下限不包含
     * @param hi 上限不包含
     * @return 随机生成数
     */
    public static double uniform(double lo, double hi) {
        return lo + random() * (hi - lo);
    }

    /**
     * 返回真的概率为p
     *
     * @param p 概率
     * @return 随机真假，但真的概率是p
     */
    public static boolean bernoulli(double p) {
        return false;
    }

    /**
     * 正态分布，期望值为0，标准差是1
     *
     * @return 正态分布值
     */
    public static double gaussian() {
        return 0.0;
    }

    /**
     * 正态分布，期望值为m，标准差是s
     *
     * @param m 期望值
     * @param s 标准差
     * @return 正态分布值
     */
    public static double gaussian(double m, double s) {
        return 0.0;
    }

    /**
     * 返回i的概率是a[i]
     *
     * @param a double数组，数组各项的和必须等于1
     * @return 0到a.length之间（包含边界）的整数
     */
    public static int discrete(double[] a) {
        if (a == null || a.length == 0)
            return -1;
        double sum = 0.0;
        for (double value : a) {
            sum += value;
        }
        if (new Double(sum).compareTo(new Double(1.0)) != 0) {
            return -1;
        }
        double r = random();
        double total = 0.0;// 累计值
        for (int i = 0; i < a.length; i++) {
            total += a[i];
            if (total >= r)
                return i;
        }
        return -1;
    }

    /**
     * 将数组顺序打乱
     *
     * @param a 待打乱顺序数组
     */
    public static <T> void shuffle(Comparable<T>[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            int randomIndex = uniform(i - 1);
            Comparable<T> temp = a[i];
            a[i] = a[randomIndex];
            a[randomIndex] = temp;
        }
    }

    /**
     * 生成一个随机double数组.
     *
     * @param size 数组大小
     * @return 随机double数组
     */
    public static Double[] randomArray(final int size) {
        Double[] a = new Double[size];
        for (int i = 0; i < size; i++) {
            a[i] = uniform(0.0, size);
        }
        return a;
    }
}
