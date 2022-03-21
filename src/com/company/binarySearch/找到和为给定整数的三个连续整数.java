package com.company.binarySearch;

/**
 * @Classname 找到和为给定整数的三个连续整数
 * @Date 2022/2/19 10:49 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找到和为给定整数的三个连续整数 {
    public long[] sumOfThree(long num) {
        if(num % 3 == 0) {
            return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
        }
        return new long[]{};
    }
}
