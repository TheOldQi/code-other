package com.self.classloader;

import java.net.URLClassLoader;

/**
 * <P>Description: 类加载的过程是这样的，当想用Class.forName(). 或 getClassLoader.loadClass()时，优先从父类加载器中查找是否存在这个类，
 * 如果存在则使用父类加载器加载（递归），这样就保证了jdk源码的类不会被替换.</P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月19日 </P>
 * <P>UPDATE DATE: 2017年9月19日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        // 主线程使用系统类加载器
        System.out.println(ClassLoaderTest.class.getClassLoader());
        // Ext类加载器 负责加载jre/lib/ext文件夹下的类包
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
        // Bootstrap类加载器 负责加载jdk源码类，由c语言实现，所以是null。
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent());

        Thread a = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

            }
        });
    }
}
