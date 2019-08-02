package com.jvm.zhouzhiming.practise.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * <P>Description: 堆内存溢出测试  设置虚拟机参数-Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/10/9</P>
 * <P>UPDATE DATE: 2017/10/9</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
public class HeapOOMTest {

    public static void main(String[] args) {
        final List<String> oList = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            oList.add(String.valueOf(i));
        }
    }
}
