package com.company.math;

import java.util.Arrays;

/**
 * @Classname 获取单值网格的最小操作数
 * @Date 2021/10/10 11:30 下午
 * @Created by sheen
 * @Description TODO
 */
public class 获取单值网格的最小操作数 {
    public static void main(String[] args) {
        获取单值网格的最小操作数 s = new 获取单值网格的最小操作数();
        System.out.println(s.minOperations(new int[][]{{2,4},{6,8}}, 2));
    }
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int index = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                arr[index++] = grid[i][j];
                if((grid[i][j] - grid[0][0]) % x != 0) {
                    return -1;
                }
            }
        }
        Arrays.sort(arr);
        int target = 0;
        target = arr[arr.length / 2];


        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            count += Math.abs((arr[i] - target) / x);
        }
        return count;
    }
}
