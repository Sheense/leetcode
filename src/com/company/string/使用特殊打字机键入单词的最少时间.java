package com.company.string;

/**
 * @Classname 使用特殊打字机键入单词的最少时间
 * @Date 2021/8/21 10:33 下午
 * @Created by sheen
 * @Description TODO
 */
public class 使用特殊打字机键入单词的最少时间 {
    public static void main(String[] args) {
        使用特殊打字机键入单词的最少时间 s = new 使用特殊打字机键入单词的最少时间();
        System.out.println(s.minTimeToType("abc"));
    }
    public int minTimeToType(String word) {
        int start = 'a';
        int res = 0;
        for(int i = 0; i <word.length(); i++) {
            if(word.charAt(i) > start) {
                int a = word.charAt(i) - start;
                int b = 26 - word.charAt(i) + start;
                res += Math.min(a, b);
            }else {
                int a = start - word.charAt(i);
                int b = 26 - start + word.charAt(i);
                res += Math.min(a, b);
            }
            res++;
            start = word.charAt(i);
        }
        return res;
    }
}
