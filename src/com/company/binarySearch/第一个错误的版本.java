package com.company.binarySearch;

public class 第一个错误的版本 {
    public int firstBadVersion(int n) {
        if(isBadVersion(1) && isBadVersion(2)) {
            return 1;
        }
        if(isBadVersion(2)) return 2;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (right - left) /2 + left;
            if(!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (isBadVersion(left)) return left;
        System.out.println(right);
        return right;
    }

    public boolean isBadVersion(int n) {
        return false;
    }
}
