package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname 雇佣K名工人的最低成本
 * @Date 2022/9/11 6:11 下午
 * @Created by sheen
 * @Description TODO
 */
public class 雇佣K名工人的最低成本 {
    public static void main(String[] args) {
        雇佣K名工人的最低成本 s = new 雇佣K名工人的最低成本();
        System.out.println(s.mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30}, 2));
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        Integer[] idx = new Integer[quality.length];
        for(int i = 0; i < idx.length; i++) idx[i] = i;
        Arrays.sort(idx, (x, y) -> quality[y] * wage[x] - quality[x] * wage[y]);


        PriorityQueue<Integer> bucket = new PriorityQueue<>((x, y) -> quality[y] - quality[x]);
        double allQuality = 0;
        double res = Double.MAX_VALUE;
        for(int i = 0; i < idx.length; i++) {
            if(bucket.size() < k - 1) {
                bucket.offer(idx[i]);
                allQuality += quality[idx[i]];
                continue;
            }
            allQuality += quality[idx[i]];
            res = Math.min(res, (double) wage[idx[i]] / quality[idx[i]] * allQuality);
            bucket.offer(idx[i]);
            allQuality -= quality[bucket.poll()];
        }
        return res;
    }
}
