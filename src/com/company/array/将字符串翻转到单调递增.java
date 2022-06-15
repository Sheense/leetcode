package com.company.array;

/**
 * @Classname 将字符串翻转到单调递增
 * @Date 2022/6/11 1:25 下午
 * @Created by sheen
 * @Description TODO
 */
public class 将字符串翻转到单调递增 {
    public int minFlipsMonoIncr(String s) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) == '1' ? 1 : 0;
            int q = s.charAt(s.length() - 1 - i) == '0' ? 1 : 0;
            if(i == 0) {
                left[i] = v;
                right[s.length() - 1 - i] = q;
            }else {
                left[i] = left[i-1] + v;
                right[s.length() - 1 - i] = right[s.length() - i] + q;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++) {
            min = Math.min(min, (i == 0 ? 0 : left[i - 1]) + (i == s.length() - 1 ? 0 : right[i]));
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
