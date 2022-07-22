package sheen.leetcode.math;

public class 主要元素 {
    public int majorityElement(int[] nums) {
        int res = -1;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(res == -1) {
               res = nums[i];
               count++;
            }else if(res == nums[i]) {
                count++;
            }else {
                count--;
                if(count == 0) res = -1;
            }
        }
        if (count > 0) {
            int n = 0;
            for(int i=0;i<nums.length;i++) {
                if(nums[i] == res) n++;
            }
            if(n>nums.length/2) return res;
        }
        return -1;
    }
}
