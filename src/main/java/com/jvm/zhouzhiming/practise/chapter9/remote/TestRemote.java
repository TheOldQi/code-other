package com.jvm.zhouzhiming.practise.chapter9.remote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * Description: .
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
public class TestRemote {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("C:/Users/qixiafei/javapractise/AvailableProcessors.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        System.out.println(JavaClassExecuter.execute(b));
    }
}
