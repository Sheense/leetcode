package sheen.leetcode.difference;

/**
 * @Classname 得分最高的最小轮调
 * @Date 2022/3/9 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 得分最高的最小轮调 {
    public int bestRotation(int[] nums) {
        int[] diff = new int[nums.length + 1];
        int size = nums.length;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(i < num) {
                diff[i + 1] ++;
                diff[size - num + i + 1] --;
            }else {
                diff[0] ++;
                diff[i - num + 1] --;
                diff[i + 1] ++;
            }
        }

        int res = 0;
        int max = 0;
        for(int i = 0; i < size; i++) {
            if(i > 0) {
                diff[i] += diff[i-1];
            }
            if(max < diff[i]) {
                res = i;
                max = diff[i];
            }
        }
        return res;
    }
}
