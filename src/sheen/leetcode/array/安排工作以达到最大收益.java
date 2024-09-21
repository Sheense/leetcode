package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 安排工作以达到最大收益
 * @Date 2024/5/17 00:05
 * @Created by sheen
 * @Description TODO
 */
public class 安排工作以达到最大收益 {
    public static void main(String[] args) {
        安排工作以达到最大收益 s = new 安排工作以达到最大收益();
        System.out.println(s.maxProfitAssignment(new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        sort(difficulty, profit, 0, profit.length - 1);
        for(int i = 1; i < profit.length; i++) {
            profit[i] = Math.max(profit[i], profit[i - 1]);
        }

       // ArrayUtils.print(profit);
        //ArrayUtils.print(difficulty);

        int res = 0;
        for(int work : worker) {
            int index = search(difficulty, work);
            if (index == -1) {
                continue;
            }
            res += profit[index];
        }

        return res;
    }

    public int search(int[] difficulty, int target) {
        int left = 0;
        int right = difficulty.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (difficulty[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return right;
    }

    public void sort(int[] difficulty, int[] profit, int left, int right) {
        if (left > right) {
            return;
        }

        int midDif = difficulty[left];
        int midPor = profit[left];
        int start = left;
        int end = right;
        while (start < end) {
            while (start < end && midDif <= difficulty[end]) {
                end--;
            }
            difficulty[start] = difficulty[end];
            profit[start] = profit[end];
            while (start < end && midDif >= difficulty[start]) {
                start++;
            }
            difficulty[end] = difficulty[start];
            profit[end] = profit[start];
        }

        difficulty[start] = midDif;
        profit[start] = midPor;
        sort(difficulty, profit, left, start - 1);
        sort(difficulty, profit, start + 1, right);
    }

}
