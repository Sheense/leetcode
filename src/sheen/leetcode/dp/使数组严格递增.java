package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @Classname 使数组严格递增
 * @Date 2023/4/20 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 使数组严格递增 {
    public static void main(String[] args) {
        使数组严格递增 s = new 使数组严格递增();
        System.out.println(s.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,6,3,3}));
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int first = arr1[0];
        for(int i = 0; i < arr2.length; i++) {
            treeSet.add(arr2[i]);
            first = Math.min(first, arr2[i]);
        }
        int m = Math.min(treeSet.size(), arr1.length);
        int[][] dp = new int[arr1.length][m + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = arr1[0];
        dp[0][1] = first != arr1[0] ? first : Integer.MAX_VALUE;
        for(int i = 1; i < arr1.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if(j > i + 1) {
                    break;
                }
                if(dp[i - 1][j] < arr1[i]) {
                    dp[i][j] = Math.min(arr1[i], dp[i][j]);
                }

                if(j - 1 >= 0) {
                   Integer v = treeSet.higher(dp[i - 1][j - 1]);
                   if(v != null && v != arr1[i]) {
                       dp[i][j] = Math.min(v, dp[i][j]);
                   }
                }

            }
        }

        for(int i = 0; i < m + 1; i++) {
            if(dp[arr1.length - 1][i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return -1;


    }
}
