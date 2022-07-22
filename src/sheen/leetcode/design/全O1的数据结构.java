package sheen.leetcode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 全O1的数据结构
 * @Date 2022/3/16 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 全O1的数据结构 {
    public static void main(String[] args) {
        AllOne s = new AllOne();
        s.inc("hello");
        s.inc("hello");
        s.inc("world");
        s.inc("world");
        s.inc("hello");
        s.dec("world");
        System.out.println(s.getMaxKey());
        System.out.println(s.getMinKey());
        s.inc("world");
        s.inc("world");
        s.inc("leet");
        System.out.println(s.getMaxKey());
        System.out.println(s.getMinKey());
        s.inc("leet");
        s.inc("leet");
        System.out.println(s.getMinKey());
    }
    static class AllOne {

        private Node root = null;
        private Map<String, Node> map = new HashMap<>();
        public AllOne() {

        }

        public void inc(String key) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                node.set.remove(key);
                if(node.next.count == node.count + 1) {
                    node.next.set.add(key);
                    map.put(key, node.next);

                }else {
                    Node newNode = new Node();
                    newNode.set.add(key);
                    newNode.count = node.count + 1;
                    map.put(key, newNode);

                    Node next = node.next;
                    node.next = newNode;
                    newNode.pre = node;
                    next.pre = newNode;
                    newNode.next = next;
                }
                if(node.set.isEmpty()) {
                    removeNode(node);
                }
            }else {
                if(root == null || root.count > 1) {
                    Node node = new Node();
                    node.set.add(key);
                    map.put(key, node);
                    if(root == null) {
                        node.next = node;
                        node.pre = node;
                    }else {
                        Node wei = root.pre;
                        root.pre = node;
                        node.next = root;
                        node.pre = wei;
                        wei.next = node;
                    }
                    root = node;
                }else {
                    map.put(key, root);
                    root.set.add(key);
                }
            }
            print();
        }

        public void dec(String key) {
            Node node = map.get(key);
            if(node.count == 1) {
                map.remove(key);
                node.set.remove(key);
            }else {
                Node pre = node.pre;
                node.set.remove(key);
                if(pre.count == node.count - 1) {
                    pre.set.add(key);
                    map.put(key, pre);
                }else {
                    Node newNode = new Node();
                    newNode.count = node.count - 1;
                    newNode.set.add(key);
                    map.put(key, newNode);

                    newNode.pre = node.pre;
                    node.pre.next = newNode;
                    node.pre = newNode;
                    newNode.next = node;
                }
            }

            if(node.set.isEmpty()) {
                removeNode(node);
            }
            print();
        }

        private void removeNode(Node node) {
            if(node == root) {
                if(node.next != node) {
                    root = node.next.count > node.pre.count ? node.pre : node.next;
                }
            }
            Node pre = node.pre;
            Node next = node.next;
            if(pre == next && pre == node) {
                root = null;
            }else {
                pre.next = next;
                next.pre = pre;
            }
        }

        private void print() {
            if(root == null) {
                System.out.println("root == null");
            }else {
                String res = root.set + "=" + root.count + ",";
                Node next = root.next;
                while (next != root) {
                    res += next.set + "=" + next.count + ",";
                    next = next.next;

                }
                System.out.println(res);
            }
        }

        public String getMaxKey() {
            if(root == null) {
                return "";
            }
            return root.pre.set.iterator().next();
        }

        public String getMinKey() {
            if(root == null) {
                return "";
            }
            return root.set.iterator().next();
        }

        public static class Node{
            Set<String> set = new HashSet<>();
            int count = 1;
            Node pre;
            Node next;
        }
    }
}
