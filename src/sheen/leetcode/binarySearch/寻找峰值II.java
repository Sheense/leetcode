package sheen.leetcode.binarySearch;

/**
 * @Classname 寻找峰值II
 * @Date 2023/12/19 01:10
 * @Created by sheen
 * @Description TODO
 */
public class 寻找峰值II {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0;
        int right = mat.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int max = mat[mid][0];
            int i = mid;
            int j = 0;
            for(int z = 0; z < mat[0].length; z++) {
                if(mat[i][z] > max) {
                    max = mat[i][j];
                    j = z;
                }
            }

            if(i - 1 >= 0 && mat[i - 1][j] > mat[i][j]) {
                right = mid - 1;
                continue;
            }

            if(i + 1 < mat.length && mat[i + 1][j] > mat[i][j]) {
                left = mid + 1;
                continue;
            }

            return new int[]{i, j};
        }
        return new int[]{};
    }
}
