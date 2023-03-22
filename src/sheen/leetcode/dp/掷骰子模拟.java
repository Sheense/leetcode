package sheen.leetcode.dp;

/**
 * @Classname 掷骰子模拟
 * @Date 2023/2/10 12:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 掷骰子模拟 {
    public static void main(String[] args) {
        掷骰子模拟 s = new 掷骰子模拟();
        System.out.println(s.dieSimulator(2, new int[]{1,1,2,2,2,3}));
    }

    public int dieSimulator(int n, int[] rollMax) {
        for(int i = 1; i < rollMax.length; i++) {
            rollMax[i] += rollMax[i - 1];
        }
        int mod = (int)Math.pow(10, 9) + 7;

        int[][] dp = new int[n + 1][rollMax[rollMax.length - 1] + 1];
        for(int i = 1; i <= n; i++) {
            int pre = 0;
            for(int j = 0; j < rollMax.length; j++) {
                int maxSize = rollMax[j] - pre;
               for(int z = 1; z <= maxSize; z++) {
                   int size = z;
                   int index = z + pre;
                   int left = pre;
                   int right = rollMax[j];
                   int count = 0;
                   if(size < i) {
                       for(int q = 1; q < dp[i - size].length; q++) {
                           if(q > left && q <= right) {
                               continue;
                           }
                           count += dp[i - size][q];
                           count %= mod;
                       }
                       dp[i][index] = count;
                   }else if(size == i) {
                       dp[i][index] = 1;
                   }
               }
               pre = rollMax[j];
            }
        }

        int res = 0;
        for(int i = 1; i <= rollMax[rollMax.length - 1]; i++) {
            res += dp[dp.length - 1][i];
            res %= mod;
        }

        return res;
    }
}
