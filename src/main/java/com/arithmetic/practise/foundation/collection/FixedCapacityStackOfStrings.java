package com.arithmetic.practise.foundation.collection;

/**
 * 定容栈
 *
 * @author qixiafei
 */
public class FixedCapacityStackOfStrings {

    private String[] content;
    private int size;

    public FixedCapacityStackOfStrings(int cap) {
        content = new String[cap];
        size = 0;
    }

    public void push(String item) {
        content[size++] = item;
    }

    public String pop() {
        String contentStr = content[--size];
        content[size] = null;
        return contentStr;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size() == content.length;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack;
        stack = new FixedCapacityStackOfStrings(20);

        for (Character c : "Hello world!Baby".toCharArray()) {
            System.out.print(c);
            stack.push(c.toString());
        }
        System.out.println();
        FixedCapacityStackOfStrings stack2 = new FixedCapacityStackOfStrings(20);
        for (int i = 0, len = stack.size(); i < len; i++) {
            stack2.push(stack.pop());
        }
        for (int i = 0, len = stack2.size(); i < len; i++) {
            System.out.print(stack2.pop());
        }
    }
}
