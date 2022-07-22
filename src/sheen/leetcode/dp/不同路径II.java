package sheen.leetcode.dp;

public class 不同路径II {

    public static void main(String[] args) {
        int [][] map={
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        不同路径II s = new 不同路径II();
        System.out.println(s.uniquePathsWithObstacles(map));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[i].length;j++) {
                if(obstacleGrid[i][j]==1||(i==0&&j-1>=0&&dp[i][j-1]==0)||(j==0&&i-1>=0&&dp[i-1][j]==0)) continue;
                if(i==0||j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
