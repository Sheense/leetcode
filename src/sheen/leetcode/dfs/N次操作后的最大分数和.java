package sheen.leetcode.dfs;

import java.util.Arrays;

/**
 * @Classname N次操作后的最大分数和
 * @Date 2022/12/22 1:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class N次操作后的最大分数和 {
    public static void main(String[] args) {
        N次操作后的最大分数和 s = new N次操作后的最大分数和();
        System.out.println(s.maxScore(new int[]{1,2,3,4,5,6, 7,8,9,10,11,12,13,14}));
    }
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[][] gcds = new int[n][n];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int gcd = gcd(nums[j], nums[i]);
                gcds[i][j] = gcd;
                gcds[j][i] = gcd;
            }
        }
        int[] state = new int[1 << n];
        Arrays.fill(state, - 1);
        dfs(state, (1 << n) - 1, 1, gcds);
        return state[(1 << n) - 1];
    }

    public int dfs( int[] state, int currentState, int count, int[][] gcds) {
        if(count == gcds.length / 2 + 1) {
            return 0;
        }

        if(state[currentState] != -1) {
            return state[currentState];
        }

        int max = 0;
        for(int i = 0; i < gcds.length; i++) {
            if((currentState & (1 << i)) == 0) {
                continue;
            }

            for(int j = i + 1; j < gcds[i].length; j++) {
                if((currentState & (1 << j)) == 0) {
                    continue;
                }

                max = Math.max(max, gcds[i][j] * count + dfs(state, currentState ^ (1 << i) ^ (1 << j), count + 1, gcds));
            }
        }
        state[currentState] = max;
        return max;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
