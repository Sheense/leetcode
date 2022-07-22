package sheen.leetcode.sort;

import java.util.Arrays;

public class 数组中的逆序对 {

    public static void main(String[] args) {
        数组中的逆序对 s = new 数组中的逆序对();
        System.out.println(s.reversePairs(new int[]{7,5,6,4}));
    }

    public int reversePairs(int[] nums) {
        if(nums.length==0) return 0;
        return sort(nums, 0, nums.length-1);
    }

    public int sort(int[] nums, int start, int end) {
        if(start>=end) return 0;
        int mid = (start+end)/2;
        int res = 0;
        res += sort(nums, start, mid);
        res += sort(nums, mid+1, end);
        for(int i=mid+1;i<=end;i++) {
            int s = start;
            int e = mid;
            while(s<=e) {
                int m = (s+e)/2;
                if(nums[m]>nums[i]) {
                    e = m-1;
                }else {
                    s = m+1;
                }
            }
            res += mid-s+1;
        }
        Arrays.sort(nums,start,end+1);
        return res;
    }
}
