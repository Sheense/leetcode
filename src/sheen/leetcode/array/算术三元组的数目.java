package sheen.leetcode.array;

/**
 * @Classname 算术三元组的数目
 * @Date 2022/8/7 10:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 算术三元组的数目 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            for(int j = 0; j < i; j++) {
                int a = nums[i] - nums[j];
                if(a == diff) {
                    for(int z = i + 1; z < nums.length; z++) {
                        if(nums[z] - nums[i] == a) {
                            res ++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
