package com.arithmetic.practise.foundation.collection;

import java.util.Iterator;

/**
 * 环形链表队列
 *
 * @author qixiafei
 */
public class RingLinkedQueue<Item> implements Iterable<Item> {

    private Node<Item> last;
    private int n;

    public void enqueue(Item item) {
        if (last == null) {
            Node<Item> newNode = new Node<>();
            newNode.item = item;
            newNode.next = newNode;
            last = newNode;
        } else {
            Node<Item> newNode = new Node<>();
            newNode.item = item;
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        n++;
    }

    public Item dequeue() {
        if (last == null)
            return null;
        Node<Item> first = last.next;
        Item item = first.item;
        last.next = first.next;
        first.next = null;
        n--;
        return item;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new AscIt<Item>();
    }

    private class AscIt<IT> implements Iterator<Item> {

        Node<IT> curr = (Node<IT>) last.next;
        ;
        int size;
        int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Item next() {
            Item item = (Item) curr.item;
            curr = curr.next;
            index++;
            return item;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub

        }

    }

    private static class Node<T> {
        T item;
        Node<T> next;
    }
}
