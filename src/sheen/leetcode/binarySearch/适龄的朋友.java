package sheen.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 适龄的朋友
 * @Date 2021/12/27 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 适龄的朋友 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < ages.length; i++) {
            if(ages[i] <= 14) continue;
            double v = 0.5 * ages[i] + 7;
            while (ages[left] <= v) {
                left ++;
            }
            while (right + 1 < ages.length && ages[right + 1] <= ages[i]) {
                right ++;
            }
            res += right - left;
        }
        return res;
    }
}
