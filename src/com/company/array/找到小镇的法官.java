package com.company.array;

/**
 * @Classname 找到小镇的法官
 * @Date 2021/12/19 12:30 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < trust.length; i++) {
            a[trust[i][0]-1] ++;
            b[trust[i][1]-1] ++;
        }
        for(int i = 0; i < n; i++) {
            if(b[i] == n - 1 && a[i] == 0) {
                return i+1;
            }
        }
        return -1;
    }
}
