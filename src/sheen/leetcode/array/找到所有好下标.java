package sheen.leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 找到所有好下标
 * @Date 2022/9/25 4:37 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找到所有好下标 {
    public static void main(String[] args) {
        找到所有好下标 s = new 找到所有好下标();
        System.out.println(s.goodIndices(new int[]{478184,863008,716977,921182,182844,350527,541165,881224}, 1));
    }
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int count = 1;
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++) {
            left[i] = count;
            if(pre >= nums[i]) {
                count++;
            }else {
                count = 1;
            }
            pre = nums[i];
        }

        count = 1;
        pre = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            right[i] = count;
            if(pre >= nums[i]) {
                count++;
            }else {
                count = 1;
            }
            pre = nums[i];
        }
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(left[i] >= k && right[i] >= k) {
                res.add(i);
            }
        }

        return res;
    }
}
