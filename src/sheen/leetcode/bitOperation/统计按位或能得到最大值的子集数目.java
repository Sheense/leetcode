package sheen.leetcode.bitOperation;

/**
 * @Classname 统计按位或能得到最大值的子集数目
 * @Date 2021/10/17 12:49 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计按位或能得到最大值的子集数目 {
    public int countMaxOrSubsets(int[] nums) {
        int[] count = new int[32];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max |= nums[i];
        }
        return recall(max, nums, 0, 0);
    }

    public int recall(int max, int[] nums, int index, int now) {
        if(index == nums.length) {
            if(now == max) {
                return 1;
            }
            return 0;
        }
        int a = recall(max, nums, index + 1, now);

        now |= nums[index];

        int b = recall(max, nums, index + 1, now);
        return a + b;
    }
}
