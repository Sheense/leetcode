package sheen.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 参加考试的最大学生数
 * @Date 2023/12/26 00:18
 * @Created by sheen
 * @Description TODO
 */
public class 参加考试的最大学生数 {
    private Map<Integer, Integer> map = new HashMap<>();
    public int maxStudents(char[][] seats) {
        int n = seats[0].length;
        int mx = 0;
        for(int i = 0; i < (1 << n); i++) {
            mx = Math.max(mx, dp(i, seats.length - 1, seats));
        }
        return mx;
    }

    public int dp(int status, int row, char[][] seat) {
        int n = seat[0].length;
        int key = (row << n) + status;
        if(!map.containsKey(key)) {
            if(!isRight(status, seat[row], n)) {
                map.put(key, Integer.MIN_VALUE);
                return map.get(key);
            }
            int count = Integer.bitCount(status);
            if (row == 0) {
                map.put(key, count);
                return count;
            }
            int max = 0;
            for(int nextStatus = 0; nextStatus < (1 << n); nextStatus++) {
                if(isRight2(status, nextStatus, n)) {
                    max = Math.max(max, dp(nextStatus, row - 1, seat));
                }
            }

            map.put(key, count + max);
        }
        return map.get(key);
    }

    public boolean isRight2(int status, int nextStatus, int n) {
        for(int i = 0; i < n; i++) {
            if((status >> i & 1) == 1) {
                if(i > 0 && ((nextStatus >> (i - 1)) & 1) == 1) {
                    return false;
                }

                if(i < n - 1 && (nextStatus >> (i + 1) & 1) == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRight(int status, char[] seat, int n) {
        for(int i = 0; i < n; i++) {
            if(((status >> i) & 1) == 1) {
                if(seat[i] == '#') {
                    return false;
                }
                if(i > 0 && ((status >> (i - 1)) & 1) == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
