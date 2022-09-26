package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 最大相等频率
 * @Date 2022/8/18 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大相等频率 {
    public static void main(String[] args) {
        最大相等频率 s = new 最大相等频率();
        System.out.println(s.maxEqualFreq(new int[]{2,2,1,1,5,3,3,5}));
    }
    public int maxEqualFreq(int[] nums) {
        TreeMap<Integer, Set<Integer>> mapList = new TreeMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > 1) {
                Set<Integer> set = mapList.get(map.get(nums[i]) - 1);
                set.remove(nums[i]);
                if(set.size() == 0) {
                    mapList.remove(map.get(nums[i]) - 1);
                }
            }
            mapList.computeIfAbsent(map.get(nums[i]), x -> new HashSet<>()).add(nums[i]);
            if(mapList.size() == 2) {
                if(mapList.containsKey(1) && mapList.get(1).size() == 1) {
                    res = i;
                }else {
                    int firstKey = mapList.firstKey();
                    int lastKey = mapList.lastKey();
                    if(lastKey - 1 == firstKey && mapList.get(lastKey).size() == 1) {
                        res = i;
                    }
                }
            }else if(mapList.size() == 1 && mapList.containsKey(1)) {
                res = i;
            }else if(mapList.size() == 1 && mapList.get(mapList.firstKey()).size() == 1) {
                res = i;
            }
        }
        return res + 1;
    }
}
