package com.company.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 拆分成最多数目的偶整数之和
 * @Date 2022/2/19 11:03 下午
 * @Created by sheen
 * @Description TODO
 */
public class 拆分成最多数目的偶整数之和 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 == 1) {
            return new ArrayList<>();
        }
        List<Long> list = new ArrayList<>();
        long i = 1;
        while (i * 2 <= finalSum) {
            list.add(i * 2);
            finalSum -= i * 2;
            i++;
        }
        list.set(list.size() - 1, list.get(list.size() - 1) + finalSum);
        return list;
    }
}
