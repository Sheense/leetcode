package sheen.leetcode.array;

import sheen.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * @Classname 螺旋矩阵IV
 * @Date 2022/7/3 10:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 螺旋矩阵IV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(res[i], - 1);
        }
        int i = 0;
        int j = 0;

        while (head != null) {
            while (j < n && head != null && res[i][j] == -1) {
                res[i][j] = head.val;
                head = head.next;
                j++;
            }
            j--;
            i++;
            while (i < m && head != null && res[i][j] == -1) {
                res[i][j] = head.val;
                head = head.next;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && head != null && res[i][j] == -1) {
                res[i][j] = head.val;
                head = head.next;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && head != null && res[i][j] == -1) {
                res[i][j] = head.val;
                head = head.next;
                i--;
            }
            j++;
            i++;
        }
        return res;
    }
}
