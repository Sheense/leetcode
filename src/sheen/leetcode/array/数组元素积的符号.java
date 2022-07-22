package sheen.leetcode.array;

public class 数组元素积的符号 {
    public int arraySign(int[] nums) {
        int item = 1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0) {
                item *= -1;
            }else if(nums[i] == 0) {
                return 0;
            }
        }
        return item;
    }
}
