package sheen.leetcode.array;

import java.util.Arrays;

public class 检查是否区域内所有整数都被覆盖 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        sort(ranges, 0, ranges.length - 1);
        for(int i = 0; i < ranges.length; i++) {
            if(left>=ranges[i][0] && left <= ranges[i][1]) {
                if(ranges[i][1] >= right) {
                    return true;
                }else {
                    left = ranges[i][1] + 1;
                }
            }
        }
        return false;
    }

    public void sort(int[][] ranges, int start, int end) {
        if(start >= end) return;
        int left = start;
        int right = end;
        int[] m = ranges[left];
        while (left < right) {
            while (left < right && ranges[right][0] >= m[0]) right--;
            ranges[left] = ranges[right];
            while (left < right && ranges[left][0] <= m[0]) left++;
            ranges[right] = ranges[left];
        }
        ranges[left] = m;
        sort(ranges, start, left - 1);
        sort(ranges, left + 1, end);
    }
}
