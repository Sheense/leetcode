package sheen.leetcode.greedyAlgorithm;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Classname 优势洗牌
 * @Date 2022/10/8 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 优势洗牌 {
    public static void main(String[] args) {
        优势洗牌 s = new 优势洗牌();
        ArrayUtils.print(s.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11}));
    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.sort(nums1);
        int[][] arr = new int[nums2.length][2];
        for(int i = 0; i < nums2.length; i++) {
            arr[i][0] = i;
            arr[i][1] = nums2[i];
        }
        sort(0, nums1.length - 1, arr);
        int s = 0;
        int e = nums1.length - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i][1] < nums1[e]) {
                res[arr[i][0]] = nums1[e];
                e--;
            }else {
                res[arr[i][0]] = nums1[s];
                s++;
            }
        }
        return res;
    }

    public void sort(int s, int e, int[][] arr) {
        if(s >= e) {
            return;
        }
        int left = s;
        int right = e;
        int[] mid = arr[left];
        while (left < right) {
            while (left < right && mid[1] <= arr[right][1]) right--;
            arr[left] = arr[right];
            while (left < right && mid[1] >= arr[left][1]) left ++;
            arr[right] = arr[left];
        }
        arr[left] = mid;
        sort(s, left - 1, arr);
        sort(left + 1, e, arr);
    }

}
