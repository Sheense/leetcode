package com.company.binarySearch;

public class 有序数组中出现次数超过25的元素 {

    public static void main(String[] args) {
        有序数组中出现次数超过25的元素 s = new 有序数组中出现次数超过25的元素();
        System.out.println(s.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }

    public int findSpecialInteger(int[] arr) {
        return search(0,arr.length-1,arr);
    }
    public int search(int start, int end, int[] arr) {
        if(start>end) return -1;
        int mid = (start+end)/2;
        int len = 1;
        int m = mid-1;
        while(m>=start&&arr[m]==arr[mid]) {
            len++;
            m--;
        }
        int n = mid+1;
        while (n<=end&&arr[n]==arr[mid]) {
            len++;
            n++;
        }
        if(arr.length/len<4) {
            return arr[mid];
        }
        int res = search(n,end,arr);
        if(res!=-1) return res;
        res = search(start,m,arr);
        return res;
    }
}
