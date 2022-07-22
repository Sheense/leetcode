package sheen.leetcode.array;

public class 构成特定和需要添加的最少元素 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        long v = Math.abs(sum - goal);
        if(v == 0) return 0;
        return (int)(v/limit + (v % limit > 0 ? 1 : 0));
    }
}
