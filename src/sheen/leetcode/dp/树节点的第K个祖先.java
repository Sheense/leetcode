package sheen.leetcode.dp;

import java.util.*;

/**
 * @Classname 树节点的第K个祖先
 * @Date 2023/6/12 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 树节点的第K个祖先 {
    static class TreeAncestor {
        private int[][] dp;
        public TreeAncestor(int n, int[] parent) {
            dp = new int[n][16];
            for(int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            for(int i = 0; i < 16; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0) {
                        dp[j][i] = parent[j];
                    }else {
                        if(dp[parent[j]][i - 1] != -1) {
                            dp[j][i] = dp[dp[parent[j]][i - 1]][i - 1];
                        }
                    }
                }
            }
        }



        public int getKthAncestor(int node, int k) {
            for(int i = 0; i < 16; i++) {
                if((k & (1 << i)) == 1) {
                    node = dp[node][i];
                    if(node == -1) {
                        return -1;
                    }
                }
            }
            return node;
        }
    }
}
