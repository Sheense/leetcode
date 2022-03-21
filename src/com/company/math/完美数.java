package com.company.math;

/**
 * @Classname 完美数
 * @Date 2021/12/31 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 完美数 {
    public static void main(String[] args) {
        完美数 s= new 完美数();
        s.checkPerfectNumber(28);
    }
    public boolean checkPerfectNumber(int num) {
        int res = 0;
        for(int i = 1; i <= num / 2; i++) {
            if(num % i == 0) {
                int a = num / i;
                if(a > i) {
                    if(i != 1) res += a + i;
                    else res += i;
                }else if(a == i) {
                    res += a;
                }else {
                    break;
                }
            }
        }
        return  res == num;
    }
}
