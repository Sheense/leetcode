package sheen.leetcode.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname 裁剪数字后查询第K小的数字
 * @Date 2023/5/5 3:05 下午
 * @Created by sheen
 * @Description TODO
 */
public class 裁剪数字后查询第K小的数字 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String[] newNum = new String[nums.length];
            PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
                int v = newNum[x].compareTo(newNum[y]);
                if(v == 0) {
                    return x > y ? 1 : -1;
                }
                return v > 0 ? 1 : -1;
            });
            for(int j = 0; j < nums.length; j++) {
                newNum[j] = nums[j].substring(nums.length - queries[i][1]);
                queue.offer(j);
            }
            int j = 1;
            while (j != queries[i][0]) {
                queue.poll();
                j++;
            }
            res[i] = queue.peek();
        }
        return res;
    }

}
