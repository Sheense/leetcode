package sheen.leetcode.array;

/**
 * @Classname 统计移除递增子数组的数目I
 * @Date 2024/7/10 01:22
 * @Created by sheen
 * @Description TODO
 */
public class 统计移除递增子数组的数目I {
    public static void main(String[] args) {
        统计移除递增子数组的数目I s = new 统计移除递增子数组的数目I();
        System.out.println(s.incremovableSubarrayCount(new int[]{3,5,3,5}));
    }
    public int incremovableSubarrayCount(int[] nums) {
        int res = 0;
        for(int len = 1; len <= nums.length; len++) {
            for(int i = 0; i + len - 1 < nums.length; i++) {
                if(check(nums, i, i + len - 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean check(int[] nums, int start, int end) {
        int i = 0;
        int pre = -1;
        while (i < nums.length) {
            if(!(i >= start && i <= end)) {
                if(pre != -1 && nums[pre] >= nums[i]) {
                    return false;
                }
                pre = i;
            }
            i++;
        }

        return true;
    }
}
