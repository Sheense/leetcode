package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname 矩阵中的和
 * @Date 2023/7/4 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵中的和 {
    public int matrixSum(int[][] nums) {
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
            for(int j = 0; j < nums[i].length; j++) {
                queue.offer(nums[i][j]);
            }
            list.add(queue);
        }
        int res = 0;

        for(int i = 0; i < nums[0].length; i++) {
            int max = 0;
            for(PriorityQueue<Integer> queue : list) {
                max = Math.max(max, queue.poll());
            }
            res += max;
        }
        return res;
    }
}
