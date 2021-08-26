package com.company.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 反转字符串中的元音字母
 * @Date 2021/8/19 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 反转字符串中的元音字母 {
    public static void main(String[] args) {
        反转字符串中的元音字母 s = new 反转字符串中的元音字母();
        System.out.println(s.reverseVowels("hello"));
    }
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','o','e','i','u','A','O','E','I','U'));
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left <= right) {
            while (left <= right && !set.contains(arr[left])) {
                left++;
            }
            while (left <= right && !set.contains(arr[right])) {
                right--;
            }
            if(left >= right) break;
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
}
