package com.company.bitOperation;

public class 翻转数位 {
    public static void main(String[] args) {
        翻转数位 s = new 翻转数位();
        System.out.println(s.reverseBits(Integer.MAX_VALUE));
    }
    public int reverseBits(int num) {
        int[] arr = new int[32];
        for(int i=0;i<arr.length;i++) {
            if((num & 1) == 1) {
                arr[i] = 1;
            }
            num>>=1;
        }
        int res = 0;
        int i = 0;
        while (i<arr.length) {
            int flag = arr[i] == 0 ? i : -1;
            int j = i + 1;
            while (j<arr.length) {
                if(arr[j] == 0) {
                    if(flag == -1) {
                        flag = j;
                    }else {
                        break;
                    }
                }
                j++;
            }
            res = Math.max(res, j - i);
            if(j == arr.length) break;
            i = flag+1;
        }
        return res;
    }
}
