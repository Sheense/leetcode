package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;

public class 查询差绝对值的最小值 {
    public static void main(String[] args) {
        查询差绝对值的最小值 s = new 查询差绝对值的最小值();
        ArrayUtils.print(s.minDifference(new int[]{1,3,4,8},
                new int[][]{{0,1},{1,2},{2,3},{0,3}}));
    }
    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] arr = new int[nums.length][100];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = new int[100];
            if(i > 0) {
                for(int j = 0; j < 100;j++) {
                    arr[i][j] = arr[i-1][j];
                }
            }
            arr[i][nums[i]-1]++;
        }

        int[] res = new int[queries.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        for(int i = 0; i < queries.length; i++) {
            int[] item = new int[100];
            if(queries[i][0] == 0) {
                item = arr[queries[i][1]];
            }else {
                for(int j = 0; j < item.length; j++) {
                    item[j] = arr[queries[i][1]][j] - arr[queries[i][0]-1][j];
                }
            }

            int pre = -1;
            for(int j = 0; j<item.length; j++) {
                if(item[j] > 0) {
                    if(pre != -1) {
                        res[i] = Math.min(res[i], j - pre);
                    }
                    pre = j;
                }

            }
            if(res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }
}
