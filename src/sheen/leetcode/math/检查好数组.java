package sheen.leetcode.math;

/**
 * @Classname 检查好数组
 * @Date 2023/2/15 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检查好数组 {
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
        }

        return gcd == 1;
    }

    public int gcd(int a, int b) {
        if(a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
