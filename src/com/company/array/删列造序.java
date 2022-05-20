package com.company.array;

/**
 * @Classname 删列造序
 * @Date 2022/5/12 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删列造序 {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean flag = true;
            for(int j = 0; j < strs.length; j++) {
                if(c > strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
                c = strs[j].charAt(i);
            }
            if(flag) res++;
        }
        return strs[0].length() - res;
    }
}
