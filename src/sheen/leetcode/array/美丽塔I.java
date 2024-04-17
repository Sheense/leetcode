package sheen.leetcode.array;

import java.util.List;

/**
 * @Classname 美丽塔I
 * @Date 2024/1/24 00:31
 * @Created by sheen
 * @Description TODO
 */
public class 美丽塔I {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long max = 0;
        for(int i = 0; i < maxHeights.size(); i++) {
            max = Math.max(max, left(i, maxHeights) + right(i, maxHeights) + maxHeights.get(i));
        }
        return max;
    }
    public long right(int i, List<Integer> maxHeights) {
        if(i == maxHeights.size() - 1) {
            return 0;
        }
        int pre = maxHeights.get(i);
        long res = 0;
        while (i + 1 < maxHeights.size()) {
            if(maxHeights.get(i + 1) <= pre) {
                res += maxHeights.get(i + 1);
                pre = maxHeights.get(i + 1);
            }else {
                res += pre;
            }
            i++;
        }
        return res;
    }

    public long left(int i, List<Integer> maxHeights) {
        if(i == 0) {
            return 0;
        }
        int pre = maxHeights.get(i);
        long res = 0;
        while (i - 1 >= 0) {
            if(maxHeights.get(i - 1) <= pre) {
                res += maxHeights.get(i - 1);
                pre = maxHeights.get(i - 1);
            }else {
                res += pre;
            }
            i--;
        }
        return res;
    }
}
