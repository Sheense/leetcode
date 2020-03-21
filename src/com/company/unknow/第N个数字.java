package com.company.unknow;

public class 第N个数字 {

    public static void main(String[] args) {
        第N个数字 s = new 第N个数字();
        System.out.println(s.findNthDigit(10000));
    }

    public int findNthDigit(int n) {
        if(n<10) return n;
        int i=1;
        double num = i*9*Math.pow(10,i-1);
        while(num<n) {
            i++;
            num += i*9*Math.pow(10,i-1);
        }
        num -=  i*9*Math.pow(10,i-1);
        double r = n - num;
        double start = 0;
        for(int j=i-1;j>=1;j--){
            start += 9*Math.pow(10,j-1);
        }
        double time = Math.floor(r/i) + start;
        double yushu = (int)r%i;
        if(yushu==0) {
            return (int)time%10;
        } else {
            time++;
            if(yushu==1) return (int)(time/Math.pow(10,i-1));
            return (int)(time/Math.pow(10, i+1-yushu-1)%10);
        }

    }
}
