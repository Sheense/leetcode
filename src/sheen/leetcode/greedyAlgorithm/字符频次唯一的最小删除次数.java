package sheen.leetcode.greedyAlgorithm;

import java.util.*;

public class 字符频次唯一的最小删除次数 {

    public static void main(String[] args) {

    }
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i=0;i<list.size();i++) {
            if(set.contains(list.get(i))) {
                int n = list.get(i);
                while(n!=0&&set.contains(n)) {
                    n--;
                    res++;
                }
                if(n!=0) set.add(n);
            }else set.add(list.get(i));
        }
        return res;
    }
}
