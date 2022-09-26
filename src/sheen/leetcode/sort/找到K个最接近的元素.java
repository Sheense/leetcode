package sheen.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 找到K个最接近的元素
 * @Date 2022/8/25 12:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找到K个最接近的元素 {
    public static void main(String[] args) {
        找到K个最接近的元素 s = new 找到K个最接近的元素();
        System.out.println(s.findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5));
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] abs = new int[arr.length];
        int[] ind = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            abs[i] = Math.abs(arr[i] - x);
            ind[i] = i;
        }
        sort(arr, abs, ind, 0, arr.length - 1);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(arr[ind[i]]);
        }
        Collections.sort(res);
        return res;
    }

    public void sort(int[] arr, int[] abs, int[] ind, int left, int right) {
        if(left > right) return;
        int mid = abs[left];
        int midInd = ind[left];
        int start = left;
        int end = right;
        while (start < end) {
            while (start< end && (mid < abs[end] || (mid == abs[end] && arr[midInd] <= arr[ind[end]]))) end--;
            abs[start] = abs[end];
            ind[start] = ind[end];
            while (start<end && (mid > abs[start] || (mid == abs[start] && arr[midInd] >= arr[ind[start]]))) start++;
            abs[end] = abs[start];
            ind[end] = ind[start];
        }
        abs[start] = mid;
        ind[start] = midInd;
        sort(arr, abs, ind, left, start - 1);
        sort(arr, abs, ind, start + 1, right);
    }
}
