package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 有效的括号字符串
 * @Date 2021/9/12 1:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有效的括号字符串 {
    public static void main(String[] args) {
        有效的括号字符串 s = new 有效的括号字符串();
        System.out.println(s.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> point = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left.push(i);
            }else if(s.charAt(i) == ')') {
                if(left.size() == 0 && point.size() == 0) {
                    return false;
                }else if(left.size() != 0) {
                    left.pop();
                }else {
                    point.pop();
                }
            }else {
               point.push(i);
            }
        }
        while (!left.isEmpty()) {
            int index = left.pop();
            if(!point.isEmpty()&&point.peek() > index) {
                point.pop();
            }else {
                return false;
            }
        }
        return true;
    }
}
