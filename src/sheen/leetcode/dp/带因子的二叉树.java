package sheen.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 带因子的二叉树
 * @Date 2023/8/29 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 带因子的二叉树 {
    public static void main(String[] args) {
        带因子的二叉树 s = new 带因子的二叉树();
        System.out.println(s.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
    }
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = (int) Math.pow(10 ,9) + 7;
        long res = 0;
        Arrays.sort(arr);
        long dp[] = new long[arr.length];
        for(int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for(int left = 0, right = i - 1; left <= right; left++) {
                while (left <= right && (long)arr[left] * arr[right] > arr[i]) {
                    right--;
                }
                if(left <= right && (long )arr[left] * arr[right] == arr[i]) {
                    if(left == right) {
                        long v = dp[left] * dp[right] % mod;
                        dp[i] += v;
                        dp[i] %= mod;
                    }else {
                        long v = dp[left] * dp[right] * 2 % mod;
                        dp[i] += v;
                        dp[i] %= mod;
                    }
                }
            }
            res += dp[i];
            res %= mod;
        }
        return (int) res;
    }
}
