package com.company.array;

/**
 * @Classname 写字符串需要的行数
 * @Date 2022/4/12 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 写字符串需要的行数 {
    public int[] numberOfLines(int[] widths, String s) {
        int row = 0;
        int i = 0;
        int last = 0;
        while (i < s.length()) {
            int all = 0;
            while (i < s.length() && all + widths[s.charAt(i) - 'a'] <= 100) {
                all += widths[s.charAt(i) - 'a'];
                i++;
            }
            row++;
            last = all;
        }
        return new int[]{row, last};
    }
}
