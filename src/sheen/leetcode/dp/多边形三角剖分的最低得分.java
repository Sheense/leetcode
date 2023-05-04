package sheen.leetcode.dp;

/**
 * @Classname 多边形三角剖分的最低得分
 * @Date 2023/4/2 10:30 上午
 * @Created by sheen
 * @Description TODO
 */
public class 多边形三角剖分的最低得分 {
    public static void main(String[] args) {
        多边形三角剖分的最低得分 s = new 多边形三角剖分的最低得分();
        System.out.println(s.minScoreTriangulation(new int[]{1,3,1,4,1,5}));
    }
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int size = 3; size <= values.length; size++) {
            for(int start = 0; start <= values.length - size; start++) {
                if(size == 3) {
                    dp[start][start + size - 1] = values[start] * values[start + 1] * values[start + 2];
                }else {
                    dp[start][start + size - 1] = Integer.MAX_VALUE;
                    int end = start + size - 1;
                    for(int z = start + 1; z <= end - 1; z++) {
                        dp[start][start + size - 1] = Math.min(dp[start][start + size - 1],
                                dp[start][z] + dp[z][end] + values[start] * values[end] * values[z]);
                    }
                }
            }
        }
        return dp[0][values.length - 1];
    }
}
