package com.company.math;

public class 整数反转 {
    public static void main(String[] args) {
        整数反转 s = new 整数反转();
        System.out.println(s.reverse(-123011));
    }

    public int reverse(int x) {
        int flag = 0;
        if(x/Math.pow(10,9)!=0) {
            if(Math.abs(x%10)>2) return 0;
            else {
                flag = Math.abs(x%10);
                x /= 10;
            }
        }
        int res = 0;
        do {
            int tmp = x%10;
            res*=10;
            res = res+tmp;
            x = x/10;
        } while (x!=0);
        if(flag==0) return res;
        In

        return res;
    }
}
