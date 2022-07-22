package sheen.leetcode.array;

/**
 * @Classname 在长度2N的数组中找出重复N次的元素
 * @Date 2022/5/21 11:46 上午
 * @Created by sheen
 * @Description TODO
 */
public class 在长度2N的数组中找出重复N次的元素 {
    public int repeatedNTimes(int[] nums) {
        int[] arr = new int[10000];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if(arr[nums[i]] == nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }
}
