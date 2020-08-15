package com.company.dp;

public class 移除盒子 {

    public static void main(String[] args) {
        移除盒子 s = new 移除盒子();
        System.out.println(s.removeBoxes(new int[]{1,3,2,2,2,3,4,3,1}));
    }
    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        return calculate(0, boxes.length-1,dp,0,boxes);
    }

    public int calculate(int l, int r, int[][][] dp, int k , int[] boxes) {
        if (l>r) return 0;
        if(dp[l][r][k]!=0) return dp[l][r][k];
        while(r>l&&boxes[r-1]==boxes[r]) {
            r--;
            k++;
        }
        dp[l][r][k] = calculate(l, r-1, dp, 0, boxes) + (int)Math.pow(k+1, 2);
        for(int i=r-1;i>=l;i--) {
            if(boxes[i]==boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], calculate(l, i, dp, k+1, boxes) + calculate(i+1,r-1,dp, 0, boxes));
            }
        }
        return dp[l][r][k];
    }
}
