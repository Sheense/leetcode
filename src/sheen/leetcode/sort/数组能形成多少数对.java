package sheen.leetcode.sort;

/**
 * @Classname 数组能形成多少数对
 * @Date 2023/2/16 12:01 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数组能形成多少数对 {
    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]] ++;
        }

        int[] res = new int[2];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 2) {
                res[0] += (arr[i] / 2);
            }
            res[1] += (arr[i] % 2);
        }

        return res;
    }
}
