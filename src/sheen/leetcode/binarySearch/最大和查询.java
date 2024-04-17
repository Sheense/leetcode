package sheen.leetcode.binarySearch;

import java.util.*;

/**
 * @Classname 最大和查询
 * @Date 2023/11/17 00:18
 * @Created by sheen
 * @Description TODO
 */
public class 最大和查询 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[][] sortNums = new int[nums1.length][2];
        for(int i = 0; i < nums1.length; i++)  {
            sortNums[i][0] = nums1[i];
            sortNums[i][1] = nums2[i];
        }

        Arrays.sort(sortNums, (x, y) -> y[0] - x[0]);
        int[][] sortQueries = new int[queries.length][3];
        for(int i = 0; i < queries.length; i++) {
            sortQueries[i][0] = i;
            sortQueries[i][1] = queries[i][0];
            sortQueries[i][2] = queries[i][1];
        }

        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        Arrays.sort(sortQueries, (x, y) -> y[1] - x[1]);
        List<int[]> stack = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < sortQueries.length; i++) {
            int idx = sortQueries[i][0], x = sortQueries[i][1], y = sortQueries[i][2];
            while (j < sortNums.length && sortNums[j][0] >= x) {
                int num1 = sortNums[j][0], num2 = sortNums[j][1];
                while (!stack.isEmpty() && stack.get(stack.size() - 1)[1] <= num1 + num2) {
                    stack.remove(stack.size() - 1);
                }

                if(stack.isEmpty() || stack.get(stack.size() - 1)[0] < num2) {
                    stack.add(new int[]{num2, num1 + num2});
                }
                j++;
            }
            int k = search(stack, y);
            if(k < stack.size()) {
                res[idx] = stack.get(k)[1];
            }

        }

        return res;
    }

    public int search(List<int[]> stack, int y) {
        int left = 0;
        int right = stack.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(stack.get(mid)[0] < y) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left;
    }


}
