package com.arithmetic.practise.foundation.collection;

import java.util.Iterator;

/**
 * 栈，LIFO后进先出
 *
 * @author qixiafei
 */
public class LinkedStack<Item> implements Iterable<Item> {

    private int n = 0; // 元素数量
    private Node first = null;
    private Node last = null;

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Node oldFirst = first;
        first = first.next;
        n--;
        return oldFirst.item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        return first.item;
    }

    public static LinkedStack<String> copy(LinkedStack<String> ori) {
        LinkedStack<String> newStack = new LinkedStack<>();
        String[] strArray = new String[ori.size()];
        int index = ori.size();
        for (String s : ori) {
            strArray[--index] = s;
        }
        for (int i = 0; i < ori.size(); i++) {
            newStack.push(strArray[i]);
        }
        return newStack;
    }

    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new IteratStack();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class IteratStack implements Iterator<Item> {
        Node currentNode = first;

        @Override
        public boolean hasNext() {

            return currentNode != null;
        }

        @Override
        public Item next() {
            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub

        }

    }
}
