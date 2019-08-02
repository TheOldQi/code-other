package com.self;

import java.io.File;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2018/1/18</P>
 * <P>UPDATE DATE: 2018/1/18</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File(".");
        for (String fileName : file.list()) {
            System.out.println(fileName);
        }
    }
}
