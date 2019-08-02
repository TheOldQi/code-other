package com.arithmetic.practise.foundation.collection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayStack<Item> implements Iterable<Item> {

    private int initCap = 1;
    private Item[] content = (Item[]) new Object[initCap];
    private int size = 0;

    private void resize(int max) {
        Item[] contNew = (Item[]) new Object[max];
        int copyLength = size <= max ? size : max;
        for (int i = 0; i < copyLength; i++) {
            contNew[i] = content[i];
        }
        content = contNew;
    }

    public void push(Item item) {
        if (size == content.length)
            resize(size * 2);
        content[size++] = item;
    }

    public Item pop() {
        if (size == 0) {
            return null;
        }
        Item value = content[--size];
        content[size] = null;
        if (content.length > (initCap) && size <= (content.length / 4))
            resize(content.length / 2);
        return value;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public Item peek() {
        return content[size - 1];
    }

    public int length() {
        return content.length;
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator<Item>();
    }

    private class ReverseIterator<Item> implements Iterator<Item> {
        private int itLength = size;

        public boolean hasNext() {
            return itLength > 0;
        }

        public Item next() {
            return (Item) content[--itLength];
        }

        public void remove() {
            throw new UnsupportedOperationException("不允许使用迭代器删除");
        }

    }
}
