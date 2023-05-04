package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 最短公共超序列
 * @Date 2023/3/28 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最短公共超序列 {
    public static void main(String[] args) {
        最短公共超序列 s = new 最短公共超序列();
        System.out.println(s.shortestCommonSupersequence("abccssfd", "cabfg"));
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];

        for(int i = 0; i < str1.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                if(i == 0) {
                    if(str1.charAt(i) == str2.charAt(j)) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = j == 0 ? 0 : dp[i][j - 1];
                    }
                    continue;
                }

                if(j == 0) {
                    if(str1.charAt(i) == str2.charAt(j)) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }

                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i -1][j], dp[i][j - 1]);
                }
            }
        }
        ArrayUtils.print2(dp);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int max = dp[i][j];
        search(a, b, i, j, dp, max);
        i = 0;
        j = 0;
        String res = "";
        while (i < str1.length() || j < str2.length()) {
            if(i < str1.length() && j < str2.length()) {
                if(a.contains(i) && b.contains(j)) {
                    res += str1.charAt(i);
                    i++;
                    j++;
                }else if(a.contains(i)) {
                    res += str2.charAt(j);
                    j++;
                }else if(b.contains(j)) {
                    res += str1.charAt(i);
                    i++;
                }else {
                    res += str1.charAt(i++);
                    res += str2.charAt(j++);
                }
            }else {
                if(i < str1.length()) {
                    res += str1.substring(i);
                    break;
                }

                res += str2.substring(j);
                break;
            }
        }
        return res;
    }

    public void search(Set<Integer> a, Set<Integer> b, int i, int j, int[][] dp, int max) {
        while (i - 1 >= 0 && dp[i - 1][j] == max) {
            i--;
        }

        while (j - 1 >= 0 && dp[i][j - 1] == max) {
            j--;
        }
        a.add(i);
        b.add(j);
        int nextMax = max - 1;
        if(nextMax == 0) {
            return;
        }
        search(a, b, i - 1, j - 1, dp, nextMax);
    }
 }
