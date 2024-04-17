package sheen.leetcode.math;

/**
 * @Classname 找出数组的串联值
 * @Date 2023/10/12 00:14
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组的串联值 {
    public static void main(String[] args) {
        找出数组的串联值 s = new 找出数组的串联值();
        System.out.println(s.findTheArrayConcVal(new int[]{7,52,2,4}));
    }
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        long res = 0;
        while (left <= right) {
            if(left == right) {
                res += nums[left];
            }else {
                long i = 1;
                while (nums[right] >= i) {
                    i *= 10;
                }
                res += (long)nums[left] * i + nums[right];
            }
            left ++;
            right --;
        }
        return res;
    }
}
