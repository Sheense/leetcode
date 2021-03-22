package com.company.binarySearch;

import java.util.HashMap;
import java.util.Map;

public class 最接近目标价格的甜点成本 {
    public static void main(String[] args) {
        最接近目标价格的甜点成本 s = new 最接近目标价格的甜点成本();
        System.out.println(s.closestCost(new int[]{3,10}, new int[]{2,5}, 9));
    }
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        int minAbs = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<baseCosts.length;i++) {
            int abs = Math.abs(target - baseCosts[i]);
            if (abs<=minAbs) {
                if (abs==minAbs && baseCosts[i]<minValue) {
                    minValue = baseCosts[i];
                }else if(abs<minAbs) {
                    minAbs = abs;
                    minValue = baseCosts[i];
                }
            }
            int value = baseCosts[i];
            Map<Integer, Integer> map = new HashMap<>();
            dfs(map, 0, toppingCosts, value, target);
            int minKey = Integer.MAX_VALUE;
            for(int key:map.keySet()) {
                if(minKey>key) {
                    minKey = key;
                }
            }
            if (minKey<=minAbs) {
                if (minKey==minAbs && map.get(minKey)<minValue) {
                    minValue = map.get(minKey);
                }else if(minKey<minAbs) {
                    minAbs = minKey;
                    minValue = map.get(minKey);
                }
            }
            if (minAbs == 0) return minValue;
        }
        return minValue;
    }

    public void dfs(Map<Integer, Integer> map, int start, int[] toppingCosts, int now, int target) {
        if (start>=toppingCosts.length) return;
        dfs(map, start+1, toppingCosts, now, target);
        int n = now + toppingCosts[start];
        int abs = Math.abs(target - n);
        map.put(abs, map.getOrDefault(abs, n) <= n ? map.getOrDefault(abs, n) : n);
        dfs(map, start+1, toppingCosts, n, target);

        n = now + toppingCosts[start] * 2;
        abs = Math.abs(target - n);
        map.put(abs, map.getOrDefault(abs, n) <= n ? map.getOrDefault(abs, n) : n);
        dfs(map, start+1, toppingCosts, n, target);
    }
}
