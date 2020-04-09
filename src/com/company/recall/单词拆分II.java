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
        recall(res, s, 0, hash, new StringBuilder(), set);
        return res;
    }

    public void recall(List<String> res, String s, int start, Map<String, List<String>> hash, StringBuilder now,Set<String> set) {
        if(s.length()==start) {
            res.add(now.toString().substring(0, now.toString().length()-1));
            return ;
        }

        for(String str : set) {

        }
    }


}
