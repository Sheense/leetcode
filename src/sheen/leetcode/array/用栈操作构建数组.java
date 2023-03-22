package sheen.leetcode.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname 用栈操作构建数组
 * @Date 2022/10/15 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 用栈操作构建数组 {
    public static void main(String[] args) {
        用栈操作构建数组 s = new 用栈操作构建数组();
        System.out.println(s.buildArray(new int[]{2,3,4}, 4));
    }
    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        List<String> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= n; i++) {
            if(index == target.length) {
                break;
            }
            if(i == target[index]) {
                while (!stack.isEmpty() && (index - 1 == -1 || target[index - 1] != stack.peek())) {
                    stack.pop();
                    res.add("Pop");
                }
                index++;
            }
            stack.push(i);
            res.add("Push");
        }

        return res;
    }
}
