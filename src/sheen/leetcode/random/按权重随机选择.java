package sheen.leetcode.random;

import java.util.Random;

/**
 * @Classname 按权重随机选择
 * @Date 2021/8/30 12:37 上午
 * @Created by sheen
 * @Description TODO
 */
public class 按权重随机选择 {
    static class Solution {
        private int[] all;
        private Random r = new Random();
        public Solution(int[] w) {
            all = new int[w.length];
            for(int i = 0; i < w.length; i++) {
                if(i == 0) {
                    all[i] = w[i];
                }else {
                    all[i] = w[i] + all[i-1];
                }
            }
        }

        public int pickIndex() {
            int target = r.nextInt(all[all.length - 1]) + 1;
            int left = 0;
            int right = all.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if(target > all[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
