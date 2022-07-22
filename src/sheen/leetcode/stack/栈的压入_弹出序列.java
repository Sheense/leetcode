package sheen.leetcode.stack;

import java.util.Stack;

public class 栈的压入_弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i=0;i<pushed.length;i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty() && index == popped.length;
    }
}
