package com.company.array;

/**
 * @Classname 统计各位数字之和为偶数的整数个数
 * @Date 2022/2/20 10:47 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计各位数字之和为偶数的整数个数 {
    public static void main(String[] args) {
        统计各位数字之和为偶数的整数个数 s = new 统计各位数字之和为偶数的整数个数();
        System.out.println(s.countEven(34));
    }
    public int countEven(int num) {
        int res = 0;
        for(int i = 2; i < num; i++) {
            int and = 0;
            while (i != 0) {
                and += (i % 10);
                i/=10;
            }
            if(and % 2 ==0) {
                res++;
            }
        }
        return res;
    }
}
