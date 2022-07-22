package sheen.leetcode.bitOperation;

import java.util.PriorityQueue;

public class 找出第K大的异或坐标值 {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[][] copy = new int[matrix.length][matrix[0].length];
         for(int i =0; i<matrix.length;i++) {
             for(int j=0;j<matrix[0].length;j++) {
                 if(j != 0) {
                     matrix[i][j] = matrix[i][j-1] ^ matrix[i][j];
                 }
                 if (i == 0) {
                     copy[i][j] = matrix[i][j];
                 }else {
                     copy[i][j] = matrix[i][j]  ^ copy[i-1][j];
                 }
                 queue.add(copy[i][j]);
             }
         }
         while (k-- != 1) {
             queue.poll();
         }
         return queue.peek();
    }
}
