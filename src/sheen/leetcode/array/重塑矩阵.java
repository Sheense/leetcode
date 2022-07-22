package sheen.leetcode.array;

public class 重塑矩阵 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length*nums[0].length!=r*c) return nums;
        int [][] res = new int[r][c];
        int index =0;
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums[i].length;j++) {
                res[index/c][index%c] = nums[i][j];
                index++;
            }
        }
        return res;
    }
}
