package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname 重构2行二进制矩阵
 * @Date 2023/6/29 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重构2行二进制矩阵 {
    public static void main(String[] args) {
        重构2行二进制矩阵 s = new 重构2行二进制矩阵();
        System.out.println(s.reconstructMatrix(2, 1, new int[]{1, 1, 1}));
    }
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] arr = new int[2][colsum.length];

        for(int i = 0; i < colsum.length; i++) {
            if(colsum[i] == 2) {
                arr[0][i] = 1;
                arr[1][i] = 1;
                upper--;
                lower--;
                colsum[i] = 0;
            }

            if(upper < 0 || lower < 0) {
                return new ArrayList<>();
            }
        }

        if(upper > 0) {
            for(int i = 0; i < colsum.length; i++) {
                if(colsum[i] == 1) {
                    upper--;
                    arr[0][i] = 1;
                    colsum[i] = 0;
                }
                if(upper == 0) {
                    break;
                }
            }
        }

        if(lower > 0) {
            for(int i = 0; i < colsum.length; i++) {
                if(colsum[i] == 1) {
                    lower--;
                    arr[1][i] = 1;
                    colsum[i] = 0;
                }
                if(lower == 0) {
                    break;
                }
            }
        }
        boolean flag = true;
        for(int i = 0; i < colsum.length; i++) {
            if(colsum[i] > 0) {
                flag = false;
                break;
            }
        }
        if(!flag || upper > 0 || lower > 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}
