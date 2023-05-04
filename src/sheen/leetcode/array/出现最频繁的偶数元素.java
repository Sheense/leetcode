package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Classname 出现最频繁的偶数元素
 * @Date 2023/4/13 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 出现最频繁的偶数元素 {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int res = -1;
        int max = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if(nums[i] % 2 == 0 && max < (j - i + 1)) {
                res = nums[i];
                max = j - i + 1;
            }
            i = j;
        }
        return res;
    }

}
