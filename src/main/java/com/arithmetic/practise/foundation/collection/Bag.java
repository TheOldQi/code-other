package com.arithmetic.practise.foundation.collection;

import java.util.Iterator;

/**
 * 背包数据结构
 *
 * @author qixiafei
 */
public class Bag<Item> implements Iterable<Item> {

    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    void add(Item item) {

    }

    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return null;
    }


}
