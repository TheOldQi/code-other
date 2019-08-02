package com.arithmetic.practise.foundation.collection;

import java.util.Iterator;

public class ResizingArrayQueueOfStrings implements Iterable<String> {

    int initCap = 1;
    private String[] content = new String[initCap];
    private int n;

    private void resize(int max) {
        int copyLen;
        if (max >= n) {
            copyLen = n;
        } else {
            copyLen = max;
        }
        String[] newContent = new String[max];
        for (int i = 0; i < copyLen; i++) {
            newContent[i] = content[i];
        }
        content = newContent;
    }

    public void enqueue(String s) {
        if (n == content.length) {
            resize(n * 2);
        }
        content[n++] = s;
    }

    public String dequeue() {
        String result = content[--n];
        content[n] = null;
        if (n > initCap && n < content.length / 4) {
            resize(content.length / 2);
        }
        return result;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<String> {
        int max = n;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < n;
        }

        @Override
        public String next() {
            // TODO Auto-generated method stub
            return content[index++];
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub

        }

    }

}
