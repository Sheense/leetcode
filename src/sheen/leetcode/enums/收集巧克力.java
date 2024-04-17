package sheen.leetcode.enums;

/**
 * @Classname 收集巧克力
 * @Date 2023/12/28 00:21
 * @Created by sheen
 * @Description TODO
 */
public class 收集巧克力 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] f = new int[n];
        long res = Long.MAX_VALUE;
        for(int k = 0; k < n; k++) {
            long all = 0;
            for(int i = 0; i < n; i++) {
                f[i] = k == 0 ? nums[i] : Math.min(f[i], nums[(i + k) % n]);
                all += f[i];
            }
            res = Math.min(res, all + (long)x * k);
        }
        return res;
    }
}
