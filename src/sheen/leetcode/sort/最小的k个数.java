package sheen.leetcode.sort;

import sheen.leetcode.util.ArrayUtils;

public class 最小的k个数 {

    public static void main(String[] args) {
        最小的k个数 s = new 最小的k个数();
        ArrayUtils.print(s.getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4));
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0 || k==0) return new int[0];
        if(k>arr.length) return new int[0];
        int[] res = new int[k];
        find(res, arr, k-1, k, 0, arr.length-1);
        return res;
    }

    public int find(int[] res, int[] arr, int k,int nums, int start, int end) {
        if(nums==0) return nums;
        if(start==end&&start<=k) {
            res[start] = arr[start];
            return --nums;
        }
        if(start>end) return nums;
        int left = start;
        int right = end;
        while(left!=right) {
            while(left!=right&&arr[left]<=arr[right]) left++;
            if(left==right) break;
            swap(left, right, arr);
            while(left!=right&&arr[left]<=arr[right]) right--;
            if(left==right) break;
            swap(left, right, arr);
        }
        if(left<=k) {
            res[left] = arr[left];
            nums--;
        }
        int n = find(res, arr, k, nums, start, left-1);
        if(n==0) return n;
        return find(res, arr, k, n, left+1, end);
    }
    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
