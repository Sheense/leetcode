package sheen.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class LRU缓存 {
    public static void main(String[] args) {
        LRUCache s = new LRUCache(2);
        s.put(1, 1);
        s.put(2, 2);
        System.out.println(s.get(1));
        s.put(3, 3);
        System.out.println(s.get(2));
        s.put(4,4);
        System.out.println(s.get(1));
        System.out.println(s.get(3));
        System.out.println(s.get(4));
    }
    static class LRUCache {

        private int size = 0;
        private int capacity = 0;
        private Map<Integer, Node> map = new HashMap<>();
        private Node head = null;


        private class Node {
            Node pre;
            Node last;
            int key;
            int val;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                update(key, map.get(key));
                return map.get(key).val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(this.capacity == 0) return ;
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                update(key, node);
                return ;
            }
            if(this.size == this.capacity) {
                map.remove(head.key);
                Node pre = head.pre;
                Node last = head.last;
                last.pre = pre;
                head = last;
                this.size --;
            }
            Node node = new Node();
            node.val = value;
            node.key = key;
            add(key, node);
            this.size++;
        }

        private void add(int key, Node value) {
            if (head == null) {
                head = value;
                head.pre = head;
                head.last = head;
            } else {
                Node pre = head.pre;
                pre.last = value;
                value.pre = pre;
                head.pre = value;
                value.last = head;
            }
            this.map.put(key, value);
        }

        private void update(int key, Node value) {
            if (value == head) {
                head = head.last;
            } else {
                Node pre = value.pre;
                Node last = value.last;
                pre.last = last;
                last.pre = pre;
                add(key, value);
            }
        }
    }
}
