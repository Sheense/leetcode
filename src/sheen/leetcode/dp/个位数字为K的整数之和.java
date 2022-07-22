package sheen.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 个位数字为K的整数之和
 * @Date 2022/6/19 11:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 个位数字为K的整数之和 {
    public static void main(String[] args) {
        个位数字为K的整数之和 s = new 个位数字为K的整数之和();
        System.out.println(s.minimumNumbers(37,2));
    }
    public int minimumNumbers(int num, int k) {
        if(num == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= num; i ++) {
            if(i % 10 == k) {
                list.add(i);
            }
        }
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        for(int i = 1; i <= num; i++) {
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) <= i) {
                    if(list.get(j) == i) {
                        dp[i] = 1;
                    }else if(dp[i - list.get(j)] != -1 && (dp[i] == -1 || dp[i] > dp[i - list.get(j)] + 1)) {
                        dp[i] = dp[i - list.get(j)] + 1;
                    }
                }
            }
        }

        return dp[num] == 0 ? -1 : dp[num];
    }
}
