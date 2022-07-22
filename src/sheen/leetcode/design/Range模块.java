package sheen.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname Range模块
 * @Date 2022/6/20 12:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class Range模块 {
    public static void main(String[] args) {
        RangeModule s = new RangeModule();
        /*s.addRange(10,180);
        s.addRange(150,200);
        s.addRange(250,500);
        s.queryRange(50,100);
        s.queryRange(180, 300);
        s.queryRange(600, 1000);
        s.removeRange(50, 150);
        s.queryRange(50, 100);*/
        /*s.addRange(10, 20);
        s.removeRange(14, 16);
        s.queryRange(10, 14);
        s.queryRange(13, 15);
        s.queryRange(16, 17);*/
        /*s.addRange(44,53);
        s.addRange(69,89);
        s.removeRange(86,91);
        s.addRange(87,94);
        s.removeRange(34,52);
        s.addRange(1, 59);
        s.removeRange(62, 96);
        s.removeRange(34,83);*/
        s.addRange(10, 20);
        s.removeRange(14, 16);
    }
    static class RangeModule {
        private TreeMap<Integer, Integer> map;
        public RangeModule() {
            this.map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            if(entry != null) {
                if(entry.getValue() >= left) {
                    map.remove(entry.getKey());
                    left = entry.getKey();
                    right = Math.max(entry.getValue(), right);
                }
            }

            while (map.floorKey(right) != null && map.floorEntry(right).getValue() >= left) {
                entry = map.floorEntry(right);
                map.remove(entry.getKey());
                right = Math.max(entry.getValue(), right);
            }

            map.put(left, right);
        }
        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            if(entry == null) return false;
            return entry.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.lowerEntry(left);
            if(entry != null && entry.getValue() >= left) {
                if(entry.getValue() > right) {
                    map.put(right, entry.getValue());
                    map.put(entry.getKey(), left);
                    return;
                }
                map.put(entry.getKey(), left);

            }

            while (map.lowerKey(right) != null && map.lowerEntry(right).getValue() > left) {
                entry = map.lowerEntry(right);
                map.remove(entry.getKey());
                if(entry.getValue() > right) {
                    map.put(right, entry.getValue());
                }
            }
        }
    }
}
