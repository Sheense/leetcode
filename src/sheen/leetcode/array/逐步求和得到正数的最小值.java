package sheen.leetcode.array;

/**
 * @Classname 逐步求和得到正数的最小值
 * @Date 2022/8/9 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 逐步求和得到正数的最小值 {
    public int minStartValue(int[] nums) {
        int res = 1;
        int all = 0;
        for(int i = 0; i < nums.length; i++) {
            all += nums[i];
            if(all <= 0) {
                res = Math.max(res, Math.abs(all) + 1);
            }
        }
        return res;
    }
}
