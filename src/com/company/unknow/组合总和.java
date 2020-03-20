package com.company.unknow;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        System.out.println(new 组合总和().combinationSum(new int[]{2,3,6,7}, 7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        sort(candidates, 0, candidates.length-1);
        find(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void find(List<List<Integer>> res, int [] candidates, int target , List<Integer> now, int index) {
        if(index<0) return;
        int n = candidates[index];
        int t = target/n;
        for(int i=t; i>=0;i--) {
            int r = target - i * candidates[index];
            List<Integer> list = new ArrayList<>();
            list.addAll(now);
            for(int j=0;j<i;j++) {
                list.add(candidates[index]);
            }
            res.add(list);
            if(r==0) {
                res.add(list);
            }else {
                find(res, candidates, n, list, index--);
            }
        }
    }

    public void sort(int [] arr, int start, int end) {
        if(start>=end) return;
        int left = start;
        int right = end;
        while(left!=right) {
            while (left!=right&&left<=right) left++;
            if(left==right) break;;
            swap(arr, left, right);
            while (left!=right&&left<=right) right--;
            swap(arr, left, right);
        }
    }

    public void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
