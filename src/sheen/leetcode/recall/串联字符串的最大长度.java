package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 串联字符串的最大长度 {

    public static void main(String[] args) {
        串联字符串的最大长度 s = new 串联字符串的最大长度();
        System.out.println(s.maxLength(List.of("un","iq","ue")));
    }
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        List<Integer> len = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int item = 0;
            boolean flag = true;
            for(int j = 0 ; j < arr.get(i).length(); j++) {
                int q = 1<<(arr.get(i).charAt(j) - 'a');
                if((q ^ item) != (q + item)) {
                    flag = false;
                    break;
                }
                item ^= q;
            }
            if(flag) {
                list.add(item);
                len.add(arr.get(i).length());
            }
        }
        if(list.size() == 0) return  0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        return recall(0, map, list, len, 0);
    }

    public int recall(int index, Map<Integer, Map<Integer, Integer>> map, List<Integer> arr, List<Integer> len, int maxLen) {

        Map<Integer, Integer> item = new HashMap<>();
        item.put(arr.get(index), len.get(index));
        maxLen = Math.max(maxLen, len.get(index));
        for(int i = index +1; i<arr.size(); i++) {
            if(!map.containsKey(i)) {
                int r = recall(i, map, arr, len, maxLen);
                maxLen = Math.max(maxLen, r);
            }
            if((arr.get(index) | arr.get(i) ) == arr.get(index) + arr.get(i)) {
                Map<Integer, Integer> m = map.get(i);
                for(int key : m.keySet()) {
                    if((key | arr.get(index)) == key + arr.get(index)) {
                        item.put(key + arr.get(index), m.get(key) + len.get(index));
                        maxLen = Math.max(m.get(key) + len.get(index), maxLen);
                    }
                }
            }
        }
        map.put(index, item);
        return maxLen;
    }
}
