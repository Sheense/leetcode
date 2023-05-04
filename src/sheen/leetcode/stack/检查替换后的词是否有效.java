package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 检查替换后的词是否有效
 * @Date 2023/5/3 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检查替换后的词是否有效 {
    public static void main(String[] args) {
        检查替换后的词是否有效 s = new 检查替换后的词是否有效();
        System.out.println(s.isValid("bac"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'c') {
                if(stack.isEmpty()) {
                    return false;
                }

                char b = stack.pop();
                if(b != 'b') {
                    return false;
                }

                if(stack.isEmpty()) {
                    return false;
                }

                char a = stack.pop();
                if(a != 'a') {
                    return false;
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


}
