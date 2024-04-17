package sheen.leetcode.binarySearch;

import java.util.*;

/**
 * @Classname 使数组连续的最少操作数
 * @Date 2024/4/8 00:18
 * @Created by sheen
 * @Description TODO
 */
public class 使数组连续的最少操作数 {
    public static void main(String[] args) {
        使数组连续的最少操作数 s = new 使数组连续的最少操作数();
        System.out.println(s.minOperations(new int[]{1,10,100,1000}));
    }
    public int minOperations(int[] nums) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) set.add(nums[i]);
        List<Integer> list = new ArrayList<>(set);
        int n = nums.length;
        Collections.sort(list);
        int left = 0;
        while (left < list.size()) {
            int start = left;
            while (left + 1 < list.size() && list.get(left) + 1 == list.get(left + 1)) {
                left++;
            }
            if(left == list.size() - 1) {
                min = Math.min(min, n - (left - start + 1));
            }else {
                int index = search(list, left + 1, list.get(start) + n - 1);
                min = Math.min(min, n - (index - start + 1));
            }

            left++;
        }

        return min;
    }

    public int search(List<Integer> list, int left, int target) {
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(list.get(mid) <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
}
