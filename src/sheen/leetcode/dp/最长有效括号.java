package sheen.leetcode.dp;

import java.util.Scanner;

public class 最长有效括号 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        char[] chars = input.toCharArray();
        int dp[] = new int[chars.length];
        for(int i=1; i<chars.length; i++) {
            if(chars[i] == '(') dp[i] = 0;
            if(chars[i] == ')') {
                if (chars[i-1] == '(') {
                    dp[i] = 2 + (i-2>=0?dp[i-2]:0);
                }
                else if (chars[i-1] == ')') {
                    if(i-1-dp[i-1]>=0&&chars[i-1-dp[i-1]] =='(') {
                        dp[i] = dp[i-1] + 2 +(i-2-dp[i-1]>=0?dp[i-2-dp[i-1]]:0);
                    } else {
                        int count = dp[i-1];
                        int index = i-1-count;
                        while(index>=0 &&dp[index]!=0) {
                            if(chars[index]=='(') {
                                count = count + 2;
                                count += (index-1>=0?dp[index-1]:0);
                                break;
                            } else {
                                count = count + dp[index];
                                index = index - dp[index];
                            }
                        }
                        if(index<0 || dp[index] == 0) {
                            dp[i] = 0;
                        } else {
                            dp[i] = count;
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<chars.length;i++) {
            if(max < dp[i]) max = dp[i];
            System.out.println(dp[i]);
        }
        System.out.println(max);
    }
}
