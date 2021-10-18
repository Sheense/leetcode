package com.company.array;

/**
 * @Classname 检查句子中的数字是否递增
 * @Date 2021/10/17 12:02 下午
 * @Created by sheen
 * @Description TODO
 */
public class 检查句子中的数字是否递增 {
    public boolean areNumbersAscending(String s) {
        int pre = -1;
        String[] strings = s.split(" ");
        for(int i = 0;i < strings.length; i++) {
            boolean flag = true;
            for(int j = 0; j < strings[i].length(); j++) {
                if(strings[i].charAt(j) < '0' || strings[i].charAt(j) > '9') {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(pre >= Integer.parseInt(strings[i])) {
                    return false;
                }
                pre = Integer.parseInt(strings[i]);
            }
        }
        return true;
    }
}
