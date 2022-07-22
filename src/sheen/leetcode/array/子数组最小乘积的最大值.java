package sheen.leetcode.array;

import java.util.Stack;

public class 子数组最小乘积的最大值 {
    public static void main(String[] args) {
        子数组最小乘积的最大值 s = new 子数组最小乘积的最大值();
        System.out.println(s.maxSumMinProduct(new int[]{3,1,5,6,4,2}));
    }
    public int maxSumMinProduct(int[] nums) {
        long arr[] = new long[nums.length+1];
        for(int i=1;i< arr.length;i++) {
            arr[i] = arr[i-1] + nums[i-1];
        }
        int[][] q = new int[nums.length][2];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]>=nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                q[i][0] = 0;
            }else {
                q[i][0] = stack.peek()+1;
            }
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i = nums.length-1;i>=0;i--) {
            while (!stack.isEmpty()&&nums[stack.peek()]>= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                q[i][1] = arr.length - 1;
            }else {
                q[i][1] = stack.peek();
            }
            stack.push(i);
        }
        long max = 0;
        for(int i=0;i<q.length;i++) {
            max = Math.max(max, (arr[q[i][1]] - arr[q[i][0]]) * nums[i]);
        }
        return (int)(max % (long)(Math.pow(10,9) + 7));
    }

}
