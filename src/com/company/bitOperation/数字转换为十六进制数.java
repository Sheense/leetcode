package com.company.bitOperation;

/**
 * @Classname 数字转换为十六进制数
 * @Date 2021/10/2 1:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数字转换为十六进制数 {
    public static void main(String[] args) {
        数字转换为十六进制数 s = new 数字转换为十六进制数();
        System.out.println(s.toHex(21412));
    }
    public String toHex(int num) {
        String res = "";
        for(int i = 0; i < 28; i+=4) {
            int n = 0;
            int index = i;
            while (index < i + 4) {
                n |= (1 << index);
                index++;
            }
            n = n & num;
            n >>= i;
            if(n < 10) {
                res = n + res;
            }else {
                res = (char)('a' + (n-10)) + res;
            }
        }
        int n = 0;
        n |= (1 << 28);
        n |= (1 << 29);
        n |= (1 << 30);
        n = n & num;
        n >>= 28;
        if(num < 0) {
            n |= (1 << 3);
        }
        if(n < 10) {
            res = n + res;
        }else {
            res = (char)('a' + (n-10)) + res;
        }
        for(int i = 0; i < res.length(); i++) {
            if(res.charAt(i) != '0') {
                return res.substring(i);
            }
        }
        return "0";
    }
}
