package sheen.leetcode.greedyAlgorithm;


import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname 避免洪水泛滥
 * @Date 2023/10/13 00:52
 * @Created by sheen
 * @Description TODO
 */
public class 避免洪水泛滥 {
    public static void main(String[] args) {
        避免洪水泛滥 s = new 避免洪水泛滥();
        ArrayUtils.print(s.avoidFlood(new int[]{1,0,2,3,0,1,2}));
    }
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] ans = new int[rains.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.fill(ans, 1);
        for(int i = 0; i < rains.length; i++) {
            if(rains[i] > 0) {
                if(map.containsKey(rains[i])) {
                    Integer index = treeSet.ceiling(map.get(rains[i]));
                    if(index == null || index > i) {
                        return new int[]{};
                    }
                    ans[index] = rains[i];
                    map.remove(rains[i]);
                    treeSet.remove(index);
                }
                ans[i] = -1;
                map.put(rains[i], i);
            }else {
                treeSet.add(i);
            }
        }


        return ans;
    }
}
