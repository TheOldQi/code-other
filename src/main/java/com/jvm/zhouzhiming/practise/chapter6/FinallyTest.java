package com.jvm.zhouzhiming.practise.chapter6;

import java.util.HashMap;
import java.util.Map;

/**
 * <P>Description: Finally执行顺序测试. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月21日 </P>
 * <P>UPDATE DATE: 2017年9月21日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class FinallyTest {

    public static int getInt() {
        int x;
        try {
            x = 1;
            return x;

        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        try {
            map.put("xx", "exec");
            return map;

        } catch (Exception e) {
            map.put("xx", "exception");
            return map;
        } finally {
            map.put("xx", "finally");
            map = null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getInt());
        System.out.println(getMap());

    }
}
