package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 构建回文串检测
 * @Date 2023/6/15 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 构建回文串检测 {
    public static void main(String[] args) {
        构建回文串检测 s = new 构建回文串检测();
        System.out.println(s.canMakePaliQueries("abcda", new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}}));
    }
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] count = new int[s.length()][26];
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            count[i][idx]++;
            if(i > 0) {
                for(int j = 0; j < 26; j++) {
                    count[i][j] += count[i - 1][j];
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            int[] diff = getDiff(count, left, right);
            int yu = 0;
            for(int j = 0; j < 26; j++) {
                diff[j] %= 2;
                yu += diff[j];
            }
            res.add(yu / 2 <= k);
        }
        return res;
    }
    public int[] getDiff(int[][] count, int left, int right) {
        if(left == 0) {
            return Arrays.copyOf(count[right], count[right].length);
        }

        int[] res = new int[26];
        for(int i = 0; i < 26; i++) {
            res[i] = count[right][i] - count[left - 1][i];
        }
        return res;
    }
}
