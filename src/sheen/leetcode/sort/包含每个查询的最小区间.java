package sheen.leetcode.sort;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 包含每个查询的最小区间
 * @Date 2023/7/18 00:21
 * @Created by sheen
 * @Description TODO
 */
public class 包含每个查询的最小区间 {

    public static void main(String[] args) {
        包含每个查询的最小区间 s = new 包含每个查询的最小区间();
        ArrayUtils.print(s.minInterval(new int[][]{{1,4},{2,4},{3,6},{4,4}}, new int[]{2, 3, 4, 5}));
    }


    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (x, y) -> {
            int len1 = x[1] - x[0] + 1;
            int len2 = y[1] - y[0] + 1;
            return len1 - len2;
        });

        int[][] search = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++) {
            search[i][0] = i;
            search[i][1] = queries[i];
        }
        Arrays.sort(search, (x, y) -> x[1] - y[1]);

        int[] next = new int[queries.length];
        Arrays.fill(next, -1);
        int[] res = new int[queries.length];
        Arrays.fill(res, - 1);
        int count = 0;
        for(int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int len = right - left + 1;
            int indL = findLeft(left, search);
            int indR = findRight(right, search);
            if(indL < search.length) {
                for(int j = indL; j <= indR; j++) {
                    if(next[j] != -1) {
                        j = next[j];
                    }else {
                        next[j] = indR;
                        res[search[j][0]] = len;
                        count++;
                    }
                }
            }
            if(count == search.length) {
                break;
            }
        }
        return res;
    }

    public int findLeft(int value, int[][] search) {
        int left = 0;
        int right = search.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(search[mid][1] >= value) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int findRight(int value, int[][] search) {
        int left = 0;
        int right = search.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(search[mid][1] > value) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
}
