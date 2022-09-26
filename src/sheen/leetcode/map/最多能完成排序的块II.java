package sheen.leetcode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Classname 最多能完成排序的块II
 * @Date 2022/8/13 1:34 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最多能完成排序的块II {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.get(arr[i]) == 0) {
                map.remove(arr[i]);
            }

            map.put(newArr[i], map.getOrDefault(newArr[i], 0) - 1);
            if(map.get(newArr[i]) == 0) {
                map.remove(newArr[i]);
            }
            if(map.isEmpty()) {
                res++;
            }
        }
        return res;
    }
}
