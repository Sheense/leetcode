package sheen.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 小时间差
 * @Date 2022/1/18 12:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 小时间差 {
    public int findMinDifference(List<String> timePoints) {
        int day = 24 * 60;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < timePoints.size(); i++) {
            String[] strs = timePoints.get(i).split(":");
            list.add(Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]));
        }
        Collections.sort(list);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++) {
            res = Math.min(res, list.get(i + 1) - list.get(i));
        }
        res = Math.min(res, list.get(0) + day - list.get(list.size() - 1));
        return res;
    }
}
