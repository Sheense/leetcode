package sheen.leetcode.binarySearch;

import sheen.leetcode.util.ArrayUtils;

import java.util.Random;

/**
 * @Classname 非重叠矩形中的随机点
 * @Date 2022/6/9 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 非重叠矩形中的随机点 {
    public static void main(String[] args) {
        Solution s = new Solution(new int[][]{{35330199,-46858448,35330694,-46856950}});
        ArrayUtils.print(s.pick());
        ArrayUtils.print(s.pick());
        ArrayUtils.print(s.pick());
    }

    static class Solution {

        private int[] arr;
        private Random random = new Random();
        private int max;
        private int[][] rects;
        public Solution(int[][] rects) {
            arr = new int[rects.length];
            for(int i = 0; i < rects.length; i++) {
                int v = (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1);
                if(i == 0) {
                    arr[i] = v;
                }else {
                    arr[i] += v + arr[i-1];
                }
            }
            max = arr[rects.length - 1] + 1;
            this.rects = rects;
        }

        public int[] pick() {
            int k = random.nextInt(max);
            System.out.println(k);
            while (k == 0) {
                k = random.nextInt(max);
            }
            int index = search(k);
            k = index == 0 ? k : k - arr[index - 1];

            int[] param = rects[index];
            int len = param[2] - param[0] + 1;
            int col = param[3] - k / len;
            int d = k - (k / len) * len;
            int row = d == 0 ? param[2] : param[0] + d - 1;
            return new int[]{row, col};
        }

        public int search(int index) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if(arr[mid] >= index) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }




}
