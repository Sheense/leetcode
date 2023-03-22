package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 表现良好的最长时间段
 * @Date 2023/2/14 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 表现良好的最长时间段 {

    public static void main(String[] args) {
        表现良好的最长时间段 s = new 表现良好的最长时间段();
        System.out.println(s.longestWPI(new int[]{9, 6, 6}));
    }
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int pre = 0;
        for(int i = 0; i < hours.length; i++) {
            if(i == 0) {
                pre = hours[0] > 8 ? 1 : -1;
            }else {
                if(hours[i] > 8) {
                    pre++;
                }else {
                    pre--;
                }
            }

            if(pre > 0) {
                res = i + 1;
            }else {
                if(map.containsKey(pre - 1)) {
                    res = Math.max(i - map.get(pre - 1), res);
                }
            }

            if(!map.containsKey(pre)) {
                map.put(pre, i);
            }

        }

        return res;
    }
}
