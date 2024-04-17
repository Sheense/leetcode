package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 修车的最少时间
 * @Date 2023/9/7 00:12
 * @Created by sheen
 * @Description TODO
 */
public class 修车的最少时间 {
    public static void main(String[] args) {
        修车的最少时间 s = new 修车的最少时间();
        System.out.println(s.repairCars(new int[]{4, 2, 3, 1}, 10));
        System.out.println(s.repairCars(new int[]{5, 1, 8}, 6));
        System.out.println(s.repairCars(new int[]{5, 1, 8}, 6));
    }
    public long repairCars(int[] ranks, int cars) {
        int max = ranks[0];
        for(int i : ranks) {
            max = Math.max(max, i);
        }
        Arrays.sort(ranks);
        long right = (long)cars * cars * max;
        long left = 0;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            if(can(ranks, mid, cars)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean can(int[] ranks, long target, int car) {
        for(int rank : ranks) {
            int v = (int)Math.sqrt(target / rank);
            if(v > car) {
                return true;
            }
            car -= v;
        }
        return car == 0;
    }

}
