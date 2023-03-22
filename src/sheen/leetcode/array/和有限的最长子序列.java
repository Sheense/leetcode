package sheen.leetcode.array;

import jdk.nashorn.api.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname 和有限的最长子序列
 * @Date 2023/3/17 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 和有限的最长子序列 {
    public static void main(String[] args) {
        和有限的最长子序列 s= new 和有限的最长子序列();
        System.out.println(s.answerQueries(new int[]{2,3,4,5}, new int[]{1}));
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] pre = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                pre[i] = nums[i];
            }else {
                pre[i] = nums[i] + pre[i - 1];
            }
            map.put(pre[i], i);
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int max = 0;
            for(int j = 0; j < pre.length; j++) {
                if(pre[j] > queries[i]) {
                    Integer key = map.floorKey(pre[j] - queries[i]);
                    if(key != null && pre[j] - key <= queries[i]) {
                        max = Math.max(max, j - map.get(key));
                    }
                }else {
                    max = Math.max(max, j + 1);
                }
            }
            res[i] = max;
        }
        return res;
    }
}
