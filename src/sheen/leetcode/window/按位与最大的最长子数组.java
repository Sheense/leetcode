package sheen.leetcode.window;

/**
 * @Classname 按位与最大的最长子数组
 * @Date 2022/9/25 11:28 上午
 * @Created by sheen
 * @Description TODO
 */
public class 按位与最大的最长子数组 {
    public static void main(String[] args) {
        按位与最大的最长子数组 s = new 按位与最大的最长子数组();
        System.out.println(s.longestSubarray(new int[]{96317,96317,96317,96317,96317,96317,96317,96317,96317,279979}));
    }
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int len = 0;
        int res = 1;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] == max) len++;
            else {
                res = Math.max(len, res);
                len = 0;
            }
        }

        res = Math.max(len, res);

        return res;
    }
}
