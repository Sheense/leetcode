package sheen.leetcode.stack;

import java.util.Stack;

public class 计算器 {
    public static void main(String[] args) {
        计算器 s = new 计算器();
        System.out.println(s.calculate("3-2/5-3-1"));
    }
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> fu = new Stack<>();
        int i = 0;
        while (i<s.length()) {
            if (s.charAt(i) != ' ') {
                if (s.charAt(i) >= '0' && s.charAt(i)<='9') {
                    int num = 0;
                    while (i<s.length() && (s.charAt(i) >= '0' && s.charAt(i) <='9' || s.charAt(i) == ' ')) {
                        if (s.charAt(i) != ' ') {
                            num*=10;
                            num+= (s.charAt(i) - '0');
                        }
                        i++;
                    }
                    if(!fu.isEmpty()&&fu.peek()!='+') {
                        char c = fu.pop();
                        switch (c) {
                            case '-': {
                                fu.push('+');
                                nums.push(-num);
                                break;
                            }
                            case '*': {
                                int a = nums.pop();
                                nums.push(num *= a);
                                break;
                            }
                            case '/': {
                                int a = nums.pop();
                                nums.push(a / num);
                                break;
                            }
                        }
                    }else {
                        nums.push(num);
                    }
                }else {
                    fu.push(s.charAt(i));
                    i++;
                }
            }else {
                i++;
            }
        }
        int res = nums.pop();
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
    }
}
