package com.company.array;

/**
 * @Classname 字符串转化后的各位数字之和
 * @Date 2021/7/25 10:57 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字符串转化后的各位数字之和 {
    public int getLucky(String s, int k) {
        int res = 0;
        k--;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a' + 1;
            while (c != 0) {
                res += (c % 10);
                c /= 10;
            }
        }
        while (k-- != 0) {
            int item = 0;
            while (res!=0) {
                item += (res%10);
                res /= 10;
            }
            res = item;
        }
        return res;
    }
}
