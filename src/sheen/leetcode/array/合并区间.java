package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

public class 合并区间 {

    public static void main(String[] args) {
        合并区间 s = new 合并区间();
        int[][] intervals = {
                            {1,4},
                            {2,3}

        };
        ArrayUtils.print2(s.merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][0];
        sort(intervals, 0, intervals.length-1);
        int i = 1;
        int index = 0;
        while(i<intervals.length) {
            if(intervals[index][1]>=intervals[i][0]) {
                intervals[index][1] = Math.max(intervals[i][1],intervals[index][1]);
            }else {
                index++;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
            i++;
        }
        int[][] res = new int[index+1][2];
        for(int j=0;j<=index;j++) {
            res[j] = intervals[j];
        }
        return res;
    }

    public void sort(int [][] arr, int start, int end) {
        if(start>=end) return ;
        int left = start;
        int right = end;
        int[] key = arr[start];
        while(left<right) {
            while(left<right&&arr[right][0]>=key[0])  right--;
            arr[left] = arr[right];
            while(left<right&&arr[left][0]<=key[0]) left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        sort(arr, start,left-1);
        sort(arr, left+1, end);
    }
}
