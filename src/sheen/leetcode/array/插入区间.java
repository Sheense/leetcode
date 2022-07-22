package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;
        sort(0, newIntervals.length-1, newIntervals);
        List<int[]> list= new ArrayList<>();
        for(int i=0;i<newIntervals.length;i++) {
            if(list.size() == 0) {
                list.add(newIntervals[i]);
            }else {
                int[] item = list.get(list.size()-1);
                if(item[1]<newIntervals[i][0]) {
                    list.add(newIntervals[i]);
                }else {
                    item[0] = Math.min(item[0], newIntervals[i][0]);
                    item[1] = Math.max(item[1], newIntervals[i][1]);
                    list.add(item);
                }
            }
        }
        int [][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void sort(int start, int end, int[][] newIntervals) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int[] mid = newIntervals[start];
        while(left<right) {
            while(left<right&&newIntervals[right][0] >= mid[0]) right--;
            newIntervals[left] = newIntervals[right];
            while(left<right&&newIntervals[left][0] <= mid[0]) left++;
            newIntervals[right] = newIntervals[left];
        }
        newIntervals[left] = mid;
        sort(start, left-1, newIntervals);
        sort(left+1, end, newIntervals);
    }
}
