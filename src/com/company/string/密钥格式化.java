package com.company.string;

/**
 * @Classname 密钥格式化
 * @Date 2021/10/4 1:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 密钥格式化 {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        s = s.replace("-", "");
        int yu = s.length() % k;
        String res = "";
        int i = 0;
        if(yu > 0) {
            while (yu-- > 0) {
                res += s.charAt(i);
                i++;
            }
            if(i != s.length()) {
                res += "-";
            }
        }

        while (i < s.length()) {
            int index = 0;
            while (index<k){
                res += s.charAt(i);
                i++;
                index++;
            }
            if(i != s.length()) {
                res += "-";
            }
        }
        return res;
    }
}
