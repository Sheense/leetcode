package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 删除最外层的括号
 * @Date 2022/5/28 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删除最外层的括号 {
    public static void main(String[] args) {
        删除最外层的括号 s = new 删除最外层的括号();
        System.out.println(s.removeOuterParentheses("(()())(())"));
    }
    public String removeOuterParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                int left = stack.pop();
                if(stack.isEmpty()) {
                    res += s.substring(left + 1, i);
                }
            }
            i++;
        }

        return res;
    }
}
