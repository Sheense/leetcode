package sheen.leetcode.dfs;

//记忆化搜索
public class 布尔运算 {
    public static void main(String[] args) {
        布尔运算 s= new 布尔运算();
        System.out.println(s.countEval("1^0|0|1", 0));
    }
    int[][][] dp;
    public int countEval(String s, int result) {
        dp = new int[s.length()][s.length()][2];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[i].length;j++) {
                for(int z=0;z<dp[i][j].length;z++) dp[i][j][z] = -1;
            }
        }
        return recall(s, 0, s.length()-1, result);
    }

    public int recall(String s, int start, int end, int result) {
        if(start == end) {
            dp[start][end][result] = s.charAt(start) - '0' == result ? 1 : 0;
            return dp[start][end][result];
        }
        if(dp[start][end][result]!=-1) return dp[start][end][result];

        dp[start][end][result] = 0;
        for(int i=start;i<end;i+=2) {
            for(int j = 0; j<=1; j++) {
                for(int z=0;z<=1;z++) {
                    if(computer(j,z, s.charAt(i+1))==result) {
                        dp[start][end][result]+= recall(s, start, i, j) * recall(s, i+2, end, z);
                    }
                }
            }
        }
        return dp[start][end][result];
    }

    public int computer(int a, int b, char c) {
        switch (c) {
            case '^': {
                b = a ^ b;
                break;
            }
            case '|': {
                b = a | b;
                break;
            }
            case '&': {
                b = a & b;
                break;
            }
        }
        return b;
    }
}
