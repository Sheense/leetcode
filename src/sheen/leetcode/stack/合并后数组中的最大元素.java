package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 合并后数组中的最大元素
 * @Date 2024/3/14 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 合并后数组中的最大元素 {
    public long maxArrayValue(int[] nums) {
        long res = 0;
        Stack<Long> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && nums[i] <= stack.peek()) {
                long peek = stack.pop();
                stack.push(peek + nums[i]);
            }else {
                stack.push((long)nums[i]);
            }
            res = Math.max(res, stack.peek());
        }

        return res;
    }
}
