package sheen.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname 有序矩阵中的第k个最小数组和
 * @Date 2023/5/28 12:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有序矩阵中的第k个最小数组和 {
    public static void main(String[] args) {
        有序矩阵中的第k个最小数组和 s = new 有序矩阵中的第k个最小数组和();
        System.out.println(s.kthSmallest(new int[][]  {{1,3,11},{2,4,6}}, 5));
    }
    public int kthSmallest(int[][] mat, int k) {
        if(mat.length == 1) {
            return mat[0][k - 1];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for(int i = 0; i < mat[0].length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                queue.offer(mat[0][i] + mat[1][j]);
            }
        }
        while (queue.size() > k) {
            queue.poll();
        }

        for(int i = 2; i < mat.length; i++) {
            PriorityQueue<Integer> nextQueue = new PriorityQueue<>((x, y) -> y - x);
            for(int v : queue) {
                for(int j = 0; j < mat[i].length; i++) {
                    nextQueue.offer(v + mat[i][j]);
                }
            }
            queue = nextQueue;
            while (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
