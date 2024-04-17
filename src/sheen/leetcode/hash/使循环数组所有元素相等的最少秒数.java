package sheen.leetcode.hash;

import java.util.*;

/**
 * @Classname 使循环数组所有元素相等的最少秒数
 * @Date 2024/1/30 00:10
 * @Created by sheen
 * @Description TODO
 */
public class 使循环数组所有元素相等的最少秒数 {
    public static void main(String[] args) {
        使循环数组所有元素相等的最少秒数 s = new 使循环数组所有元素相等的最少秒数();
        System.out.println(s.minimumSeconds(Arrays.asList(15,11,3)));
    }
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int res = nums.size();

        for(List<Integer> list : map.values()) {
            int mx = list.get(0) + nums.size() - list.get(list.size() - 1);
            for(int i = 1; i < list.size(); i++) {
                mx = Math.max(mx, list.get(i) - list.get(i - 1));
            }
            res = Math.min(res, mx / 2);
        }

        return res;
    }
}
