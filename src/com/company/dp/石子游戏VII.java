package com.company.dp;


/*动态规划思想
1.一个数组dp保存从下标j到j+i-1的差值，一个数组cache保存从j到j+i-1的元素之和；
2.长度i从2到n递增，当前dp[j][j+i-1]的值，是max(取掉最左值的剩余元素和减去dp[j+1][j+i-1],去掉最右值的剩余元素和减去dp[j][j+i-2])；
3.对于2中的max里面的解释，假如当前玩家是爱丽丝，当前数组dp取掉两边任一边的值后，剩下元素组成的数组以鲍勃为首开始取值，这时鲍勃得分必高于爱丽丝，对于爱丽丝得分贡献是负，因此应取爱丽丝当前得分减掉之后鲍勃与爱丽丝得分差值的最大值。*/


public class 石子游戏VII {

    public static void main(String[] args) {
        石子游戏VII s = new 石子游戏VII();
        System.out.println(s.stoneGameVII(new int[]{5,3,1,4,2}));
    }

    public int stoneGameVII(int[] stones) {
        int [] arr = new int[stones.length];
        for(int i=0;i<stones.length;i++) {
            arr[i] = i==0?stones[i]:arr[i-1]+stones[i];
        }
        int [] [] dp = new int[stones.length][stones.length];
        for(int i=2; i<=stones.length;i++) {
            for(int j=0;j+i-1<stones.length;j++) {
                if(i==2) {
                    dp[j][j+i-1] = Math.max(stones[j], stones[j+i-1]);
                }else {
                    int left = arr[j+i-1] - arr[j];
                    int right = j == 0?arr[j+i-2]:(arr[j+i-2] - arr[j-1]);
                    dp[j][j+i-1] = Math.max(left-dp[j+1][j+i-1], right - dp[j][j+i-2]);
                }
            }
        }
        return dp[0][stones.length-1];
    }
}
