package sheen.leetcode.array;

/**
 * @Classname 数组的最大美丽值
 * @Date 2024/6/15 01:16
 * @Created by sheen
 * @Description TODO
 */
public class 数组的最大美丽值 {
    public int maximumBeauty(int[] nums, int k) {
        int[] diff = new int[400000];
        for(int i = 0; i <nums.length; i++) {
            int newNum = nums[i] + 100000;
            diff[newNum - k]++;
            diff[newNum + k + 1]--;
        }
        int res = 0;
        for(int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            res = Math.max(diff[i], res);
        }
        return res;
    }
}
