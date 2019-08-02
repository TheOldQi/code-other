package com;

import java.util.Currency;
import java.util.Locale;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/25</P>
 * <P>UPDATE DATE: 2017/12/25</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class OneTimeTest {
    public static void main(String[] args) {
//        int count = 0;
//        long start = System.currentTimeMillis();
//        while ((System.currentTimeMillis() - start) <= 1000) {
//            final String uuid = UUID.randomUUID().toString().replace("-", "");
//            System.out.println(uuid);
//            count++;
//        }
//        System.out.println(count);
        System.out.println(Currency.getInstance(Locale.SIMPLIFIED_CHINESE));
        System.out.println(Currency.getInstance("CNY"));
    }
}
