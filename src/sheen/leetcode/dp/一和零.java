package sheen.leetcode.dp;

public class 一和零 {
    public static void main(String[] args) {
        一和零 s = new 一和零();
        System.out.println(s.findMaxForm(new String[]{"00", "0000"}, 1, 10));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int [][] arr = new int[strs.length][2];
        for(int i=0;i<strs.length;i++) {
            for(int j=0;j<strs[i].length();j++){
                arr[i][strs[i].charAt(j) - '0']++;
            }
        }
        int[][][] dp = new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++) {
            if (i==0) {
                if(arr[i][0]<=m&&arr[i][1]<=n){
                    for(int j=arr[i][0];j<=m;j++) {
                        for(int z=arr[i][1];z<=n;z++) {
                            dp[i][j][z] = 1;
                        }
                    }
                }
               continue;
            }
            for(int j=0;j<=m;j++) {
                for(int z=0;z<=n;z++) {
                    if(j-arr[i][0] >= 0 && z - arr[i][1] >= 0) {
                        dp[i][j][z] = Math.max(dp[i-1][j][z], dp[i-1][j-arr[i][0]][z-arr[i][1]]+1);
                    }else {
                        dp[i][j][z] =dp[i-1][j][z];
                    }
                }
            }
        }
        return dp[strs.length-1][m][n];
    }
}
