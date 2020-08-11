package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class 找出最长的超赞子字符串 {

    public static void main(String[] args) {
        找出最长的超赞子字符串 s = new 找出最长的超赞子字符串();
        System.out.println(s.longestAwesome("9498331"));
    }
    public int longestAwesome(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Integer> oddToIndex = new HashMap<>();
        int oddNum = 0;
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))){
                int time = map.get(s.charAt(i))+1;
                map.put(s.charAt(i), time);
                if(time%2==1) {
                    oddNum++;
                }else {
                   oddNum--;
                }
            }else {
                map.put(s.charAt(i),1);
                oddNum++;
            }
            if(!oddToIndex.containsKey(oddNum)) {
                oddToIndex.put(oddNum, i);
            }
            if(oddNum==0||oddNum==1) {
                max = i+1;
            }else {
                if(oddToIndex.containsKey(oddNum)) {
                    max = Math.max(i - oddToIndex.get(oddNum) + 1,max);
                }
                if(oddToIndex.containsKey(oddNum-1)){
                    max = Math.max(i - oddToIndex.get(oddNum-1) ,max);
                }
            }
         }
        return max;
    }
}
