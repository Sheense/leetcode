package com.company.greedyAlgorithm;

/**
 * @Classname 新增的最少台阶数
 * @Date 2021/7/18 12:09 下午
 * @Created by sheen
 * @Description TODO
 */
public class 新增的最少台阶数 {
    public static void main(String[] args) {
        新增的最少台阶数 s = new 新增的最少台阶数();
        System.out.println(s.addRungs(new int[]{1,3,5,10}, 2));
    }
    public int addRungs(int[] rungs, int dist) {
        int now = 0;
        int res = 0;
        for(int i = 0; i < rungs.length; i++) {
            if(rungs[i] > now + dist) {
                int diff = rungs[i] - dist - now;
                res += Math.ceil((double)diff/dist);
            }
            now = rungs[i];
        }
        return res;
    }
}
