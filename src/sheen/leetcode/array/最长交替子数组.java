package sheen.leetcode.array;

/**
 * @Classname 最长交替子数组
 * @Date 2024/1/23 00:12
 * @Created by sheen
 * @Description TODO
 */
public class 最长交替子数组 {
    public static void main(String[] args) {
        最长交替子数组 s = new 最长交替子数组();
        System.out.println(s.alternatingSubarray(new int[]{2,3,4,3,4}));
    }
    public int alternatingSubarray(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int item = 0;
            if(i + 1 < nums.length) {
                item = nums[i + 1] - nums[i];
            }else {
                continue;
            }
            if(item != 1) {
                continue;
            }
            int j = i+1;
            for(; j < nums.length; j++) {
                if(item == nums[j] - nums[j - 1]) {
                    item = -item;
                }else {
                    break;
                }
            }
            max = Math.max(j - i, max);
        }

        return max == 0 ? -1 : max;
    }
}
