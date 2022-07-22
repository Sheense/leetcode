package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname 给表达式添加运算符
 * @Date 2021/10/16 12:17 下午
 * @Created by sheen
 * @Description TODO
 */
public class 给表达式添加运算符 {
    public static void main(String[] args) {
        给表达式添加运算符 s = new 给表达式添加运算符();
        System.out.println(s.addOperators("3456237490", 9191));
    }
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        recall(res, new Stack<>(), new Stack<>(), 0, num, target);
        return res;
    }

    public void recall(List<String> res, Stack<String> stack, Stack<Long> nums ,int index, String num, int target) {
        if(index == num.length()) {
            Stack<String> stack1 = new Stack<>();
            Stack<Long> nums1 = new Stack<>();
            while (!stack.isEmpty() || !nums.isEmpty()) {
                if(!stack.isEmpty()) {
                    stack1.push(stack.pop());
                }
                if(!nums.isEmpty()) {
                    nums1.push(nums.pop());
                }
            }
            String str = "";
            long now = 0;
            while (!stack1.isEmpty()) {
                String s = stack1.pop();
                if(s.equals("-") || s.equals("+")) {
                    long b = nums1.pop();
                    str += s + stack1.pop();
                    if(s.equals("-")) {
                        now -= b;
                    }else if(s.equals("+")) {
                        now += b;
                    }
                }else {
                    str += s;
                    now = nums1.pop();
                }
            }
            if(now == target) {
                res.add(str);
            }
            return;
        }
        boolean flag = false;
        if(num.charAt(index) == '0') {
            flag = true;
        }
        for(int i = index; i < num.length(); i++) {
            if(flag && i != index) {
                break;
            }
            String a = num.substring(index, i + 1);
            long aNum = Long.parseLong(a);
            if(stack.isEmpty()){
                Stack<String > copyStack = (Stack<String >)stack.clone();
                Stack<Long> copyNums = (Stack<Long>) nums.clone();
                copyStack.push(a);
                copyNums.push(aNum);
                recall(res, copyStack, copyNums, i+1, num, target);
            }else {
                Stack<String > copyStack = (Stack<String >)stack.clone();
                Stack<Long> copyNums = (Stack<Long>) nums.clone();
                String b = copyStack.pop();
                long bNum = copyNums.pop();
                b += "*" + a;
                bNum *= aNum;
                copyStack.push(b);
                copyNums.push(bNum);
                recall(res, copyStack, copyNums, i+1, num, target);

                copyStack = (Stack<String >)stack.clone();
                copyNums = (Stack<Long>) nums.clone();
                copyStack.push("+");
                copyStack.push(a);
                copyNums.push(aNum);
                recall(res, copyStack, copyNums, i+1, num, target);

                copyStack = (Stack<String >)stack.clone();
                copyNums = (Stack<Long>) nums.clone();
                copyStack.push("-");
                copyStack.push(a);
                copyNums.push(aNum);
                recall(res, copyStack, copyNums, i+1, num, target);
            }
        }
    }

    public void process(Stack<String> stack, Stack<Long> nums, String a, long aNum,List<String> res, int index, String num, int target) {
        Stack<String > copyStack = (Stack<String >)stack.clone();
        Stack<Long> copyNums = (Stack<Long>) nums.clone();
        copyStack.push(a);
        copyStack.push("+");
        copyNums.push(aNum);
        recall(res, copyStack, copyNums, index + 1, num, target);

        copyStack = (Stack<String >)stack.clone();
        copyNums = (Stack<Long>) nums.clone();
        copyStack.push(a);
        copyStack.push("-");
        copyNums.push(aNum);
        recall(res, copyStack, copyNums, index + 1, num, target);

        copyStack = (Stack<String >)stack.clone();
        copyNums = (Stack<Long>) nums.clone();
        copyStack.push(a);
        copyStack.push("*");
        copyNums.push(aNum);
        recall(res, copyStack, copyNums, index + 1, num, target);
    }
}
