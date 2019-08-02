package com.arithmetic.practise.foundation.collection;

import java.util.Iterator;

/**
 * 队列，FIFO先进先出
 *
 * @author qixiafei
 */
public class Queue<Item> implements Iterable<Item> {

    private int size = 0;

    public void enqueue(Item item) {

    }

    public Item dequeue() {
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}

