package sheen.leetcode.dp;

/**
 * @Classname 好子集的数目
 * @Date 2022/2/22 1:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 好子集的数目 {
    public static void main(String[] args) {
        好子集的数目 s = new 好子集的数目();
        System.out.println(s.numberOfGoodSubsets(new int[]{4,2,3,15}));
    }
    public int numberOfGoodSubsets(int[] nums) {
        int MAX = 30;
        int MOD = (int)Math.pow(10 , 9) + 7;
        int[] PARAM = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] count = new int[MAX + 1];
        for(int i : nums) {
            count[i] ++;
        }

        int[] dp = new int[1<<(PARAM.length + 1)];
        dp[0] = 1;
        for(int i = 1; i <= count[1]; i++) {
            dp[0] = dp[0] * 2 % MOD;
        }

        for(int i = 2; i <= MAX; i++) {
            if(count[i] == 0) {
                continue;
            }

            int v = i;
            int set = 0;
            boolean flag = true;
            for(int j = 0; j < PARAM.length; j++) {
                if(v % (PARAM[j] * PARAM[j]) == 0) {
                    flag = false;
                    break;
                }

                if(v % PARAM[j] == 0) {
                    set |= (1 << j);
                    v /= PARAM[j];
                }
                if(v == 1) {
                    break;
                }
            }

            if(!flag) {
                continue;
            }

            for(int mask = dp.length - 1; mask >= 0; mask--) {
                if((mask | set) == mask) {
                    dp[mask] = (int)((dp[mask] + ((long)dp[mask^set]) * count[i]) % MOD);
                }
            }
        }

        int res = 0;
        for(int i = 1; i < dp.length; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }
}
