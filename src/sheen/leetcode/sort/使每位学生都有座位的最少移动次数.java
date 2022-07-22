package sheen.leetcode.sort;

import java.util.Arrays;

/**
 * @Classname 使每位学生都有座位的最少移动次数
 * @Date 2021/10/16 11:23 下午
 * @Created by sheen
 * @Description TODO
 */
public class 使每位学生都有座位的最少移动次数 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for(int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
