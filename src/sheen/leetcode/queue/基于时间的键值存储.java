package sheen.leetcode.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class 基于时间的键值存储 {
    class TimeMap {

        Map<String, TreeMap<Integer, String>> map = new HashMap<>();
        /** Initialize your data structure here. */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            Map<Integer, String > m = map.computeIfAbsent(key, x -> new TreeMap<>());
            m.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) return "";
            TreeMap<Integer, String> m = map.get(key);
            Integer time = m.floorKey(timestamp);
            if(time == null) return "";
            return m.get(time);
        }
    }
}
