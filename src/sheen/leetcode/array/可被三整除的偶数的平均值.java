package sheen.leetcode.array;

/**
 * @Classname 可被三整除的偶数的平均值
 * @Date 2023/5/29 12:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可被三整除的偶数的平均值 {
    public int averageValue(int[] nums) {
        int count = 0;
        int all = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 3 == 0 && nums[i] % 2 == 0) {
                count++;
                all += nums[i];
            }
        }
        if(count == 0) {
            return 0;
        }
        return all / count;
    }
}
