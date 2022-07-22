package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 数组中第K个独一无二的字符串
 * @Date 2021/10/30 11:22 下午
 * @Created by sheen
 * @Description TODO
 */
public class 数组中第K个独一无二的字符串 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int i = 0 ; i < arr.length; i++) {
            if(map.get(arr[i]) == 1) {
                k --;
            }
            if(k == 0) {
                return arr[i];
            }
        }
        return "";
    }
}
