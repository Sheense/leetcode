package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 填充书架
 * @Date 2023/4/23 4:29 下午
 * @Created by sheen
 * @Description TODO
 */
public class 填充书架 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length];
        Arrays.fill(books, 1000000);
        for(int i = 0; i < books.length; i++) {
            int cur = 0;
            int maxHeight = books[i][1];
            for(int j = i; j >= 0; j--){
                if(cur > shelfWidth) {
                    break;
                }
                cur += books[j][0];
                maxHeight = Math.max(maxHeight, books[j][1]);
                if(j == 0) {
                    dp[i] = Math.min(dp[i], maxHeight);
                }else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
                }
            }
        }
        return dp[books.length - 1];
    }
}
