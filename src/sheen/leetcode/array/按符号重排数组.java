package sheen.leetcode.array;

/**
 * @Classname 按符号重排数组
 * @Date 2022/1/23 11:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 按符号重排数组 {
    public int[] rearrangeArray(int[] nums) {
        int a[] = new int[nums.length / 2];
        int b[] = new int[nums.length / 2];
        int aIndex = 0;
        int bIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                a[aIndex] = nums[i];
                aIndex++;
            }
            if(nums[i] < 0) {
                b[bIndex] = nums[i];
                bIndex++;
            }
        }
        int res[] = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i+=2) {
            res[i] = a[index];
            res[i+1] = b[index];
            index++;
        }
        return res;
    }
}
