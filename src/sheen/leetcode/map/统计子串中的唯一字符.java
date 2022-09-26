package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 统计子串中的唯一字符
 * @Date 2022/9/6 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计子串中的唯一字符 {
    public static void main(String[] args) {
        统计子串中的唯一字符 s = new 统计子串中的唯一字符();
        System.out.println(s.uniqueLetterString("LEETCODE"));
    }
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.computeIfAbsent(c, x -> new ArrayList<>()).add(-1);
            }
            map.get(c).add(i);
        }

        int res = 0;
        for(char c : map.keySet()) {
            List<Integer> list = map.get(c);
            list.add(s.length());
            for(int i = 1; i < list.size() - 1; i++) {
                res += (list.get(i) - list.get(i - 1)) * (list.get(i+1) - list.get(i));
            }
        }
        return res;
    }


}
