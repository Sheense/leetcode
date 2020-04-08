package com.company.recall;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {

    public static void main(String[] args) {
        组合总和III s = new 组合总和III();
        System.out.println(s.combinationSum3(3,9));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recall(res,k,n,new ArrayList<>(),1);
        return res;
    }
    public void recall(List<List<Integer>> res, int k, int n,List<Integer> now,int start) {
        if(n==0) {
            if(k!=0) return ;
            else res.add(now);
        }
        if(k==0) return;
        if(start>9||start>n) return;
        List<Integer> list = new ArrayList<>(now);
        list.add(start);
        recall(res, k-1,n-start,list,start+1);
        recall(res,k,n,now,start+1);
    }
}
