package sheen.leetcode.stack;

import sheen.leetcode.util.ArrayUtils;

import java.util.Stack;

//遍历时，维护一个单调递减的栈
public class 每日温度 {

    public static void main(String[] args) {
        每日温度 s = new 每日温度();
        ArrayUtils.print(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++) {
            while(!stack.isEmpty()&&T[stack.peek()]<T[i]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }
}
