package sheen.leetcode.array;

/**
 * @Classname 差的绝对值为K的数对数目
 * @Date 2022/2/9 12:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 差的绝对值为K的数对数目 {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(Math.abs(nums[i]- nums[j])==k) {
                    res++;
                }
            }
        }
        return res;
    }
}
