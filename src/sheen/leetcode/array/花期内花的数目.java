package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 花期内花的数目
 * @Date 2023/9/28 00:14
 * @Created by sheen
 * @Description TODO
 */
public class 花期内花的数目 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int[] flower : flowers) {
            treeMap.put(flower[0], treeMap.getOrDefault(flower[0], 0) + 1);
            treeMap.put(flower[1] + 1, treeMap.getOrDefault(flower[1] + 1, 0) - 1);
        }

        int[] ans = new int[people.length];
        int[][] indexs = new int[people.length][2];
        for(int i = 0; i < people.length; i++) {
            indexs[i][0] = people[i];
            indexs[i][1] = i;
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(treeMap.entrySet());
        int i = 0;
        int cnt = 0;
        Arrays.sort(indexs, (x, y) -> x[0] - y[0]);
        for(int[] index : indexs) {
            while (i < list.size() && list.get(i).getKey() <= index[0]) {
                cnt += list.get(i).getValue();
                i++;
            }
            ans[index[1]] = cnt;
        }

        return ans;
    }
}
