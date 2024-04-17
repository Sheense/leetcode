package sheen.leetcode.stack;

import sheen.leetcode.util.ArrayUtils;

import java.util.Stack;

/**
 * @Classname 队列中可以看到的人数
 * @Date 2024/1/5 00:51
 * @Created by sheen
 * @Description TODO
 */
public class 队列中可以看到的人数 {
    public static void main(String[] args) {
        队列中可以看到的人数 s = new 队列中可以看到的人数();
        ArrayUtils.print(s.canSeePersonsCount(new int[]{10,6,8,5,11,9}));
    }
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = heights.length - 1; i >= 0; i--)  {
            int count = 0;
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                count++;
            }
            ans[i] = count + (stack.isEmpty() ? 0 : 1);
            stack.push(i);
        }

        return ans;
    }
}
