package sheen.leetcode.array;

import java.util.Arrays;

public class 人口最多的年份 {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];
        for(int i = 0;i<logs.length;i++) {
            for(int j = logs[i][0]; j<logs[i][1];j++) {
                arr[j - 1950]++;
            }
        }
        int max = 1950;
        int maxvalue = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > maxvalue) {
                max = i + 1950;
                maxvalue = arr[i];
            }
        }
        return max;
    }
}
