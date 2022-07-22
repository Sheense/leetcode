package sheen.leetcode.dp;

/**
 * @Classname 解码方法II
 * @Date 2021/9/27 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 解码方法II {
    public static void main(String[] args) {
        解码方法II s = new 解码方法II();
        System.out.println(s.numDecodings("1003"));
    }
    public int numDecodings(String s) {
        long mod = (long)Math.pow(10, 9) + 7;
        long[] dp = new long[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(i == 0) {
                if(s.charAt(0) == '*') {
                    dp[i] = 9;
                }else if(s.charAt(i) != '0'){
                    dp[i] = 1;
                }
            }else {
                long pre = i - 1 == 0 ? 1 : dp[i-2];
                if(s.charAt(i) == '0') {
                    if(s.charAt(i - 1) == '*') {
                        dp[i] = 2;
                    }else if(s.charAt(i-1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26){
                        dp[i] = 1;
                    }
                    dp[i] = dp[i] * pre;
                    dp[i] %= mod;
                }else if(s.charAt(i) == '*') {
                    dp[i] = (dp[i-1] * 9);
                    if(s.charAt(i - 1) > '0' && s.charAt(i-1) < '2') {
                        dp[i] += pre * 9;
                    }else if(s.charAt(i-1) == '2') {
                        dp[i] += pre * 6;
                    }else if(s.charAt(i-1) == '*') {
                        dp[i] += pre * 15;
                    }
                    dp[i] %= mod;
                }else {
                    dp[i] = dp[i-1];
                    if(s.charAt(i - 1) == '*') {
                        if(s.charAt(i) > '6') {
                            dp[i] += pre;
                        }else {
                            dp[i] += 2 * pre;
                        }
                    }else if(s.charAt(i - 1) > '0' && Integer.parseInt(s.substring(i-1, i+1)) <= 26) {
                        dp[i] += pre;
                    }
                    dp[i] %= mod;
                }
            }
        }
        return (int)dp[s.length() - 1];
    }
}
