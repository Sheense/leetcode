package com.company.hash;

import java.util.ArrayList;
import java.util.List;

public class 设计哈希集合 {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(2);
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }
    static class MyHashSet {

        /** Initialize your data structure here. */
        private class Node{
            Node next;
            int val;
        }
        private static final int size = 10000;
        private Node[] map;
        public MyHashSet() {
             map = new Node[size];
        }

        public void add(int key) {
            int index = key % size;
            if(map[index] == null) {
                map[index] = new Node();
                map[index].val = key;
            } else {
                Node pre = null;
                Node node = map[index];
                while(node != null) {
                    if(node.val == key) return;
                    pre = node;
                    node = node.next;
                }
                pre.next = new Node();
                pre.next.val = key;
            }
        }

        public void remove(int key) {
            int index = key % size;
            Node pre = null;
            Node node = map[index];
            while (node != null) {
                if(node.val == key) {
                    if(pre == null) {
                        map[index] = node.next;
                    } else {
                        pre.next = node.next;
                    }
                    break;
                }
                pre = node;
                node = node.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int index = key % size;
            Node node = map[index];
            while(node != null) {
                if(node.val == key) return true;
                node = node.next;
            }
            return false;
        }
    }
}
