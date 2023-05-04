package sheen.leetcode.剑指offer;

import java.util.Set;
import java.util.TreeMap;

/**
 * @Classname 值和下标之差都在给定的范围内
 * @Date 2023/3/23 4:00 下午
 * @Created by sheen
 * @Description TODO
 */
public class 值和下标之差都在给定的范围内 {
    public static void main(String[] args) {
        值和下标之差都在给定的范围内 s = new 值和下标之差都在给定的范围内();
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{2147483646,2147483647}, 3,3));
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1) {
            return false;
        }
        if(k == 0) {
            return false;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        TreeMap<Long, Integer> absCount = new TreeMap<>();
        int i = 0;
        while (i < nums.length) {
            if(i < k) {
                for(; i <= k && i < nums.length; i++) {
                    update(treeMap, absCount, true, nums[i]);
                }
            }else {
                int last = nums[i - k - 1];
                update(treeMap, absCount, false, last);
                update(treeMap, absCount, true, nums[i]);
                i++;
            }
            if(absCount.firstKey() <= t) {
                return true;
            }
        }
        return false;
    }

    public void update(TreeMap<Integer, Integer> treeMap, TreeMap<Long, Integer> absCount , boolean add, int key) {
        if(!add) {
            treeMap.put(key, treeMap.getOrDefault(key, 0) - 1);
            if(treeMap.get(key) == 0) {
                treeMap.remove(key);
                if(treeMap.floorKey(key) != null && treeMap.ceilingKey(key) != null) {
                    int floorKey = treeMap.floorKey(key);
                    int ceilingKey = treeMap.ceilingKey(key);
                    long abs = Math.abs((long)floorKey - ceilingKey);
                    absCount.put(abs, treeMap.get(ceilingKey) * treeMap.get(floorKey));
                }
            }

        }
        if(treeMap.ceilingKey(key) != null) {
            int ceilKey = treeMap.ceilingKey(key);
            int v = add ? treeMap.get(ceilKey) : -treeMap.get(ceilKey);
            long abs = Math.abs((long)key - ceilKey);
            absCount.put(abs, absCount.getOrDefault(abs, 0) + v);
        }
        if(treeMap.floorKey(key) != null) {
            int floorKey = treeMap.floorKey(key);
            long abs = Math.abs((long)key - floorKey);
            int v = add ? treeMap.get(floorKey) : -treeMap.get(floorKey);
            absCount.put(abs, absCount.getOrDefault(abs, 0) + v);
        }

        if(add) {
            treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
        }

    }
}
