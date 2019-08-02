package com.jvm.zhouzhiming.practise.chapter7;

import java.io.IOException;
import java.io.InputStream;

/**
 * <P>Description: 不同的类加载器加载的类绝对不会相等. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月22日 </P>
 * <P>UPDATE DATE: 2017年9月22日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class ClassLoaderInstanceOf {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        {
            int[][][] a = new int[1][0][-1];
        }

        ClassLoader cl1 = new ClassLoader() {
            @Override
            public Class<?> loadClass(String fullName) throws ClassNotFoundException {
                try {
                    String fileName = fullName.substring(fullName.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fullName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(fullName, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(fullName);
                }
            }
        };

        Object obj = cl1.loadClass("com.jvm.zhouzhiming.practise.chapter7.ClassLoaderInstanceOf").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.jvm.zhouzhiming.practise.chapter7.ClassLoaderInstanceOf);
    }
}
