package com.jvm.zhouzhiming.practise.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Description: Jconsole工具测试.
 * </P>
 * <p>
 * CALLED BY: 齐霞飞
 * </P>
 * <p>
 * UPDATE BY: 齐霞飞
 * </P>
 * <p>
 * CREATE DATE: 2017年9月6日
 * </P>
 * <p>
 * UPDATE DATE: 2017年9月6日
 * </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class JconsoleTest {


    public static void main(String[] args) {
        try {
            fillHeap(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍微添加延迟让Jconsole曲线看上去更加明显
            Thread.sleep(50);
            list.add(new OOMObject());

        }
        System.gc();
    }

    static class OOMObject {
        public byte[] placeHolder = new byte[1 << 20];
    }
}
