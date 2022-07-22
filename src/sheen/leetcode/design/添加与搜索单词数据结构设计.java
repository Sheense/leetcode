package sheen.leetcode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 添加与搜索单词数据结构设计
 * @Date 2021/10/19 12:40 上午
 * @Created by sheen
 * @Description TODO
 */
public class 添加与搜索单词数据结构设计 {
    class WordDictionary {

        private Map<Character, Node> map = new HashMap<>();
        public WordDictionary() {

        }

        public void addWord(String word) {
            add(word, 0, map);
        }

        private void add(String word, int index, Map<Character, Node> map) {
            char c = word.charAt(index);
            Node node;
            if(map.containsKey(c)) {
                node = map.get(c);
            }else {
                node = new Node();
                map.put(c, node);
            }
            map = node.child;
            if(index == word.length() - 1) {
                node.end.add(word);
                return;
            }
            add(word, index + 1, map);
        }

        public boolean search(String word) {
            return find(word, "", 0, map);
        }

        private boolean find(String word, String now, int index, Map<Character, Node> map) {
            char c = word.charAt(index);
            if(c == '.') {
                for(Map.Entry<Character, Node> entry : map.entrySet()) {
                    if(index == word.length() - 1) {
                        if(entry.getValue().end.contains(now + entry.getKey())) {
                            return true;
                        }
                        continue;
                    }
                    boolean flag = find(word, now + entry.getKey(), index + 1, entry.getValue().child);
                    if(flag) {
                        return true;
                    }
                }
                return false;
            }else {
                if(!map.containsKey(c)) {
                    return false;
                }
                Node node = map.get(c);
                if(index == word.length() - 1) {
                    if(node.end.contains(now + c)) {
                        return true;
                    }
                    return false;
                }else {
                    return find(word, now + c, index + 1, node.child);
                }
            }
        }
    }

    public static class Node{
        Map<Character, Node> child = new HashMap<>();
        Set<String> end = new HashSet<>();
    }
}
