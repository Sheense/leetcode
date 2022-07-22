package sheen.leetcode.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Classname 高度检查器
 * @Date 2022/6/13 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 高度检查器 {
    public int heightChecker(int[] heights) {
        int[] copy = new int[heights.length];
        for(int i = 0; i < copy.length; i++) {
            copy[i] = heights[i];
        }

        Arrays.sort(copy);
        int res = 0;
        for(int i = 0; i < copy.length; i++) {
            if(copy[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
