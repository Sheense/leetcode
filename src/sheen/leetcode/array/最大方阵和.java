package sheen.leetcode.array;

import java.util.PriorityQueue;

/**
 * @Classname 最大方阵和
 * @Date 2021/8/21 10:54 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最大方阵和 {
    public long maxMatrixSum(int[][] matrix) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            int row1 = x / matrix[0].length;
            int column1 = x % matrix[0].length;
            int row2 = y / matrix[0].length;
            int column2 = y % matrix[0].length;
            return Math.abs(matrix[row1][column1]) >= Math.abs(matrix[row2][column2]) ? 1 : -1;
        });
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < 0) count++;
                queue.add(i*matrix[0].length+j);
            }
        }
        long res = 0;
        if(count % 2 == 1) {
            int row=queue.peek()/matrix[0].length;
            int column=queue.peek()%matrix[0].length;
            queue.poll();
            res = -Math.abs(matrix[row][column]);
        }
        while (!queue.isEmpty()){
            int row=queue.peek()/matrix[0].length;
            int column=queue.peek()%matrix[0].length;
            queue.poll();
            res += Math.abs(matrix[row][column]);
        }
        return res;
    }
}
