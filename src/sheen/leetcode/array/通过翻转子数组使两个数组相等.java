package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 通过翻转子数组使两个数组相等
 * @Date 2022/8/24 12:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class 通过翻转子数组使两个数组相等 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> tMap = new HashMap<>();
        Map<Integer, Integer> arrMap = new HashMap<>();
        for(int i = 0; i < target.length; i++) {
            tMap.put(target[i], tMap.getOrDefault(target[i], 0) + 1);
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }
        for(int key : tMap.keySet()) {
            if(tMap.get(key) != arrMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }
}
