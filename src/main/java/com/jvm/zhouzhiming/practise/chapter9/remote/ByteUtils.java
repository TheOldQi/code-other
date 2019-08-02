package com.jvm.zhouzhiming.practise.chapter9.remote;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <p>
 * Description: 字节处理工具.
 * </P>
 * <p>
 * CALLED BY: 齐霞飞
 * </P>
 * <p>
 * UPDATE BY: 齐霞飞
 * </P>
 * <p>
 * CREATE DATE: 2017年9月25日
 * </P>
 * <p>
 * UPDATE DATE: 2017年9月25日
 * </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class ByteUtils {
    private ByteUtils() {

    }

    public static void main(String[] args) {
        byte[] b = new byte[10];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (-i);
        }
        System.out.println(bytes2Int(b, 0, 10));
        // System.out.println(Arrays.toString(int2Bytes(bytes2Int(b,0,10),10)));
    }

    /**
     * 把字节数组的一部分（不超过4个）元素分别放入int的四个字节之内，从高最高的8位开始，
     * 例如：4个字节元素，那么int的第一个字节（从左往右）就放第一个元素，最后一个字节就
     * 放最后一个字节元素，如果是3个字节元素，那么int的第二个字节就是第一个元素.
     *
     * @param b     字节数组.
     * @param start 从哪个元素开始
     * @param len   一共多少个元素
     * @return 包含转化元素字节的整型
     */
    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            // 取b[i]的8位，符号位当做数据.
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum += n;
        }
        return sum;
    }

    /**
     * 将整型的四位拆分成字节数组，每一位当做一个字节.
     *
     * @param value 整型值
     * @param len   字节数组长度，不能超过四个
     * @return 字节数组，第一位是整型的第len个字节（从左到右）
     */
    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }

    /**
     * 将原字节数组的部分替换成新的字节数组的内容.
     *
     * @param orig    原字节数组
     * @param offset  从哪个位置开始替换
     * @param len     替换的长度
     * @param replace 替换的数组内容
     * @return 新的数组
     */
    public static byte[] bytesReplace(byte[] orig, int offset, int len, byte[] replace) {
        byte[] newBytes = new byte[orig.length];
        System.arraycopy(orig, 0, newBytes, 0, offset);
        System.arraycopy(replace, 0, newBytes, offset, len);
        System.arraycopy(orig, offset + len, newBytes, offset + len, newBytes.length - offset - len);
        return newBytes;
    }
}
