package com.company.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 汉诺塔问题 {
    public static void main(String[] args) {
        汉诺塔问题 s = new 汉诺塔问题();
        List<Integer> A = new ArrayList<>(Arrays.asList(14,13,12,11,10,9,8,7,6,5,4,3,2,1,0));
        List<Integer> C = new ArrayList<>();
        s.hanota(A, new ArrayList<>(), C);
        System.out.println(C);

    }
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        List<List<Integer>> list = Arrays.asList(A, B, C);
        Stack<int[]> stack = new Stack<>();
        int n = A.size();
        while (n > 0) {
            stack.push(new int[]{1 ,2});
            stack.push(new int[]{0, 1});
            n--;
        }
        while (!stack.isEmpty()) {
            int[] arr = stack.pop();
            int s = list.get(arr[0]).remove(0);
            list.get(arr[1]).add(s);
        }
    }


}
