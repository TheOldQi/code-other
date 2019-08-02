package com.jvm.zhouzhiming.practise.chapter3;

/**
 * <P>Description: 测试内存分配. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月6日 </P>
 * <P>UPDATE DATE: 2017年9月6日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class TestAllocation {
    private static final int BYTE_1MB = 1024 * 1024;

    public static void main(String[] args) {
        final byte[] a = new byte[BYTE_1MB << 1];
        final byte[] b = new byte[BYTE_1MB << 1];
        final byte[] c = new byte[BYTE_1MB << 2];
    }
}
