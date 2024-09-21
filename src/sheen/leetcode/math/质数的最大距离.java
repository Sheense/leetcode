package sheen.leetcode.math;

/**
 * @Classname 质数的最大距离
 * @Date 2024/7/2 00:05
 * @Created by sheen
 * @Description TODO
 */
public class 质数的最大距离 {
    public int maximumPrimeDifference(int[] nums) {
        int[] arr = new int[]{-1, -1};
        for(int i = 0; i < nums.length; i++) {
            if(check(nums[i])) {
                if(arr[0] == -1) {
                    arr[0] = i;
                    arr[1] = i;
                }else {
                    arr[1] = i;
                }
            }
        }

        return arr[1] - arr[0];
    }

    public boolean check(int num) {
        if(num == 1) {
            return false;
        }
        int count = 0;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                count++;
            }
        }

        return count == 1;
    }
}
