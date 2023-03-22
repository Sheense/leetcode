package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 股票价格跨度
 * @Date 2022/10/21 12:37 上午
 * @Created by sheen
 * @Description TODO
 */
public class 股票价格跨度 {
    static class StockSpanner {

        private Stack<int[]> stack = new Stack<>();
        private int count = 0;
        public StockSpanner() {

        }

        public int next(int price) {
            while (!stack.isEmpty() && stack.peek()[1] <= price) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                stack.push(new int[]{count, price});
                count++;
                return count;
            }else {
                int res = count - stack.peek()[0];
                stack.push(new int[]{count, price});
                count++;
                return res;
            }


        }
    }
}
