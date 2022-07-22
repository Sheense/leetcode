package sheen.leetcode.array;

public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int j = nums[i];
            nums[i] = -1;
            while (j != i) {
                int q = nums[j];
                nums[j] = j;
                if(q == j) return j;
                j = q;
            }
            nums[i] = j;
        }
        return -1;
    }
}
