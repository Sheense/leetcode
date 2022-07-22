package sheen.leetcode.stack;

import java.util.Stack;

public class 字符串解码 {

    public static void main(String[] args) {
        字符串解码 s = new 字符串解码();
        System.out.println(s.decodeString("sd2[f2[e]g]i"));
    }
    public String decodeString(String s) {
        int i = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<String>  stack2 = new Stack<>();
        String res = "";
        String now = "";
        while(i<s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if(stack1.isEmpty()) {
                    res += now;
                    now = "";
                }
                int num = s.charAt(i) - '0';
                i++;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                stack1.push(num);
            } else if (s.charAt(i) == '[') {
                if (!stack1.isEmpty()) {
                    stack2.push(now);
                    now = "";
                }
                i++;
            } else if (s.charAt(i) == ']') {
                int n = stack1.pop();
                String item = "";
                for (int j = 0; j < n; j++) {
                    item += now;
                }
                if (stack1.isEmpty()) {
                    res += item;
                    now = "";
                } else {
                    String string = stack2.pop();
                    now = string + item;
                }
                i++;
            } else {
                now += s.charAt(i);
                i++;
            }
        }
        res = res + now;
        return res;
    }
}
