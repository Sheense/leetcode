package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.TreeMap;

/**
 * @Classname 蜡烛之间的盘子
 * @Date 2022/3/8 12:36 上午
 * @Created by sheen
 * @Description TODO
 */
public class 蜡烛之间的盘子 {
    public static void main(String[] args) {
        蜡烛之间的盘子 s = new 蜡烛之间的盘子();
        ArrayUtils.print(s.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{4,5}}));
    }
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                map.put(i, count);
            }else {
                count++;
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            Integer left = map.ceilingKey(queries[i][0]);
            if(left == null) {
                continue;
            }
            Integer right = map.floorKey(queries[i][1]);
            if(right == null) {
                continue;
            }
            if(left <= right) {
                res[i] = map.get(right) - map.get(left);
            }

        }
        return res;
    }
}
