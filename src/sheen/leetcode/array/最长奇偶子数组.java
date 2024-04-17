package sheen.leetcode.array;

/**
 * @Classname 最长奇偶子数组
 * @Date 2023/11/16 00:45
 * @Created by sheen
 * @Description TODO
 */
public class 最长奇偶子数组 {
    public static void main(String[] args) {
        最长奇偶子数组 s = new 最长奇偶子数组();
        System.out.println(s.longestAlternatingSubarray(new int[]{3,2,5,4}, 5));
    }
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int i = 0;
        int max = 0;
        while (i < nums.length) {
            if(nums[i] % 2 == 0 && nums[i] <= threshold) {
                int l = i;
                i++;
                while (i < nums.length && nums[i] % 2 != nums[i - 1] % 2 && nums[i] <= threshold) {
                    i++;
                }
                max = Math.max(max, i - l);
            }else {
                i++;
            }
        }
        return max;
    }
}
