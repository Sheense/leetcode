package sheen.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 单词距离 {
    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            map.computeIfAbsent(words[i], x -> new ArrayList<>()).add(i);
        }
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<l1.size();i++) {
            int left = 0;
            int right = l2.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (l2.get(mid) >= l1.get(i)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left<l2.size()) {
                min = Math.min(min, Math.abs(l2.get(left) - l1.get(i)));
            }
            if (right >= 0) {
                min = Math.min(min, Math.abs(l2.get(right) - l1.get(i)));
            }
        }
        return min;
    }
}
