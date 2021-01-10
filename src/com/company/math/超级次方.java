package com.company.math;

public class 超级次方 {

    public static void main(String[] args) {
        超级次方 s = new 超级次方();
        System.out.println(s.superPow(2147483647, new int[]{2,0,0}));
    }

    public int superPow(int a, int[] b) {
        if(b.length==0) return 0;
        int res = 1;
        a %= 1337;
        int pre = a;
        for(int i=b.length-1;i>=0;i--){
            for(int j=1;j<=b[i];j++) {
                res *= pre;
                res %= 1337;
            }
            int item = 1;
            for(int j=1;j<=10;j++) {
                item *= pre;
                item %= 1337;
            }
            pre = item;
        }
        return res;
    }

}
