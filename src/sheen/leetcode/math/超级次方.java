package sheen.leetcode.math;

import java.util.Arrays;

public class 超级次方 {

    public static void main(String[] args) {
        超级次方 s = new 超级次方();
        System.out.println(s.superPow(2147483647, new int[]{2,0,0}));
    }

    public int superPow(int a, int[] b) {
        int mod = 1337;
        a %= mod;
        int[] dp = new int[b.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < dp.length; i++) {
            if(i == 0) {
                dp[i] = a;
            }else {
                for(int j = 0; j < 10; j++) {
                    dp[i] *= dp[i-1];
                    dp[i] %= mod;
                }
            }
        }
        int index = 0;
        int res = 1;
        for(int i = b.length - 1; i >= 0; i--) {
            for(int j = 0; j < b[i]; j++) {
                res *= dp[index];
                res %= mod;
            }
            index++;
        }
        return res;
    }

    /*public int superPow(int a, int[] b) {
        if(b.length==0) return 0;
        int res = 1;
        a %= 1337;
        int pre = a;
        for(int i=b.length-1;i>=0;i--){
            for(int j=1;j<=b[i];j++) {
                res *= pre;
                res %= 1337;
            }
            int item = 1;
            for(int j=1;j<=10;j++) {
                item *= pre;
                item %= 1337;
            }
            pre = item;
        }
        return res;
    }*/

}
