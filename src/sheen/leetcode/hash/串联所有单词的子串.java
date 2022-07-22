package sheen.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 串联所有单词的子串 {
    public static void main(String[] args) {
        串联所有单词的子串 s = new 串联所有单词的子串();
        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int wordLength = words[0].length();
        for(int i=0;i<words.length;i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int allLength = wordLength * words.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<=s.length() - allLength;i++) {
            Map<String, Integer> temp = new HashMap<>(map);
            int left = i;
            int right = i + wordLength;
            boolean flag = true;
            while (right <= i + allLength) {
                String t = s.substring(left, right);
                if(temp.containsKey(t) && temp.get(t) > 0) {
                    temp.put(t, temp.get(t) - 1);
                } else {
                    flag = false;
                    break;
                }
                left = right;
                right = left + wordLength;
            }
            if(flag) res.add(i);
        }
        return res;
    }
}
