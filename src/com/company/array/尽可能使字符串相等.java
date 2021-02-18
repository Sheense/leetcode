package com.company.array;

public class 尽可能使字符串相等 {
    public static void main(String[] args) {
        尽可能使字符串相等 s = new 尽可能使字符串相等();
        System.out.println(s.equalSubstring("abcd",
                "cdef",
                3));
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int arr[] = new int[s.length()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = Math.abs(s.charAt(i)-t.charAt(i));
            if(i>0) {
                arr[i] += arr[i-1];
            }
        }
        int maxLen = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=maxCost) {
                maxLen = Math.max(maxLen, i+1);
            }else {
                int left = 0;
                int right = i;
                int target = arr[i] - maxCost;
                if(target>=arr[0]) {
                    while(left<=right) {
                        int mid = (left+right)/2;
                        if(arr[mid]>=target) {
                            right = mid-1;
                        }else {
                            left = mid+1;
                        }
                    }
                    maxLen = Math.max(maxLen, i - left);
                }
            }
        }
        return maxLen;
    }
}
