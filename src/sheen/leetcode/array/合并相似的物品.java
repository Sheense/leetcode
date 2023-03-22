package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 合并相似的物品
 * @Date 2023/2/28 12:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 合并相似的物品 {
    public static void main(String[] args) {
        合并相似的物品 s = new 合并相似的物品();
        int[][] a = {{1,1},{4,5},{3,8}};
        int[][] b = {{3,1}, {1, 5}};
        System.out.println(s.mergeSimilarItems(a, b));
    }
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], map.getOrDefault(items1[i][0], 0) + items1[i][1]);
        }

        for(int i = 0; i < items2.length; i++) {
            map.put(items2[i][0], map.getOrDefault(items2[i][0], 0) + items2[i][1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int v : map.keySet()) {
            res.add(Arrays.asList(v, map.get(v)));
        }

        Collections.sort(res, (x, y) -> x.get(0) - y.get(0));
        return res;
    }
}
