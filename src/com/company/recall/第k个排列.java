package com.company.recall;

public class 第k个排列 {

    public static void main(String[] args) {
        第k个排列 s = new 第k个排列();
        System.out.println(s.getPermutation(4,6));
    }

    public String getPermutation(int n, int k) {

        StringBuilder res = new StringBuilder();
        int circel = 1;
        for(int i=1;i<=n;i++) {
            circel *= i;
        }
        recall(res, new boolean[n],k-1,circel,n);
        return res.toString();
    }
    public void recall(StringBuilder res, boolean[] arr, int k, int circle, int n) {
        if(n==1) {
            for(int i=0;i<arr.length;i++) {
                if(!arr[i]) {
                    res.append(i+1);
                    return;
                }
            }
        }
        int index = k/(circle/n);
        index++;
        int i = 0;
        while(index!=0) {
            if(!arr[i]) index--;
            if(index==0) arr[i] = true;
            i++;
        }
        res.append(i);
        k = k%(circle/n);
        circle = circle/n;
        n--;
        recall(res, arr, k,circle,n);
    }




}
