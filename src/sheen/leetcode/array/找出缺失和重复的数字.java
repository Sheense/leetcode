package sheen.leetcode.array;

/**
 * @Classname 找出缺失和重复的数字
 * @Date 2024/5/31 00:23
 * @Created by sheen
 * @Description TODO
 */
public class 找出缺失和重复的数字 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] arr = new int[grid.length * grid[0].length + 1];
        for(int[] g : grid) {
            for(int v : g) {
                arr[v]++;
            }
        }

        int[] res = new int[2];
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] == 2) {
                res[0] = i;
            }

            if (arr[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}
