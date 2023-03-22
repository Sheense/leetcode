package sheen.leetcode.sort;

import java.util.Map;

import java.util.HashMap;

/**
 * @Classname 自定义字符串排序
 * @Date 2022/11/13 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 自定义字符串排序 {
    public String customSortString(String order, String s) {
        int[] sort = new int[order.length()];
        String s1 = "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                sort[map.get(s.charAt(i))]++;
            }else {
                s1 += s.charAt(i);
            }
        }

        for(int i = 0; i < sort.length; i++) {
            for(int j = 0; j < sort[i]; j++) {
                s1 += order.charAt(i);
            }
        }

        return s1;
    }
}
