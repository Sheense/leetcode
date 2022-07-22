package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 度为3的不同回文子序列
 * @Date 2021/7/15 1:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 度为3的不同回文子序列 {
    public int countPalindromicSubsequence(String s) {
        int[][] a = new int[26][2];
        for(int i = 0; i < 26; i++) {
            Arrays.fill(a[i], -1);
        }
        int[][] b = new int[s.length()][26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(a[index][0] == -1) {
                a[index][0] = i;
            }else {
                a[index][1] = i;
            }
            int[] arr = new int[26];
            arr[index] ++;
            if(i != 0) {
               for(int j = 0; j < b[i-1].length; j++) {
                   arr[j] += b[i-1][j];
               }
            }
            b[i] = arr;
        }
        int res = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i][0] != -1 && a[i][1] != -1 && a[i][1] - a[i][0] > 1) {
                int left = a[i][0];
                int right = a[i][1] - 1;
                for(int j = 0; j < 26; j++) {
                    if(b[right][j] - b[left][j] > 0) {
                        res ++;
                    }
                }
            }
        }
        return res;
    }
}
