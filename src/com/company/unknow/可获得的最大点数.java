package com.company.unknow;

public class 可获得的最大点数 {
    public static void main(String[] args) {
        可获得的最大点数 s = new 可获得的最大点数();
        System.out.println(s.maxScore(new int[]{1,1000,1},1));
    }
    public int maxScore(int[] cardPoints, int k) {
        int[] a = new int[cardPoints.length];
        int[] b = new int[cardPoints.length];
        for(int i=0;i<cardPoints.length;i++) {
            if(i==0) {
                a[i] = cardPoints[i];
                b[cardPoints.length-1-i] = cardPoints[cardPoints.length-1-i];
                continue;
            }
            a[i] = a[i-1] + cardPoints[i];
            b[cardPoints.length-1-i] = b[cardPoints.length-i] + cardPoints[cardPoints.length-i-1];
        }
        if(k == cardPoints.length) return a[cardPoints.length-1];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=k;i++) {
            if(i==0) {
                max = Math.max(max, b[cardPoints.length-k]);
            }else if(i==k) {
                max = Math.max(max, a[k-1]);
            }else {
                max = Math.max(max, a[i-1]+b[cardPoints.length-(k-i)]);
            }
        }
        return max;
    }
}
