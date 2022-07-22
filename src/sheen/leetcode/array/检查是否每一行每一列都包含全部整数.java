package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 检查是否每一行每一列都包含全部整数
 * @Date 2022/1/9 11:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检查是否每一行每一列都包含全部整数 {
    public static void main(String[] args) {
        检查是否每一行每一列都包含全部整数 s = new 检查是否每一行每一列都包含全部整数();
        System.out.println(s.checkValid(new int[][] {{1,2,3},{3,1,2}, {2,3,1}}));
    }
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            Set<Integer> a = new HashSet<>();
            Set<Integer> b = new HashSet<>();

            for(int j = 0; j < n; j++) {
                a.add(matrix[i][j]);
                b.add(matrix[j][i]);
            }
            if(a.size() != n || b.size() != n) {
                return false;
            }
        }

        return true;
    }
}
