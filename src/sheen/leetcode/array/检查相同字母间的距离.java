package sheen.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 检查相同字母间的距离
 * @Date 2022/9/4 4:17 下午
 * @Created by sheen
 * @Description TODO
 */
public class 检查相同字母间的距离 {
    public static void main(String[] args) {
        检查相同字母间的距离 s = new 检查相同字母间的距离();
        System.out.println(s.checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            int j = 0;
            int start = -1;
            while (j < s.length()) {
                while (j < s.length() && s.charAt(j) != ('a' + i)) {
                    j++;
                }
                if(start != -1 && j < s.length() && s.charAt(j) == (char)('a' + i)) {
                    map.computeIfAbsent((char)('a' + i), x -> new HashSet<>()).add(j - start - 1);
                }
                start = j;
                j++;
            }
        }

        for(int i = 0 ; i < distance.length; i++) {
            char c = (char) ('a' + i);
            if(map.containsKey(c)) {
                Set<Integer> set = map.get(c);
                if(set.size() > 1) {
                    return false;
                }else if(!set.contains(distance[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
