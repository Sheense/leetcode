package sheen.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 最常见的单词
 * @Date 2022/4/17 1:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < banned.length; i++) set.add(banned[i]);
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace(".", " ");
        paragraph = paragraph.replace("?", " ");
        paragraph = paragraph.replace("!", " ");
        paragraph = paragraph.replace("、", " ");
        paragraph = paragraph.replace(";", " ");
        paragraph = paragraph.replace("'", " ");
        paragraph = paragraph.toLowerCase();
        String[] strings = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        }

        int max = 0;
        String res = "";
        for(String str : map.keySet()) {
            if(map.get(str) > max && !set.contains(str) && !str.equals(" ") && !str.equals(""))  {
                res = str;
                max = map.get(str);
            }
        }

        return res;
    }
}
