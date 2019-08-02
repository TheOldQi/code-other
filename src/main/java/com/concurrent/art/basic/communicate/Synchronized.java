package com.concurrent.art.basic.communicate;

/**
 * <P>Description: synchronized关键字同步代码块和方法，使用
 * javac -encoding UTF-8 Synchronized.java
 * javap -v Synchronized.class查看生成的字节码. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class Synchronized {


    public static void main(String[] args) {
        synchronized (Synchronized.class) {

        }
        m();
    }

    public static synchronized void m() {

    }
}
