package com.company.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 字典序排数
 * @Date 2022/4/18 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字典序排数 {
    public static void main(String[] args) {
        字典序排数 s = new 字典序排数();
        System.out.println(s.lexicalOrder(100));
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            if(i > n) {
                break;
            }
            res.add(i);
            recall(res, i, n);
        }
        return res;
    }

    public void recall(List<Integer> res, int now, int n) {
        for(int i = 0; i <= 9; i++) {
            if(now * 10 + i > n) {
                return;
            }
            res.add(now * 10 + i);
            ;recall(res, now * 10 + i, n);
        }
    }
}
