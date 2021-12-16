package com.company.array;

import com.company.util.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 句子中的有效单词数
 * @Date 2021/10/24 2:59 下午
 * @Created by sheen
 * @Description TODO
 */
public class 句子中的有效单词数 {
    public static void main(String[] args) {
        句子中的有效单词数 s = new 句子中的有效单词数();
        System.out.println(s.countValidWords("cat and  dog"));
    }
    public int countValidWords(String sentence) {
        String[] arr = sentence.split(" ");
        Set<Character> set = new HashSet<>(Arrays.asList('!', '.', ','));
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].trim().equals("")) {
                int l = 0;
                boolean flag = true;
                for(int j = 0; j < arr[i].length(); j++) {
                    if(arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9') {
                        flag = false;
                        break;
                    }
                    if(arr[i].charAt(j) == '-') {
                        if(l > 0) {
                            flag = false;
                            break;
                        }
                        l++;
                        if(j - 1 < 0 || j + 1 == arr[i].length() || !isZimu(arr[i].charAt(j-1) ) || !isZimu(arr[i].charAt(j+1))) {
                            flag = false;
                            break;
                        }
                    }

                    if(set.contains(arr[i].charAt(j)) ) {
                        if(j < arr[i].length() - 1) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isZimu(char c) {
        return c >= 'a' && c <= 'z';
    }
}
