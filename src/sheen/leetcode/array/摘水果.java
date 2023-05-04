package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 摘水果
 * @Date 2021/12/12 11:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 摘水果 {
    public static void main(String[] args) {
        摘水果 s = new 摘水果();
        System.out.println(s.maxTotalFruits(new int[][]{{2,8},{6,3},{8,6}}, 5, 4));
        System.out.println(s.maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4));
        System.out.println(s.maxTotalFruits(new int[][]{{0,3},{6,4},{8,5}}, 3, 2));
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] pre = new int[Math.max(fruits[fruits.length - 1][0], startPos) + 1];
        int j = 0;
        for(int i = 0; i < pre.length; i++) {
            if(j < fruits.length && fruits[j][0] == i) {
                pre[i] = fruits[j][1];
                j++;
            }

            if(i > 0) {
                pre[i] += pre[i - 1];
            }
        }
        int res = 0;
        for(int i = startPos; i < pre.length && i <= startPos + k; i++) {
            int len = k - (i - startPos);
            int start = i - len;
            if(start >= startPos) {
                start = startPos;
            }

            if(start < 0) {
                start = 0;
            }

            res = Math.max(res, (start == 0 ? pre[i] : pre[i] - pre[start - 1]));
        }

        for (int i = startPos; i >= 0 && startPos - k <= i; i--) {
            int len = k - (startPos - i);
            int end = i + len;
            if(end <= startPos) {
                end = startPos;
            }

            if(end >= pre.length) {
                end = pre.length - 1;
            }
            res = Math.max(res, (i == 0 ? pre[end] : pre[end] - pre[i - 1]));
        }

        return res;
    }
}
