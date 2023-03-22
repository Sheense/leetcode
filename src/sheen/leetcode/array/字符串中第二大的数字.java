package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 字符串中第二大的数字
 * @Date 2022/12/3 12:41 下午
 * @Created by sheen
 * @Description TODO
 */
public class 字符串中第二大的数字 {
    public int secondHighest(String s) {
        int max = -1;
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(num >= 0 && num <= 9) {
                max = Math.max(num, max);
            }
        }

        int res = -1;
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(num >= 0 && num <= 9 && num != max) {
                res = Math.max(num, res);
            }
        }
        return res;
    }
}
