package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 验证栈序列
 * @Date 2022/8/31 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 验证栈序列 {
    public static void main(String[] args) {
        验证栈序列 s = new 验证栈序列();
        System.out.println(s.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int i = 0;
        for(; i < pushed.length && j < popped.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return i == pushed.length && j == popped.length && stack.isEmpty();
    }
}
