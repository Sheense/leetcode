package com.company.recall;

import java.util.*;

public class 单词拆分II {


    public static void main(String[] args) {
        单词拆分II s =new 单词拆分II();
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> hash = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();

        return res;
    }

    public void recall(List<String> res, String s, int start, Map<String, List<String>> hash,Set<String> set) {
        if(start == s.length()) return ;

        for(String str : set) {
            List<String> list = hash.get(start);
            for(String string : list) {

            }
        }
    }


}
