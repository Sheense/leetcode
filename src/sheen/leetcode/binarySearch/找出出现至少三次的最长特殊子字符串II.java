package sheen.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 找出出现至少三次的最长特殊子字符串II
 * @Date 2024/5/30 00:33
 * @Created by sheen
 * @Description TODO
 */
public class 找出出现至少三次的最长特殊子字符串II {
    public static void main(String[] args) {
        找出出现至少三次的最长特殊子字符串II s = new 找出出现至少三次的最长特殊子字符串II();
        System.out.println(s.maximumLength("abcaba"));
    }
    public int maximumLength(String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int i = 0, j = 0;
        while (i < s.length()) {
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            map.computeIfAbsent((int)s.charAt(i), x -> new ArrayList<>()).add(j - i);
            i = j;
        }

        int res = -1;
        for(List<Integer> list : map.values()) {
            int left = 1;
            int right = s.length() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int count = 0;
                for(int len : list) {
                    if(len >= mid) {
                       count += len - mid + 1;
                    }
                }
                if (count >= 3) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

            res = Math.max(right, res);
        }

        return res == 0 ? -1 : res;
    }
}
