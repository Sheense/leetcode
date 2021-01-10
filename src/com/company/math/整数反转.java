package com.company.math;

public class 整数反转 {
    public static void main(String[] args) {
        整数反转 s = new 整数反转();
        System.out.println(s.reverse(Integer.MIN_VALUE));
    }

    public int reverse(int x) {
        int max = 1000000000;
        if(x/max!=0) {
            boolean fuhao = x>0?true:false;
            if(x%10>2||x%10<-2) return 0;
            else if(x%10==2||x%10==-2) {
                int m = x/10;
                int res = 0;
                if(fuhao) {
                    res = reverse(m);
                    if(res>(Integer.MAX_VALUE%max)) return 0;
                }else {
                    res = reverse(m);
                    if(res<(Integer.MIN_VALUE%max)) return 0;
                }
                return fuhao?2*max+res:-2*max+res;
            }
        }
        int index = 1;
        int num = 10;
        while(x/num!=0) {
            index++;
            num*=10;
        }
        int res = 0;
        for(int i= index;i>0;i--) {
            res += x%10;
            x/=10;
            if(i!=1) res*=10;
        }
        return res;
    }
}
