package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 子数组和排序后的区间和 {

    public static void main(String[] args) {
        子数组和排序后的区间和 s = new 子数组和排序后的区间和();
        System.out.println(s.rangeSum(new int[]{1,2,3,4},4,1,5));
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int i = 1;
        list.add(nums[0]);
        int all = nums[0];
        while(i<nums.length){
            all+=nums[i];
            int j = index;
            int q = all;
            do {
                list.add(q);
                q-=nums[j];
                j++;
            } while (j<=i);
            i++;
        }
        Collections.sort(list);
        System.out.println(list);
        int res = 0;
        for(int j=left-1;j<right;j++) {
            res+=list.get(j);
            res%=1000000009;
        }
        return res;
    }
}
