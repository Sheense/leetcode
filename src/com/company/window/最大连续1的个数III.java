package com.company.window;

public class 最大连续1的个数III {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == 128);
        /*最大连续1的个数III s = new 最大连续1的个数III();
        System.out.println(s.longestOnes(new int[]{0,0,1,1,1,0,0},0));*/
    }
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int left = 0;
        int right = 0;
        int zeroNum = 0;
        while(right<A.length) {
            while (right<A.length&&((zeroNum+1<=K&&A[right]==0)||A[right]==1)) {
                if(A[right] == 0) {
                    zeroNum++;
                }
                right++;
            }
            res = Math.max(res, right - left);
            if(left==right) {
                left ++;
                right++;
            }
            while(left<right&&zeroNum==K) {
                if(A[left]==0) {
                    zeroNum--;
                }
                left++;
            }
        }
        return res;
    }
}
