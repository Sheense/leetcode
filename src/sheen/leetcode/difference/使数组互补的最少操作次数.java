package sheen.leetcode.difference;

//差分+扫描
public class 使数组互补的最少操作次数 {

    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2*limit + 2];
        for(int i=0;i<nums.length/2;i++) {
            int lo = 1 + Math.min(nums[i], nums[nums.length-i-1]);
            int sum = nums[i] + nums[nums.length-i-1];
            int hi = Math.max(nums[i], nums[nums.length-i-1]) + limit;
            diff[lo]--;
            diff[sum]--;
            diff[sum+1]++;
            diff[hi+1]++;
        }
        int now = nums.length;
        int ans = nums.length;
        for(int i=0;i<diff.length;i++) {
            now += diff[i];
            ans = Math.min(ans, now);
        }
        return ans;
    }
}
