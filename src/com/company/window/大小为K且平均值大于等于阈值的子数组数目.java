package com.company.window;

public class 大小为K且平均值大于等于阈值的子数组数目 {
    public static void main(String[] args) {
        大小为K且平均值大于等于阈值的子数组数目 s = new 大小为K且平均值大于等于阈值的子数组数目();
        System.out.println(s.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));
    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int all = 0;
        for(int i=0;i<=arr.length-k;i++) {
            if(i==0) {
                for(int j=0;j<k;j++) {
                    all += arr[j];
                }
                double avg = (double)all/k;
                if(avg>=threshold) res++;
            }else {
                all -= arr[i-1];
                all += arr[i-1+k];
                double avg = (double) all/k;
                if(avg>=threshold) res++;
            }
        }
        return res;
    }
}
