package sheen.leetcode.array;

/**
 * @Classname 相同分数的最大操作数目
 * @Date 2024/6/7 00:38
 * @Created by sheen
 * @Description TODO
 */
public class 相同分数的最大操作数目 {
    public int maxOperations(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        int flag = nums[0] + nums[1];
        int res = 1;
        for(int i = 2; i + 1 < nums.length; i+=2) {
            if(flag == nums[i] + nums[i + 1]) {
                res ++;
            }else {
                break;
            }
        }
        return res;
    }
}
