package com.arithmetic.practise.foundation.analysis.arithmetics;

import com.arithmetic.practise.foundation.collection.ArrayStack;
import com.arithmetic.practise.foundation.collection.LinkedStack;

public class P1443 {

    public static void main(String[] args) {
//		for (int i = 1; i < Integer.MAX_VALUE >>> 1; i <<= 1) {
//			testArrayStack(i);
//			testLinkedStack(i);
//		}
        System.out.println(2.0 - 1.1);
    }

    public static void testArrayStack(int size) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            stack.push(i);
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
        System.out.printf("可变数组实现栈，%d\t%f", size, (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println();
    }

    public static void testLinkedStack(int size) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            stack.push(i);
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
        System.out.printf("链表实现栈，%d\t%f", size, (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println();
    }
}
