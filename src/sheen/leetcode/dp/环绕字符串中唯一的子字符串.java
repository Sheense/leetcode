package sheen.leetcode.dp;

/**
 * @Classname 环绕字符串中唯一的子字符串
 * @Date 2022/5/25 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 环绕字符串中唯一的子字符串 {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int count = 0;
        for(int i = 0; i < p.length(); i++) {
            if(i == 0) {
                dp[p.charAt(i) - 'a']++;
                count = 1;
            }else {
                if(p.charAt(i) == 'a') {
                    if(p.charAt(i - 1) == 'z') {
                        count++;
                        dp[0] = Math.max(dp[0], count);
                    }else {
                        dp[0] = Math.max(dp[0], 1);
                        count = 1;
                    }
                }else {
                    if(p.charAt(i - 1) + 1 == p.charAt(i)) {
                        count++;
                        dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], count);
                    }else {
                        dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], 1);
                        count = 1;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < dp.length; i++) {
            res += dp[i];
        }

        return res;
    }

}
