package sheen.leetcode.window;

import java.util.TreeMap;

public class 删除最短的子数组使剩余数组有序 {
    public static void main(String[] args) {
        删除最短的子数组使剩余数组有序 s = new 删除最短的子数组使剩余数组有序();
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1,2,3,3,10,1,3,3,5}));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int index = 0;
        while (index < arr.length && arr[index] >= arr[left]) {
            left = index;
            index++;
        }
        if(left == arr.length - 1) {
            return 0;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int right = arr.length - 1;
        index = arr.length - 1;
        while (index >= 0 && arr[index] <= arr[right]) {
            map.put(arr[index], index);
            right = index;
            index--;
        }
        int res = Math.min(right, arr.length - 1 - left);
        for(int i = left; i >= 0; i--) {
            if(map.ceilingKey(arr[i]) != null) {
                int ceilKey = map.ceilingKey(arr[i]);
                res = Math.min(res, map.get(ceilKey) - i - 1);
            }
        }
        return res;
    }

}
