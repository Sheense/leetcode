package com.company.dp;

import com.company.util.ArratyUtils;

import java.util.*;

public class 单词拆分II {
    public static void main(String[] args) {
        单词拆分II s = new 单词拆分II();
        System.out.print(s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        for(int i=0;i<s.length();i++) {
            if(set.contains(s.substring(0,i+1))) dp[i] = true;
        }
        /*for(int i=0;i<s.length();i++) {
            if(dp[i]==true || i==0) {
                List<String> list = new ArrayList<>();
                int start = 0;
                int end = 0;
                if(dp[i]==true&&i!=0)
                {
                    list.add(s.substring(0, i+1));
                    start = i + 1;
                    end = i + 1;
                }
                Queue<List<String>> queue = new LinkedList<>();
                queue.offer(list);
                while(end<s.length()) {
                    String item = s.substring(start, end+1);
                    if(set.contains(item)) {
                        list.add(item);
                        if (end == s.length() - 1) {
                            res.add(stringBuilder.toString());
                        } else {
                            stringBuilder.append(" ");
                        }
                        start = end + 1;
                    }
                    end ++;
                }
            }
        }*/
        return res;
    }

}
