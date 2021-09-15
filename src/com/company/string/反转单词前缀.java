package com.company.string;

/**
 * @Classname 反转单词前缀
 * @Date 2021/9/12 10:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class 反转单词前缀 {
    public String reversePrefix(String word, char ch) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch) {
                String str = word.substring(0, i+1);
                StringBuilder sb = new StringBuilder(str);
                sb.reverse();
                return sb.toString() + word.substring(i+1);
            }
        }
        return word;
    }
}
