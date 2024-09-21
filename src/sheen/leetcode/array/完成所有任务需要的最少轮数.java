package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 完成所有任务需要的最少轮数
 * @Date 2024/5/14 00:23
 * @Created by sheen
 * @Description TODO
 */
public class 完成所有任务需要的最少轮数 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int v : tasks) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        int res = 0;
        for(int num : map.values()) {
            if (num == 1) {
                return -1;
            }

            int yu = num % 3;
            if(yu == 0) {
                res += num / 3;
            } else if(yu == 1) {
                res += 2;
                res += (num - 3) / 3;
            } else {
                res ++;
                res += num / 3;
            }
        }
        return res;
    }
}
