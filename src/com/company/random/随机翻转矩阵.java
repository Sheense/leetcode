package com.company.random;

import com.company.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Classname 随机翻转矩阵
 * @Date 2021/11/27 10:48 下午
 * @Created by sheen
 * @Description TODO
 */
public class 随机翻转矩阵 {
    public static void main(String[] args) {
        Solution s = new Solution(3, 2);
        for(int i = 0; i < 6; i++) {
            ArrayUtils.print(s.flip());
        }
    }
    static class Solution {
        private Random random = new Random();
        int count;
        int m;
        int n;
        private Map<Integer, Integer> map = new HashMap<>();
        public Solution(int m, int n) {
            count = m*n;
            this.m = m;
            this.n = n;
        }

        public int[] flip() {
            int index = random.nextInt(count);
            int key;
            if(map.containsKey(index)) {
                key = map.remove(index);
            }else {
                key = index;
            }
            int res[] = new int[]{key / n, key % n};
            if(map.containsKey(count - 1)) {
                map.put(index, map.remove(count - 1));
            }else {
                map.put(index, count - 1);
            }
            count--;
            return res;
        }

        public void reset() {
            count = m * n;
            map = new HashMap<>();
        }
    }
}
