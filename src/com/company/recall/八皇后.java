package com.company.recall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 八皇后 {
    public static void main(String[] args) {
        八皇后 s = new 八皇后();
        System.out.println(s.solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        build(new ArrayList<>(), res, n);
        return res;
    }

    public void build(List<Integer> now, List<List<String>> res, int size) {
        if(now.size() == size) {
            List<String> item = new ArrayList<>();
            for(int i=0;i<now.size();i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<size;j++) {
                    if(j == now.get(i)) {
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                item.add(sb.toString());
            }
            res.add(item);
            return;
        }
        for(int i = 0; i < size; i++) {
            if(check(now, i, size)) {
                List<Integer> copy  = new ArrayList<>(now);
                copy.add(i);
                build(copy, res, size);
            }
        }
    }

    public boolean check(List<Integer> now, int i, int size) {
        if(now.size() == 0) return true;
        for(int j=0;j<now.size();j++) {
            if(now.get(j) == i) return false;
        }

        for(int j = 1;j<=now.size()&&now.size()-j>=0;j++) {
            if(now.get(now.size()-j) == i -j) {
                return false;
            }
        }

        for(int j = 1;j<=now.size()&&now.size()-j>=0;j++) {
            if(now.get(now.size()-j) == i +j) {
                return false;
            }
        }
        return true;
    }

}
