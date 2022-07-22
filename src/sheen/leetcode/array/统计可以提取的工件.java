package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 统计可以提取的工件
 * @Date 2022/3/13 4:11 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计可以提取的工件 {
    public static void main(String[] args) {
        统计可以提取的工件 s = new 统计可以提取的工件();
        System.out.println(s.digArtifacts(8, new int[][]{{3,2,6,2},{2,7,3,7},{1,2,1,5},{4,4,4,7},{0,0,3,0},{5,6,7,6},{0,1,0,3},{6,0,7,1},{2,1,4,1},{2,4,2,4},{5,5,5,5},{5,3,7,3},{1,1,1,1},{0,7,1,7}}, new int[][] {{0,0},{0,1},{0,3},{0,4},{0,5},{0,6},{1,4},{1,6},{2,2},{2,4},{2,5},{3,0},{3,1},{3,2},{3,5},{3,6},{4,0},{4,1},{4,2},{4,6},{5,1},{5,2},{5,4},{5,7},{6,0},{6,3},{6,4},{6,6},{7,5}}));




    }
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<Integer> digSet = new HashSet<>();
        for(int i = 0; i < dig.length; i++) {
            digSet.add(dig[i][0] * n + dig[i][1]);
        }
        int res = 0;
        for(int i = 0; i < artifacts.length; i++) {
            int[] left = new int[]{artifacts[i][0], artifacts[i][1]};
            int[] right = new int[]{artifacts[i][2], artifacts[i][3]};
            int leftNum = left[0] * n + left[1];
            int rightNum = right[0] * n + right[1];
            if(!digSet.contains(leftNum) || !digSet.contains(rightNum)) {
                continue;
            }

            int count = 1;
            boolean flag = true;
            while (left[1] + count <= right[1]) {
                int num = left[0] * n + left[1] + count;
                if(!digSet.contains(num)) {
                    flag = false;
                    break;
                }
                count++;
            }

            count = 1;
            while (left[0] + count <= right[0]) {
                int num = (left[0] + count) * n + left[1];
                if(!digSet.contains(num)) {
                    flag = false;
                    break;
                }
                count++;
            }
            if(!flag) continue;
            res ++;
        }
        return res;
    }
}
