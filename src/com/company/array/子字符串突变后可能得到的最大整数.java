package com.company.array;

/**
 * @Classname 子字符串突变后可能得到的最大整数
 * @Date 2021/7/25 11:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 子字符串突变后可能得到的最大整数 {
    public String maximumNumber(String num, int[] change) {
        int index = 0;
        String res = "";
        while (index < num.length() && change[num.charAt(index) - '0'] <= num.charAt(index) - '0') {
            res += num.charAt(index);
            index++;
        }

        while (index < num.length() && change[num.charAt(index) - '0'] >= num.charAt(index) - '0') {
            res += change[num.charAt(index) - '0'];
            index++;
        }
        if (index < num.length()) {
            res += num.substring(index);
        }
        return res;
    }
}
