package com.company.array;

/**
 * @Classname 最长特殊序列II
 * @Date 2022/6/27 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长特殊序列II {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for(int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for(int j = 0; j < strs.length; j++) {
                if(i != j) {
                    int index1 = 0;
                    int index2 = 0;
                    while (index1 < strs[i].length() && index2 < strs[j].length()) {
                        if(strs[i].charAt(index1) == strs[j].charAt(index2)) {
                            index1++;
                        }
                        index2++;
                    }
                    if(index1 == strs[i].length()) {
                        flag = false;
                        continue;
                    }
                }
            }
            if(flag) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
}
