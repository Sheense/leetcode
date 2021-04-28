package com.company.dfs;

import java.util.*;

public class 单词转换 {
    public static void main(String[] args) {
        单词转换 s = new 单词转换();
        System.out.println(s.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return new ArrayList<>();
        wordSet.add(beginWord);
        //计算只变化一个字母的集合
        Map<String, Set<String>> changeMap = getChangeMap(wordSet);
        wordSet.remove(beginWord);
        Map<String, List<List<String>>> path = new HashMap<>();
        List<String> l = new ArrayList<>();
        l.add(beginWord);
        path.computeIfAbsent(beginWord, x -> new ArrayList<>()).add(l);
        while (path.size() != 0 && wordSet.size() != 0) {
            Map<String, List<List<String>>> newPath = new HashMap<>();
            Set<String> arriveWord = new HashSet<>();
            for(String word:wordSet) {
                for(String key: path.keySet()) {
                    if(changeMap.get(word).contains(key)) {
                        for(List<String> item: path.get(key)) {
                            List<String> newItem = new ArrayList<>(item);
                            newItem.add(word);
                            if (word.equals(endWord)) {
                                return newItem;
                            }
                            newPath.computeIfAbsent(word, x -> new ArrayList<>()).add(newItem);
                        }
                        arriveWord.add(word);
                    }
                }
            }
            wordSet.removeAll(arriveWord);
            path = newPath;
        }
        return new ArrayList<>();
    }

    public Map<String, Set<String>> getChangeMap(Set<String> words) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String key:words) {
            Set<String> item = new HashSet<>();
            for(int i=0;i<key.length();i++) {
                for (int j = 0; j < 26; j++) {
                    String newWord;
                    char c = (char) (j + 'a');
                    if (i == 0) {
                        newWord = c + key.substring(i + 1);
                    } else if (i == key.length() - 1) {
                        newWord = key.substring(0, key.length() - 1) + c;
                    } else {
                        newWord = key.substring(0, i) + c + key.substring(i + 1);
                    }
                    item.add(newWord);
                }
            }
            map.put(key, item);
        }
        return map;
    }
}
