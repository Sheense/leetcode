package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname 最大子序列的分数
 * @Date 2023/5/5 4:34 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最大子序列的分数 {
    public static void main(String[] args) {
        最大子序列的分数 s = new 最大子序列的分数();
        System.out.println(s.maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
        System.out.println(s.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] arr2 = new int[nums2.length][2];
        for(int i = 0; i < nums1.length; i++) {
            arr2[i] = new int[]{nums2[i], i};
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(arr2, (x, y) -> y[0] - x[0]);
        long now = 0;
        for(int i = 0; i < k; i++) {
            now += nums1[arr2[i][1]];
            queue.offer(nums1[arr2[i][1]]);
        }
        long res = 0;
        for(int i = k - 1; i < arr2.length; i++) {
            res = Math.max(now * arr2[i][0], res);
            now -= queue.poll();
            if(i + 1 < arr2.length) {
                queue.offer(nums1[arr2[i + 1][1]]);
                now += nums1[arr2[i + 1][1]];
            }
        }
        return res;
    }
}
