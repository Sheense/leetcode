package com.company.math;

//贝祖定律ax+by = z z是x,y的最大公约数的倍数
//水的总量每次只会增加x或者y,增加其他量没意义
public class 水壶问题 {
    public static void main(String[] args) {
        水壶问题 s = new 水壶问题();
        System.out.println(s.canMeasureWater(3,5,4));
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if(z==0) return true;
        if(x==0&&y==0) return false;
        if(x==0) return y==z;
        if(y==0) return x==z;
        if(x+y<z) return false;
        return z%god(Math.max(x,y), Math.min(x,y))==0?true:false;
    }

    public int god(int x, int y) {
        int r = x%y;
        if(r==0) return y;
        return god(y, r);
    }


}
