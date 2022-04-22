package com.company.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 棒球比赛
 * @Date 2022/3/26 12:55 上午
 * @Created by sheen
 * @Description TODO
 */
public class 棒球比赛 {
    public static void main(String[] args) {
        棒球比赛 s= new 棒球比赛();
        System.out.println(s.calPoints(new String[]{"5","2","C","D","+"}));
    }
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for(int i = 0; i < ops.length; i++) {
            if(ops[i].equals("+")) {
                int v = list.get(list.size() - 1) + list.get(list.size() - 2);
                res += v;
                list.add(v);
            }else if(ops[i].equals("D")) {
                int v = 2 * list.get(list.size() - 1);
                res += v;
                list.add(v);
            }else if(ops[i].equals("C")) {
                res -= list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }else {
                int v = Integer.valueOf(ops[i]);
                res += v;
                list.add(v);
            }
        }
        return res;
    }
}
