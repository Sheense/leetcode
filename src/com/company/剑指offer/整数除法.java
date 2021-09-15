package com.company.剑指offer;

/**
 * @Classname 整数除法
 * @Date 2021/9/2 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 整数除法 {
    public int divide(int a, int b) {
        if(a==Integer.MIN_VALUE&&b==-1) return (1<<31)-1;
        if(a==Integer.MIN_VALUE&&b==1) return a;
        if(a==Integer.MIN_VALUE&&b == Integer.MIN_VALUE) return 1;
        if(b==Integer.MIN_VALUE) return 0;
        boolean flag = false;
        if(a==Integer.MIN_VALUE) {
            a ++;
            flag = true;
        }
        int beichushu = a>=0 ? a : (~a)+1;
        int chushu = b>=0 ? b : (~b)+1;
        int shang = 0;
        for (int i = 31;i>=0;i--) {
            if((beichushu>>i)>=chushu) {
                beichushu = add(beichushu, (~(chushu<<i))+1);
                shang = add(shang, 1<<i);
            }
        }
        if(flag&&(beichushu+1)>=chushu) {
            shang = add(shang, 1);
        }
        return (a^b)<0?(~shang)+1:shang;
    }
    public int add (int v1,int v2) {
        int carry = (v1&v2)<<1;
        int result = v1^v2;
        while(carry!=0) {
            int item1 = (carry&result)<<1;
            int item2 = carry^result;
            carry = item1;
            result = item2;
        }
        return result;
    }
}
