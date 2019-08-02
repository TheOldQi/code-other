package com.jvm.zhouzhiming.practise.chapter3;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月4日 </P>
 * <P>UPDATE DATE: 2017年9月4日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class References {

    public static void main(String[] args) throws InterruptedException {
        References ref = new References();
//		WeakReference<References> wRef = new WeakReference<References>(ref);
        PhantomReference<References> pRef = new PhantomReference<References>(ref, null);
//		ref = null;
        System.gc();
        Thread.sleep(500);
        System.out.println("object is " + ref);
//		System.out.println("wRef is "+wRef);
        System.out.println("pRef is " + pRef.get());
    }
}
