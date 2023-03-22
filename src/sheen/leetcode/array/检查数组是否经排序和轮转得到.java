package sheen.leetcode.array;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Classname 检查数组是否经排序和轮转得到
 * @Date 2022/11/27 12:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检查数组是否经排序和轮转得到 {
    public boolean check(int[] nums) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int change = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[(i + 1) % nums.length]) {
                change++;
                if(change > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
