package com.company.array;

/**
 * @Classname 分割平衡字符串
 * @Date 2021/9/7 12:47 上午
 * @Created by sheen
 * @Description TODO
 */
public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if(s.charAt(i) == 'L') {
                l++;
            }else {
                r++;
            }
            while (l!=r) {
                if(s.charAt(i) == 'L') {
                    l++;
                }else {
                    r++;
                }
                i++;
            }
            res ++;
            l = 0;
            r = 0;
        }
        return res;
    }
}
