package com.company.stack;

import com.company.util.ArrayUtils;

import java.util.Stack;

public class 下一个更大元素IIplus {

    public static void main(String[] args) {
        下一个更大元素IIplus s = new 下一个更大元素IIplus();
        ArrayUtils.print(s.nextGreaterElements(new int[]{5,4,3,2,1}));
    }

    public int[] nextGreaterElements(int[] nums) {
        int [] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=(nums.length-1)*2;i>=0;i--) {
            while(!stack.isEmpty()&&nums[stack.peek()%nums.length]<=nums[i%nums.length]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i%nums.length] = -1;
            }else {
                res[i%nums.length] = nums[stack.peek()%nums.length];
            }
            stack.push(i);
        }
        return res;
    }
}
