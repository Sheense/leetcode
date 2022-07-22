package sheen.leetcode.array;

public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        int[] start = new int [a.length];
        int[] end = new int[a.length];
        for(int i=0;i<a.length;i++) {
            if(i==0) {
                start[i] = a[i];
                end[a.length-i-1] = a[a.length-i-1];
            }else {
                start[i] = start[i-1]*a[i];
                end[a.length-i-1] = end[a.length-i]*a[a.length-i-1];
            }
        }
        int[] res = new int[a.length];
        for(int i=0;i<a.length;i++) {
            if(i==0) {
                res[i] = end[i+1];
            }else if(i==a.length-1) {
                res[i] = start[i-1];
            }else {
                res[i] = start[i-1] * end[i+1];
            }
        }
        return res;
    }
}
