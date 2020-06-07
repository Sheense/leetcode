package com.company.stack;

import java.util.Stack;
//栈保存左边最小的元素
public class 最大宽度坡 {

    public static void main(String[] args) {
        最大宽度坡 s = new 最大宽度坡();
        System.out.println(s.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<A.length;i++) {
            if(A[i]<A[stack.peek()]) {
                stack.push(i);
            }
        }
        int res = 0;
        for(int i=A.length-1;i>=0;i--) {
            if(!stack.isEmpty()&&i==stack.peek()) {
                stack.pop();
            }else {
                while(!stack.isEmpty()&&A[stack.peek()]<=A[i]) {
                    int j = stack.pop();
                    if(i-j>res) {
                        res = i-j;
                    }
                }
            }
        }
        return res;
    }


}
