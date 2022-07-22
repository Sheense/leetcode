package sheen.leetcode.array;

public class 到目标元素的最小距离 {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }
}
