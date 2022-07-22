package sheen.leetcode.recall;

import java.util.Arrays;

/**
 * @Classname 最优除法
 * @Date 2022/2/27 1:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最优除法 {
    public static void main(String[] args) {
        最优除法 s=  new 最优除法();
        System.out.println(s.optimalDivision(new int[]{1000,100,10,2}));
    }
    public String optimalDivision(int[] nums) {
        String[][] max = new String[nums.length][nums.length];
        String[][] min = new String[nums.length][nums.length];
        double[][] maxV = new double[nums.length][nums.length];
        double[][] minV = new double[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(maxV[i], Integer.MIN_VALUE);
            Arrays.fill(minV[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                for(int j = 0; j < nums.length; j++) {
                    maxV[j][j] = nums[j];
                    minV[j][j] = nums[j];
                    max[j][j] = String.valueOf(nums[j]);
                    min[j][j] = String.valueOf(nums[j]);
                }
            } else if(i == 1) {
                for(int j = 0; j < nums.length - 1; j++) {
                    maxV[j][j + i] = (double) nums[j] / nums[j + i];
                    minV[j][j + i] = (double) nums[j] / nums[j + i];
                    max[j][j + i] = nums[j] + "/" + nums[j + i];
                    min[j][j + i] = nums[j] + "/" + nums[j + i];
                }
            }else {
                for(int j = 0; j + i < nums.length; j++) {
                    for(int z = j; z < j + i; z++) {
                        double max1 = maxV[j][z] / minV[z + 1][j + i];
                        double min1 = minV[j][z] / maxV[z + 1][j + i];
                        if(max1 > maxV[j][j+i]) {
                            maxV[j][j+i] = max1;
                            max[j][j+i] = max[j][z] + "/" + (z + 1 == j+i ? min[z+1][j + i] : "(" + min[z+1][j+i] + ")");
                        }

                        if(min1 < minV[j][j+i]) {
                            minV[j][j+i] = min1;
                            min[j][j+i] = min[j][z] + "/" + (z + 1 == j+i ? max[z+1][j + i] : "(" + max[z+1][j+i] + ")");
                        }
                    }
                }
            }
        }
        return max[0][nums.length - 1];
    }
}
