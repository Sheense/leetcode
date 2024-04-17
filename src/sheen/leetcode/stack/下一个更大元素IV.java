package sheen.leetcode.stack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Classname 下一个更大元素IV
 * @Date 2023/12/12 00:47
 * @Created by sheen
 * @Description TODO
 */
public class 下一个更大元素IV {
    public int[] secondGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int[] res = new int[nums.length];
        Arrays.fill(res, - 1);
        for(int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek()[0] < nums[i]) {
                res[queue.poll()[1]] = nums[i];
            }

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                queue.offer(new int[]{nums[stack.peek()], stack.peek()});
                stack.pop();
            }

            stack.push(i);
        }
        return res;
    }
}
