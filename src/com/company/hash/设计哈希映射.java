package com.company.hash;

public class 设计哈希映射 {
    class MyHashMap {

        class Node{
            Node next = null;
            int key;
            int value;
        }
        private int size = 10000;
        private Node[] map;
        /** Initialize your data structure here. */
        public MyHashMap() {
            map = new Node[size];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = key % size;
            Node node = map[index];
            while (node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            if (map[index] == null) {
                map[index] = new Node();
            } else {
                Node n = new Node();
                n.next = map[index];
                map[index] = n;
            }
            map[index].key = key;
            map[index].value = value;

        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = key % size;
            Node node = map[index];
            while (node != null) {
                if(node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = key % size;
            Node node = map[index];
            Node pre = null;
            while (node != null) {
                if(node.key == key) {
                    if(pre == null) {
                        map[index] = node.next;
                    } else {
                        pre.next = node.next;
                    }
                    return;
                }
                pre = node;
                node = node.next;
            }
        }
    }
}
