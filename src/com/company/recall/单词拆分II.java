package com.company.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 单词拆分II {

    public static void main(String[] args) {
        单词拆分II s =new 单词拆分II();
        System.out.println(s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Node[] hash = new Node[26];
        for(String str :wordDict) {
            int index = (str.charAt(0)-'a')%26;
            if(hash[index] == null) {
                hash[index] = new Node();
            }
            hash[index].list.add(str);
        }
        List<String> res = new ArrayList<>();
        recall(res, s, 0, hash, new StringBuilder());
        return res;
    }

    public void recall(List<String> res, String s, int start, Node[] hash, StringBuilder now) {
        if(s.length()==start) {
            res.add(now.toString().substring(0, now.toString().length()-1));
            return ;
        }
        int index = (s.charAt(start)-'a')%26;
        if(hash[index]==null) return;
        List<String> list = hash[index].list;
        for(String string:list){
            if(string.length()<=s.length()-start&&string.equals(s.substring(start, string.length()+start))) {
                StringBuilder sb = new StringBuilder(now);
                sb.append(string+" ");
                recall(res, s, string.length()+start, hash, sb);
            }
        }
    }

    public class Node{
        List<String> list = new ArrayList<>();
    }
}
