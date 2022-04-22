package com.company.math;

/**
 * @Classname 买钢笔和铅笔的方案数
 * @Date 2022/4/16 11:07 下午
 * @Created by sheen
 * @Description TODO
 */
public class 买钢笔和铅笔的方案数 {
    public static void main(String[] args) {
        买钢笔和铅笔的方案数 s = new 买钢笔和铅笔的方案数();
        System.out.println(s.waysToBuyPensPencils(1000000, 1, 1));
    }
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int num1 = total / cost1;
        for(int i = 0; i <= num1; i++) {
            res +=  (total - cost1 * i) / cost2;
            res++;
        }

        return res;
    }
}
