package sheen.leetcode.stack;

import sheen.leetcode.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 下一个更大元素II {

    public static void main(String[] args) {
        下一个更大元素II s = new 下一个更大元素II();
        ArrayUtils.print(s.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2}));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = nums2.length-1;i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int [] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> next = new HashMap();
        for(int i=0;i<nums2.length;i++) {
            if(!stack.isEmpty()&&stack.peek()<nums2[i]) {
                while(!stack.isEmpty()&&stack.peek()<nums2[i]) {
                    next.put(stack.pop(), nums2[i]);
                }
            }
            stack.push(nums2[i]);
        }
        int [] res = new int[nums1.length];
        for(int i=0;i<res.length;i++) {
            res[i] = next.containsKey(nums1[i])?next.get(nums1[i]):-1;
        }
        return res;
    }
}
