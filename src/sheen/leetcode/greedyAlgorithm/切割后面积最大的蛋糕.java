package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @Classname 切割后面积最大的蛋糕
 * @Date 2023/10/27 00:25
 * @Created by sheen
 * @Description TODO
 */
public class 切割后面积最大的蛋糕 {
    public static void main(String[] args) {
        切割后面积最大的蛋糕 s = new 切割后面积最大的蛋糕();
        System.out.println(s.maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int pre = 0;
        int maxH = 0;
        for(int i : horizontalCuts) {
            maxH = Math.max(maxH, i - pre);
            pre = i;
        }

        maxH = Math.max(maxH, h - pre);

        pre = 0;
        int maxW = 0;
        for(int i : verticalCuts) {
            maxW = Math.max(maxW, i - pre);
            pre = i;
        }

        maxW = Math.max(maxW, w - pre);

        return (int)((long) maxH * maxW % (Math.pow(10, 9) + 7));
    }
}
