package com.company.bfs;

import java.util.*;

public class 单词接龙 {

    public static void main(String[] args) {
        单词接龙 s = new 单词接龙();
        System.out.println(s.ladderLength("lost","cost", Arrays.asList("most","fist","lost","cost","fish")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> set = new HashSet<>();
        if(words.contains(endWord)) {
            set.add(endWord);
            words.remove(endWord);
        }
        else return 0;
        Map<String, Set<String>> check = new HashMap<>();
        for(int i=0;i<wordList.size();i++) {
            Set hashSet = new HashSet();
            for(int j = 0;j<beginWord.length();j++) {
                for(char z= 'a';z<='z';z++) {
                    String s;
                    if(j==0) {
                        s =  z+wordList.get(i).substring(j+1);
                    }else {
                        s = wordList.get(i).substring(0,j) + z+wordList.get(i).substring(j+1);
                    }
                    hashSet.add(s);
                }
            }
            check.put(wordList.get(i), hashSet);
        }
        if(words.size()==0) {
            if(endWord.equals(beginWord)) return 1;
            if(check.get(endWord).contains(beginWord)) return 2;
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put(endWord, 0);
        while(words.size()!=0&&set.size()!=0) {
            Set<String> other = new HashSet<>();
            for(String string:words) {
                for(String str:set) {
                   if(check.get(str).contains(string)) {
                       other.add(string);
                       map.put(string, map.get(str)+1);
                       break;
                   }
                }
            }
            int min = Integer.MAX_VALUE;
            for (String str:other) {
                if(str.equals(beginWord)||check.get(str).contains(beginWord)){
                    if(str.equals(beginWord)){
                        return map.get(str)+1;
                    }
                    min = map.get(str)+2;
                }
            }
            if(min!=Integer.MAX_VALUE) return  min;
            set = other;
            words.removeAll(other);
        }
        return 0;
    }

}
