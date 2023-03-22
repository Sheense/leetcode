package sheen.leetcode.math;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname 子序列宽度之和
 * @Date 2022/11/18 12:40 上午
 * @Created by sheen
 * @Description TODO
 */
public class 子序列宽度之和 {
    public static void main(String[] args) {
        子序列宽度之和 s = new 子序列宽度之和();
        System.out.println(s.sumSubseqWidths(new int[]{2,1,3}));
    }

    private static int Mod = (int)Math.pow(10, 9) + 7;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long x = nums[0];
        long y = 2;
        long res = 0;
        for(int i = 1; i < nums.length; i++) {
            res = (res + nums[i] * (y - 1) - x) % Mod;
            y *= 2 % Mod;
            x = (2 * x+ nums[i]) % Mod;
        }



        return (int)((res + Mod) % Mod);
    }

}
