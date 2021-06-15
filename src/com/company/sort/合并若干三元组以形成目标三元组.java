package com.company.sort;

import java.util.HashSet;
import java.util.Set;

public class 合并若干三元组以形成目标三元组 {
    public static void main(String[] args) {
        合并若干三元组以形成目标三元组 s = new 合并若干三元组以形成目标三元组();
        System.out.println(s.mergeTriplets(new int[][]{{3,1,7}, {1,5,10}}, new int[]{3,5,7}));
    }
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int range = triplets.length - 1;
        for(int i = 0; i < 3; i ++) {
            sort(triplets, 0 ,range,i);
            range = search(triplets, target[i], i, range);
            if(range >= triplets.length || range < 0 || triplets[range][i] < target[i] || triplets[range][i] > target[i]) return false;
        }
        boolean res = true;
        for(int i = 0; i < 3; i++) {
            int max = triplets[0][i];
            for(int j = 0; j <= range; j ++) {
                max = Math.max(max, triplets[j][i]);
            }
            if(max != target[i]) {
                res = false;
                break;
            }
        }
        return res;
    }

    public int search(int[][] triplets, int target, int index, int range) {
        int left = 0;
        int right = range;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(triplets[mid][index] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    public void sort(int[][] triplets, int start, int end, int index) {
        if(start >= end) return;
        int left = start;
        int right = end;
        int[] m = triplets[left];
        while (left < right) {
            while (left < right && m[index] <= triplets[right][index]) right--;
            triplets[left] = triplets[right];
            while (left < right && m[index] >= triplets[left][index]) left ++;
            triplets[right] = triplets[left];
        }
        triplets[left] = m;
        sort(triplets, start, left - 1, index);
        sort(triplets, left + 1, end , index);
    }
}
