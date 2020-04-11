package com.company.recall;

import java.util.*;

public class 单词拆分II {


    public static void main(String[] args) {
        单词拆分II s =new 单词拆分II();

        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));

/*
        System.out.println(s.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
*/
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> hash = new HashMap<>();
        List<String> res = new ArrayList<>();
        return recall(s, 0, hash, wordDict);
    }

    public List<String> recall(String s, int start, Map<Integer, List<String>> hash,List<String> wordDict) {
        if(hash.containsKey(start)) return hash.get(start);
        List<String> list = new ArrayList<>();
        if(start== s.length()) {
            list.add("");
            return list;
        }
        for(String string : wordDict) {
            if(start+string.length()<= s.length() && string.equals(s.substring(start, start+string.length()))) {
                List<String> l = recall(s, start+string.length(), hash, wordDict);
                for(String str:l) {
                    if(start!=0) {
                        list.add(" " + string + str);
                    }else {
                        list.add(string + str);
                    }
                }
            }
        }
        hash.put(start, list);
        return list;
    }


}
