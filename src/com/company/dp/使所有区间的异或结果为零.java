package com.company.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 使所有区间的异或结果为零 {
    public static void main(String[] args) {
        使所有区间的异或结果为零 s = new 使所有区间的异或结果为零();
        System.out.println(s.minChanges(new int[]{1,2,4,1,2,5,1,2,6}, 3));
    }
    public int minChanges(int[] nums, int k) {
        int MAX = 1<<10;
        int MAX_COUNT = Integer.MAX_VALUE / 2;
        //处理到第i组，且0到i组的每一个元素的异或和的最小修改次数
        int[] f = new int[MAX];
        Arrays.fill(f, MAX_COUNT);

        f[0] = 0;

        for(int i = 0; i < k; i++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            int size = 0;
            for(int j = i; j< nums.length; j+=k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                size++;
            }
            // 求出 t2
            int t2min = Arrays.stream(f).min().getAsInt();
            int g[] = new int[MAX];
            Arrays.fill(g, t2min);

            for(int x = 0; x < MAX; x++) {
                for(int key : cnt.keySet()) {
                    g[x] = Math.min(g[x], f[x ^ key] - cnt.get(key));
                }
            }
            for(int j = 0; j < MAX; j++) {
                g[j] += size;
            }

            f = g;
        }
        return f[0];
    }
}
