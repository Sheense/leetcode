package com.company.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 前缀和后缀搜索
 * @Date 2022/7/14 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 前缀和后缀搜索 {
    public static void main(String[] args) {
        WordFilter s = new WordFilter(new String[]{"apple"});
        s.f("a", "e");
    }

    static class WordFilter {

        private Node[] pre = new Node[26];
        private Node[] suffix = new Node[26];
        public WordFilter(String[] words) {
            Map<String, Set<Integer>> map = new HashMap<>();
            for(int i = 0; i < words.length; i++) {
                map.computeIfAbsent(words[i], x -> new HashSet<>()).add(i);
            }

            for(String key : map.keySet()) {
                buildPre(key, 0, map.get(key), pre);
                buildSuff(key, key.length() - 1, map.get(key), suffix);
            }
        }

        public int f(String pref, String suff) {
            int[] set1 = findPre(0, pre, pref);
            int[] set2 = findSuf(suff.length() - 1, suffix, suff);
            if(set1.length == 0 || set2.length == 0) {
                return -1;
            }
            int res = -1;
            for(int i = 0; i < set1.length; i++) {
                int r = set1[i] & set2[i];
                for(int j = 0; j < 30; j++) {
                    if((r & 1) == 1) {
                        res = Math.max(res, j + i * 30);
                    }
                    r >>= 1;
                }
            }
            return res;
        }

        private int[] findPre(int index, Node[] nodes, String pre) {
            Node node = nodes[pre.charAt(index) - 'a'];
            if(node == null) {
                return new int[]{};
            }
            if(index == pre.length() - 1) {
                return node.set;
            }
            return findPre(index + 1, node.next, pre);
        }

        private int[] findSuf(int index, Node[] nodes, String pre) {
            Node node = nodes[pre.charAt(index) - 'a'];
            if(node == null) {
                return new int[]{};
            }
            if(index == 0) {
                return node.set;
            }
            return findSuf(index - 1, node.next, pre);
        }

        private void buildPre(String str, int index, Set<Integer> set, Node[] nodes) {
            if(index >= str.length()) {
                return;
            }

            Node node = nodes[str.charAt(index) - 'a'];
            if(node == null) {
                nodes[str.charAt(index) - 'a'] = new Node();
                node = nodes[str.charAt(index) - 'a'];
            }
            add(node.set, set);
            buildPre(str, index + 1, set, node.next);
        }

        private void buildSuff(String str, int index, Set<Integer> v, Node[] nodes) {
            if(index < 0) {
                return;
            }

            Node node = nodes[str.charAt(index) - 'a'];
            if(node == null) {
                nodes[str.charAt(index) - 'a'] = new Node();
                node = nodes[str.charAt(index) - 'a'];
            }
            add(node.set, v);
            buildSuff(str, index - 1, v, node.next);
        }

        private void add(int[] set, Set<Integer> v) {
            for(int i : v) {
                int slot = i / 30;
                int yu = i % 30;
                int bit = 1 << yu;
                set[slot] |= bit;
            }
        }
        //30
        private static class Node{
            int[] set = new int[334];
            Node[] next = new Node[26];
        }
    }

}
