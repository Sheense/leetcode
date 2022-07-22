package sheen.leetcode.stack;

import sheen.leetcode.util.ArrayUtils;

import java.util.Stack;

public class 找出最具竞争力的子序列 {
    public static void main(String[] args) {
        找出最具竞争力的子序列 s = new 找出最具竞争力的子序列();
        ArrayUtils.print(s.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4));
    }
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]&&(nums.length-i+stack.size()>k)) {
                stack.pop();
            }
            if(k == nums.length - i + stack.size()) {
                for(int j=i;j<nums.length;j++) stack.push(j);
                break;
            }else {
                stack.push(i);
            }
        }
        while(stack.size()>k) stack.pop();
        int[] res = new int[k];
        int index = k-1;
        while(!stack.isEmpty()) {
            res[index--] = nums[stack.pop()];
        }
        return res;
    }
}
