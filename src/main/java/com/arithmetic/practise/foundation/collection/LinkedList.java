package com.arithmetic.practise.foundation.collection;

import java.util.Iterator;

/**
 * 自己实现链表
 *
 * @author qixiafei
 */
public class LinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n = 0;

    public Node getFirst() {
        return first;
    }

    public void add(Item item) {
        if (n == 0) {
            first = last = new Node();
            first.setItem(item);
            first.setNext(null);
        } else {
            Node newNode = new Node();
            newNode.setItem(item);
            last.setNext(newNode);
            last = newNode;
        }
        n++;
    }

    public boolean delete(int k) {
        if (n < k)
            return false;
        Node tempNode = first;
        for (int i = 2; i < k; i++) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(tempNode.getNext().getNext());
        n--;
        return true;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new AscIterator();
    }

    public boolean removeAfter(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        node.next = null;
        return true;
    }

    public boolean insertAfter(Node nodePre, Node nodeSuff) {
        if (nodePre == null || nodeSuff == null) {
            return false;
        }
        nodeSuff.next = nodePre.next;
        nodePre.next = nodeSuff;
        return true;
    }

    public static boolean find(LinkedList<String> list, String key) {
        if (key == null)
            return false;
        for (String s : list) {
            if (key.equals(s)) {
                return true;
            }
        }

        return false;
    }

    public static boolean remove(LinkedList<String> list, String key) {
        if (key == null || list == null || list.isEmpty())
            return false;
        Node curr = list.getFirst();
        boolean isRemove = false;
        for (int i = 0, len = list.size(); i < len; i++) {
            if (key.equals(curr.item)) {
                list.delete(i + 1);
                if (!isRemove) {
                    isRemove = true;
                }
            } else {
                curr = curr.next;
            }
        }
        return isRemove;

    }

    public static int max(Node<Integer> firstNode) {
        if (firstNode == null)
            return 0;
        int max = 0;
        while (firstNode != null) {
            if (firstNode.item != null && max < firstNode.item) {
                max = firstNode.item;
            }
            firstNode = firstNode.next;
        }
        return max;
    }

    public static int maxRecursive(Node<Integer> firstNode) {
        if (firstNode == null)
            return 0;
        int num1 = firstNode.item;
        int num2 = maxRecursive(firstNode.next);
        return num1 > num2 ? num1 : num2;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 100; i > 0; i--) {
            list.add(i);
        }
        System.out.println(list.maxRecursive(list.first));
    }

    @Override
    public String toString() {
        Node curr = first;
        StringBuilder sb = new StringBuilder("[");
        while (curr != null) {
            sb.append(curr.item);
            sb.append(",");
            curr = curr.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private static class Node<Item> {
        private Item item;
        private Node next;

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private class AscIterator implements Iterator<Item> {
        private Node currentNode = first;

        @Override
        public boolean hasNext() {

            return currentNode != null;
        }

        @Override
        public Item next() {
            Item item = (Item) currentNode.item;
            currentNode = currentNode.next;
            return item;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub

        }

    }
}
