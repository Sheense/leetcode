package com.company.array;

public class 通过最少操作次数使数组的和相等 {
    public static void main(String[] args) {
        通过最少操作次数使数组的和相等 s = new 通过最少操作次数使数组的和相等();
        System.out.println(s.minOperations(new int[]{1,5,5,2,1,1,1,1,4,4,4,1,5,2,2,4,6,5,1,5,3,5,6,2,3,1,5,4,4,1,2,4,1,1,6,3,6,4,4,4,3,5,5,5,2,6,4,2,5,4,2,6,3,4,6,1,5,3,2,3,5,2,1,3,2,4,4,4,5,3,5,5,4,1,1,6,5,6,3,5,3,6,5,6,5,4,4,4,5,6,6,6,4,2,4,6,1,2,1,5,3,4,5,5,6,6,1,4,3,1,5,3,4,1,2,1,4,4,5,6,5,3,1,5,1,3,3,6,5,3,5,6,2,6,3,1,2,3,3,1,1,4,3,2,6,6,2,1,2,4,3,5,5,4,3,1,1,5,2,5,1,4,5,6,4,5,2,1,2,5,3,2,6,3,4,3,4,5,4,6,3,4,4,3,3,4,2,2,6,2,6,3,1,1,5,3,1,1,4,2,5,5,5,4,3,6,5,5,5,1,1,3,6,2,3,6,3,4,2,5,4,4,3,5,6,4,3,5,1,1,3,3,1,1,6,4,6,2,1,4,3,5,5},
                new int[]{1,2,5,4,3,3,5,1,1,6,2,5,4,4,5,6,6,4,2,5,6,2,3,4,5,2,4,4,3,6,6,5,4,1,2,1,2,3,3,2,6,1,1,1,1,3,5,6,2,1,1,1,4,6,5}));
        try {
            throw new NullPointerException();
        }catch (Exception e) {

        }
        System.out.println("aa");
    }
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length*6<nums2.length||nums2.length*6<nums1.length) return -1;
        int all1 = 0;
        int[] arr1 = new int[7];
        int all2 = 0;
        int[] arr2 = new int[7];
        int index = 0;
        while(index<nums1.length||index<nums2.length) {
            if(index<nums1.length) {
                all1 += nums1[index];
                arr1[nums1[index]]++;
            }
            if(index<nums2.length) {
                all2 += nums2[index];
                arr2[nums2[index]]++;
            }
            index++;
        }
        int left = Math.max(nums1.length, nums2.length);
        int right = Math.min(nums2.length*6, nums1.length*6);
        int res = Integer.MAX_VALUE;
        for(int i = left;i<=right;i++) {
            int[] newArr1 = new int[7];
            int[] newArr2 = new int[7];
            for(int j=0;j<arr1.length;j++) {
                newArr1[j] = arr1[j];
                newArr2[j] = arr2[j];
            }
            int a = getMinOperation(i, newArr1, all1);
            int b = getMinOperation(i, newArr2, all2);
            int n = a + b;
            if(n<=res) res = n;
        }
        return res;
    }

    public int getMinOperation(int target, int[] arr, int all) {
        int res = 0;
        if (target<all) {
            int i = arr.length - 1;
            target = Math.abs(target - all);
            while(i >= 1&&target>0) {
                if (arr[i]==0) {
                    i--;
                } else {
                    int time = Math.min(target / (i - 1), arr[i]);
                    res += time;
                    arr[i] -= time;
                    target -= time * (i - 1);
                    if (target != 0 && (i - 1) >= target && arr[i] != 0) {
                        res++;
                        break;
                    }
                }
            }
        }else if (target>all){
            int i = 1;
            target -= all;
            while(i >= 1&&target>0) {
                if (arr[i]==0) {
                    i++;
                } else {
                    int time = Math.min(target / (6 - i), arr[i]);
                    res += time;
                    arr[i] -= time;
                    target -= time * (6 - i);
                    if (target!=0 && (6 - i)>=target && arr[i] != 0) {
                        res ++;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
