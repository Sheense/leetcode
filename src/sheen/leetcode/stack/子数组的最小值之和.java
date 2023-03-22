package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 子数组的最小值之和
 * @Date 2022/10/28 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 子数组的最小值之和 {
    public static void main(String[] args) {
        子数组的最小值之和 s = new 子数组的最小值之和();
        System.out.println(s.sumSubarrayMins(new int[]{3,1,2,4}));
    }
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)Math.pow(10, 9) + 7;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (arr.length - i) : stack.peek() - i;
            stack.push(i);
        }

        long res = 0;
        for(int i = 0; i < arr.length; i++) {
            res += ((long)left[i] * right[i]) * arr[i];
            res %= mod;
        }


        return (int) res;
    }
}
