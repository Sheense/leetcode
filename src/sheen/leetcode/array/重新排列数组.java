package sheen.leetcode.array;

/**
 * @Classname 重新排列数组
 * @Date 2022/8/29 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重新排列数组 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int first = 0;
        int second = n;
        for(int i = 0; i < res.length; i+=2) {
            res[i] = nums[first];
            res[i + 1] = nums[second];
            first++;
            second++;
        }
        return res;
    }
}
