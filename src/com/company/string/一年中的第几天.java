package com.company.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 一年中的第几天
 * @Date 2021/12/21 12:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 一年中的第几天 {
    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        boolean flag = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        int month = Integer.valueOf(date.substring(5, 7));
        int res = 0;
        Set<Integer> bigMonth = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        Set<Integer> smallMonth = new HashSet<>(Arrays.asList(4, 6, 9, 11));
        for(int i = 1; i < month; i++) {
            if(bigMonth.contains(i)) {
                res += 31;
            }else if(smallMonth.contains(i)) {
                res += 30;
            }else {
                if(flag) {
                    res += 29;
                }else {
                    res += 28;
                }
            }
        }
        int day = Integer.valueOf(date.substring(8, 10));
        return res + day;
    }
}
