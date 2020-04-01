package com.company.recall;

import com.company.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    public static void main(String[] args) {
        组合 s = new 组合();
        ArrayUtils.print2(s.combine(4,2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recall(1,n,res,new ArrayList<>(),k);
        return res;
    }
    public void recall(int start, int n, List<List<Integer>> res ,List<Integer> now ,int k) {
        if(start>n) return;
        for(int i=start;i<=n;i++){
            List<Integer> list = new ArrayList<>(now);
            list.add(i);
            if(now.size()+1==k) {
                res.add(list);
            }else {
                recall(i+1,n,res,list,k);
            }
        }
    }
}
