package sheen.leetcode.脑筋急转弯;

import java.util.Arrays;

/**
 * @Classname 移动机器人
 * @Date 2023/10/10 00:45
 * @Created by sheen
 * @Description TODO
 */
public class 移动机器人 {
    public int sumDistance(int[] nums, String s, int d) {
        long [] arr = new long[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(s.charAt(i) == 'R') {
                arr[i] = (long)nums[i] + d;
            }else {
                arr[i] = (long)nums[i] - d;
            }
        }

        long res = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        Arrays.sort(arr);
        for(int i = 1; i < nums.length; i++) {
            long a = (arr[i] - arr[i - 1]) * i;
            a %= mod;
            a *= (nums.length - i);
            a %= mod;
            res += a;
            res %= mod;
        }
        return (int)res;
    }
}
