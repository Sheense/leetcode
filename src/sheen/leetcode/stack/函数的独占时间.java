package sheen.leetcode.stack;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Classname 函数的独占时间
 * @Date 2022/8/7 12:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class 函数的独占时间 {
    public static void main(String[] args) {
        函数的独占时间 s = new 函数的独占时间();
        ArrayUtils.print(s.exclusiveTime(2, Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8")));
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int nowTime = 0;
        for(int i = 0; i < logs.size(); i++) {
            String[] strs = logs.get(i).split(":");
            int num = Integer.valueOf(strs[0]);
            int time = Integer.valueOf(strs[2]);
            if(strs[1].equals("start")) {
                if(!stack.isEmpty()) {
                    int peek = stack.peek();
                    res[peek] += time - nowTime;
                }
                nowTime = time;
                stack.push(num);
            }else {
                stack.pop();
                res[num] += time - nowTime + 1;
                nowTime = time + 1;
            }
        }

        return res;
    }
}
