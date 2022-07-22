package sheen.leetcode.bitOperation;

import java.util.Arrays;

/**
 * @Classname 最大单词长度乘积
 * @Date 2021/11/17 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大单词长度乘积 {
    public int maxProduct(String[] words) {
        int[] arr = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            int value = 0;
            for(int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                value |= (1 << index);
            }
            arr[i] = value;
        }

        int max = 0;
        for(int i = words.length - 1; i >= 0; i--){
            for(int j = i - 1; j >= 0; j--) {
                if((arr[i] | arr[j]) == arr[i] + arr[j]) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
