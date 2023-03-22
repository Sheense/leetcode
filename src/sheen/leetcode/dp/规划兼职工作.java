package sheen.leetcode.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 规划兼职工作
 * @Date 2022/10/22 3:58 下午
 * @Created by sheen
 * @Description TODO
 */
public class 规划兼职工作 {
    public static void main(String[] args) {
        规划兼职工作 s = new 规划兼职工作();
        System.out.println(s.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++) {
            list.add(new int[]{startTime[i], endTime[i], profit[i]});
        }

        Collections.sort(list, (x1, x2) -> x1[1] - x2[1]);
        int[] dp = new int[startTime.length + 1];
        for(int i = 1; i < dp.length; i++) {
            int index = search(0, i - 1, list, list.get(i - 1)[0]);
            dp[i] = Math.max(dp[i - 1], dp[index + 1] + list.get(i - 1)[2]);
        }
        return dp[dp.length - 1];
    }

    public int search(int left, int right, List<int[]> list, int target) {
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(list.get(mid)[1] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
}
