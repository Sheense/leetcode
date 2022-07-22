package sheen.leetcode.random;

import java.util.*;

/**
 * @Classname 黑名单中的随机数
 * @Date 2022/6/26 12:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 黑名单中的随机数 {
    public static void main(String[] args) {
        Solution s = new Solution(4, new int[]{0 , 1});
        s.pick();
    }
    static class Solution {
        private Map<Integer, Integer> map = new HashMap<>();
        private int max;
        private Random random = new Random();
        public Solution(int n, int[] blacklist) {
            max = n - blacklist.length;
            Arrays.sort(blacklist);
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < blacklist.length; i++) {
                if(blacklist[i] >= max) {
                    set.add(blacklist[i]);
                }
            }

            int v = max;
            for(int black : blacklist) {
                if(black < max) {
                    while (set.contains(v)) {
                        v++;
                    }
                    map.put(black, v);
                    v++;
                }
            }

        }

        public int pick() {
            int index = this.random.nextInt(max);
            return map.getOrDefault(index, index);
        }
    }
}
