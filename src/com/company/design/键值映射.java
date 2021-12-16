package com.company.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 键值映射
 * @Date 2021/11/14 12:19 下午
 * @Created by sheen
 * @Description TODO
 */
public class 键值映射 {
    class MapSum {

        private Node[] root = new Node[26];
        private Map<String, Integer> map = new HashMap<>();
        public MapSum() {
        }

        public void insert(String key, int val) {
            if(!map.containsKey(key)) {
                insert(root, key, 0);
            }
            map.put(key, val);
        }

        public int sum(String prefix) {
            List<String> list =  find(root, prefix, 0);
            int res = 0;
            for(int i = 0;i < list.size(); i++) {
                res += map.getOrDefault(list.get(i), 0);
            }
            return res;
        }

        private List<String> find(Node[] nodes, String str, int index) {
            int key = str.charAt(index) - 'a';
            if(nodes[key] == null) {
                return new ArrayList<>();
            }
            if(index == str.length() - 1) {
                return nodes[key].pre;
            }

            return find(nodes[key].next, str, index + 1);
        }

        private void insert(Node[] nodes, String str, int index) {
            if(index >= str.length()) {
                return;
            }
            int key = str.charAt(index) - 'a';
            if(nodes[key] == null) {
                nodes[key] = new Node();
            }
            nodes[key].pre.add(str);
            insert(nodes[key].next, str, index + 1);
        }

        private class Node {
            Node[] next = new Node[26];
            List<String> pre = new ArrayList<>();
        }
    }

}
