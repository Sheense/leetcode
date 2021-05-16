package com.company.binarySearch;

import com.company.util.ArrayUtils;

public class 增长的内存泄露 {
    public static void main(String[] args) {
        增长的内存泄露 s = new 增长的内存泄露();
        ArrayUtils.print(s.memLeak(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    public int[] memLeak(int memory1, int memory2) {
        int start = 1;
        while (memory1 >= start || memory2 >= start) {
            if(memory1 >= memory2) {
                memory1 -= start;
            }else {
                memory2 -= start;
            }
            start++;
        }
        return new int[]{start, memory1, memory2};
    }
}
