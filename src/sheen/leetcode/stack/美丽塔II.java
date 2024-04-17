package sheen.leetcode.stack;

import java.util.List;
import java.util.Stack;

/**
 * @Classname 美丽塔II
 * @Date 2023/12/21 01:02
 * @Created by sheen
 * @Description TODO
 */
public class 美丽塔II {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] prefix = new long[maxHeights.size()];
        long[] suffix = new long[maxHeights.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < maxHeights.size(); i++) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                prefix[i] = (i + 1) * (long)maxHeights.get(i);
            }else {
                prefix[i] = prefix[stack.peek()] + (i - stack.peek()) * (long)maxHeights.get(i);
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = maxHeights.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }


            if(stack.isEmpty()) {
                suffix[i] =  (maxHeights.size() - i) * (long)maxHeights.get(i);
            }else {
                suffix[i] = suffix[stack.peek()] + (stack.peek() - i) * (long)maxHeights.get(i);
            }
            stack.push(i);
        }

        long max = 0;
        for(int i = 0; i < maxHeights.size(); i++) {
            max = Math.max(max, prefix[i] + suffix[i] - maxHeights.get(i));
        }

        return max;
    }
}
