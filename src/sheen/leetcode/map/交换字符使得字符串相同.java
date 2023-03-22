package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 交换字符使得字符串相同
 * @Date 2023/2/25 2:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 交换字符使得字符串相同 {
    public static void main(String[] args) {
        交换字符使得字符串相同 s = new 交换字符使得字符串相同();
        System.out.println(s.minimumSwap("xx", "yy"));
    }
    public int minimumSwap(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                String key = s1.charAt(i) + "" + s2.charAt(i);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int res = 0;
        for(String key : new ArrayList<>(map.keySet())) {
            res += map.get(key) / 2;
            if(map.get(key) % 2 == 0) {
                map.remove(key);
            }else {
                map.put(key, 1);
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        for(String key : keys) {
            if(map.containsKey(key)) {
                String newKey = key.charAt(1) + "" + key.charAt(0);
                if(map.containsKey(newKey)) {
                    res += 2;
                    map.remove(newKey);
                    map.remove(key);
                }
            }
        }
        if(map.size() > 0) {
            return -1;
        }

        return res;
    }
}
