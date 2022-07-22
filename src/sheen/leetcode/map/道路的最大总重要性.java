package sheen.leetcode.map;

import java.util.Arrays;

/**
 * @Classname 道路的最大总重要性
 * @Date 2022/5/28 10:43 下午
 * @Created by sheen
 * @Description TODO
 */
public class 道路的最大总重要性 {
    public static void main(String[] args) {
        道路的最大总重要性 s = new 道路的最大总重要性();
        System.out.println(s.maximumImportance(5, new int[][] {{0, 1}}));
    }
    public long maximumImportance(int n, int[][] roads) {
        int[][] arr = new int[n][2];
        for(int i = 0; i < arr.length; i++) {
            arr[i][1] = -1;
        }
        for(int i = 0; i < roads.length; i++) {
            arr[roads[i][0]][0] ++;
            arr[roads[i][0]][1] = roads[i][0];
            arr[roads[i][1]][0] ++;
            arr[roads[i][1]][1] = roads[i][1];
        }

        Arrays.sort(arr, (x, y) -> y[0] - x[0]);

        int[] du = new int[n];
        int start = n;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][1] == -1) break;
            du[arr[i][1]] = start--;
        }

        long res = 0;
        for(int i = 0; i < roads.length; i++) {
            res += du[roads[i][0]] + du[roads[i][1]];
        }

        return res;
    }
}
