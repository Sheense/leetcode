package com.company.array;

import java.util.PriorityQueue;

/**
 * @Classname 矩阵中战斗力最弱的K行
 * @Date 2021/8/1 12:36 上午
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵中战斗力最弱的K行 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int[] arr = new int[mat.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>(((x, y) -> {
            if(arr[x]!=arr[y]) return  arr[x] - arr[y];
            return x - y;
        }));
        for(int i = 0; i < mat.length; i++) {
            int count = 0;
            for(int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) count++;
                else break;
            }
            arr[i] = count;
            queue.add(i);
        }
        for(int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
