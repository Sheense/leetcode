package sheen.leetcode.dp;

import java.util.*;

public class 数位成本和为目标值的最大数字 {
    public String largestNumber(int[] cost, int target) {
        int[][] dp = new int[target+1][9];
        for (int i = 1; i<= target; i++) {
            int count = 0;
            for (int j = 0; j < cost.length; j++){
                int[] item = new int[9];
                int itemCount = 0;
                if (i - cost[j] >= 0) {
                    if (!isZero(dp[i - cost[j]]) || i - cost[j] == 0) {
                        for (int z = 0; z < item.length; z++) {
                            item[z] = dp[i-cost[j]][z];
                            itemCount += dp[i-cost[j]][z];
                        }
                        item[j] ++;
                        itemCount++;
                    }
                }
                if (itemCount > count) {
                    dp[i] = item;
                    count = itemCount;
                }else if(itemCount == count) {
                    dp[i] = returnBig(dp[i], item);
                }
            }
        }
        String res = "";
        for(int i = 8; i >= 0; i--) {
            if(dp[target][i] != 0) {
                while (dp[target][i]-- != 0) {
                    res += (i+1);
                }
            }
        }
        return res == ""?"0" : res;
    }
    public boolean isZero(int [] a) {
        int count = 0;
        for(int i =0; i<a.length;i++) count += a[i];
        return count == 0;
    }
    public int[] returnBig(int[] a, int[] b) {

        for(int i = 8; i >= 0; i--) {
            if (a[i] > b[i]) {
                return a;
            }else if(a[i] < b[i]) {
                return b;
            }
        }
        return a;
    }
}
