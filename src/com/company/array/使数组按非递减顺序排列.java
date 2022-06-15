package com.company.array;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname 使数组按非递减顺序排列
 * @Date 2022/5/29 10:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 使数组按非递减顺序排列 {
    public static void main(String[] args) {
        使数组按非递减顺序排列 s = new 使数组按非递减顺序排列();
        System.out.println(s.totalSteps1(new int[]{10,1,2,3,4,5,6,1,2,3}));
        System.out.println(s.totalSteps1(new int[]{5,3,4,4,7,3,6,11,8,5,11}));
    }

    public int totalSteps(int[] nums) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int max = 0;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                int v = stack.pop();
                max = Math.max(dp[v], max);
            }

            if(!stack.isEmpty()) {
                dp[i] = max + 1;
            }

            stack.push(i);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int totalSteps1(int[] nums) {
        int[] map = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int i = nums.length - 1;
        while (i >= 0) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            map[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            stack.push(i);
            i--;
        }


        return recall(0, nums.length, nums, map)[1];
    }

    public int[] recall(int start, int end, int[] nums, int[] map) {
        int res = 0;
        int max = 0;
        int pre = start;
        int yu = end - start;

        for(int i = start + 1; i < end; i++) {
            if(nums[pre] <= nums[i]) {
                pre++;
            }else{
                int next = map[pre];
                int arr[];
                int all;
                if(next == Integer.MAX_VALUE) {
                    all = end - i;
                    arr = recall(i, end, nums, map);
                    i = end;
                }else {
                    all = next - i;
                    arr = recall(i, next, nums, map);
                    pre = i;
                    i = next - 1;
                }
                res = Math.max(arr[1], res);
                max = Math.max(arr[0], max);
                yu -= all;
            }
        }


        return new int[]{yu, Math.max(max, res)};
    }
}
