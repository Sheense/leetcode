package sheen.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname 构造限制重复的字符串
 * @Date 2022/2/20 11:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 构造限制重复的字符串 {
    public static void main(String[] args) {
        构造限制重复的字符串 s = new 构造限制重复的字符串();
        System.out.println(s.repeatLimitedString("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg", 1));
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                stack.push(i);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            int index = stack.pop();
            while (arr[index] > 0) {
                for(int j = 0; j < Math.min(repeatLimit, arr[index]); j++) {
                    res.append((char)(index + 'a'));
                }
                arr[index] -= Math.min(repeatLimit, arr[index]);

                if(!stack.isEmpty()) {
                    if(arr[index] != 0) {
                        res.append((char)(stack.peek() + 'a'));
                        arr[stack.peek()] --;
                        if(arr[stack.peek()] == 0) {
                            stack.pop();
                        }
                    }
                }else {
                    break;
                }
            }
        }
        return res.toString();
    }
    public String repeatLimitedString1(String s, int repeatLimit) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                stack.push(i);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            int index = stack.pop();

            if(res.length() > 0 && res.charAt(res.length() - 1) == index + 'a') {
                if(!stack.isEmpty()) {
                    int nextIndex = stack.pop();
                    res += (char)(nextIndex + 'a');
                    arr[nextIndex] -= 1;
                    if(arr[nextIndex] != 0) {
                        stack.push(nextIndex);
                    }
                }else {
                    break;
                }

                for(int j = 0; j < Math.min(repeatLimit, arr[index]); j++) {
                    res += (char)(index + 'a');
                }
                arr[index] -= Math.min(repeatLimit, arr[index]);
                if(arr[index] != 0) {
                    stack.push(index);
                }
            }else {
                for(int j = 0; j < Math.min(repeatLimit, arr[index]); j++) {
                    res += (char)(index + 'a');
                }
                arr[index] -= Math.min(repeatLimit, arr[index]);

                if(!stack.isEmpty()) {
                    if(arr[index] != 0) {
                        int nextIndex = stack.pop();
                        res += (char)(nextIndex + 'a');
                        arr[nextIndex] -= 1;
                        if(arr[nextIndex] != 0) {
                            stack.push(nextIndex);
                        }
                    }else {
                        int nextIndex = stack.pop();
                        for(int j = 0; j < Math.min(repeatLimit, arr[nextIndex]); j++) {
                            res += (char)(nextIndex + 'a');
                        }
                        arr[nextIndex] -= Math.min(repeatLimit, arr[nextIndex]);
                        if(arr[nextIndex] != 0) {
                            stack.push(nextIndex);
                        }
                    }
                }else {
                    break;
                }
                if(arr[index] != 0) {
                    stack.push(index);
                }
            }
        }
        return res;
    }
}
