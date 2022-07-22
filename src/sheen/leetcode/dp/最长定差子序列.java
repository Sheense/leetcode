package sheen.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 最长定差子序列
 * @Date 2021/11/5 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长定差子序列 {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int key = arr[i] - difference;
            if(map.containsKey(arr[i])) {
                map.put(arr[i], Math.max(map.get(arr[i]),  map.getOrDefault(key, 0) + 1));
            }else {
                map.put(arr[i], map.getOrDefault(key, 0) + 1);
            }
            max = Math.max(max, map.get(arr[i]));
        }
        return max;
    }
}
