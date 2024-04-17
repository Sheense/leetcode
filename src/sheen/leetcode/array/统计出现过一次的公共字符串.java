package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 统计出现过一次的公共字符串
 * @Date 2024/1/12 00:05
 * @Created by sheen
 * @Description TODO
 */
public class 统计出现过一次的公共字符串 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < words1.length; i++) {
            map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
        }
        for(int i = 0; i < words2.length; i++) {
            map2.put(words2[i], map2.getOrDefault(words2[i], 0) + 1);
        }
        int res = 0;
        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey()) && map2.get(entry.getKey()) == 1 && entry.getValue() == 1){
                res ++;
            }
        }
        return res;
    }
}
