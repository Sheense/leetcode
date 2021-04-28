package com.company.sort;

import java.util.TreeMap;

public class 存在重复元素III {
    public static void main(String[] args) {
        存在重复元素III s = new 存在重复元素III();
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{7,1,3}, 2,3));
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length ==0 || k == 0) return false;
        TreeMap<Long, Integer> map = new TreeMap<>();
        int i = 0;
        do{
            if(i==0) {
                for(int j=i+1;j<=k&&j<nums.length;j++) {
                    map.put((long)nums[j], map.getOrDefault((long)nums[j], 0) +1);
                }
            }else {
                map.put((long)nums[i], map.get((long)nums[i])-1);
                if(map.get((long)nums[i]) == 0) map.remove((long)nums[i]);
                if(i+k<nums.length) {
                    map.put((long)nums[i+k], map.getOrDefault((long)nums[i+k], 0) + 1);
                }
            }
            long begin = (long)nums[i] - t;
            long last = t +  (long)nums[i];
            if (map.containsKey(begin) || map.higherKey(begin) != null&&map.higherKey(begin)<=last) return true;
            i++;
        }while (i<nums.length-1);
        return false;
    }

    public void sort(int start, int end, int[] arr, int[] index) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int m = arr[left];
        int mIndex = index[left];
        while (left<right) {
            while (left<right&&m<=arr[right]) right--;
            arr[left] = arr[right];
            index[left] = index[right];
            while (left<right&&m>=arr[left]) left++;
            arr[right] = arr[left];
            index[right] = index[left];
        }
        arr[left] = m;
        index[left] = mIndex;
        sort(start, left-1, arr, index);
        sort(left+1, end, arr, index);
    }
}
