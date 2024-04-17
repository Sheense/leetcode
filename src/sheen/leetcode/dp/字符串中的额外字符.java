package sheen.leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 字符串中的额外字符
 * @Date 2024/1/9 00:48
 * @Created by sheen
 * @Description TODO
 */
public class 字符串中的额外字符 {

    public static void main(String[] args) {
        字符串中的额外字符 s = new 字符串中的额外字符();
        System.out.println(s.minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(String dict : dictionary) {
            set.add(dict);
        }

        int[] dp = new int[s.length() + 1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if(set.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[s.length()];
    }

}
