package sheen.leetcode.segmentArray;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname 我的日程安排表II
 * @Date 2022/7/19 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 我的日程安排表II {
    static class MyCalendarTwo {
        private TreeMap<Integer, Integer> map = new TreeMap<>();
        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int maxBook = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                maxBook += entry.getValue();
                if(maxBook > 2) {
                    map.put(start, map.getOrDefault(start, 0) - 1);
                    map.put(end, map.getOrDefault(end, 0) + 1);
                    return false;
                }
            }

            return true;
        }


    }
}
