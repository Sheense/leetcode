package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 适合打劫银行的日子
 * @Date 2022/3/6 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 适合打劫银行的日子 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] a = new int[security.length];
        int[] b = new int[security.length];
        int start = 0;
        for(int i = 1; i < security.length; i++) {
            if(security[i] <= security[i - 1]) {
                a[i] = i - start;
            }else {
                start = i;
            }
        }

        start = security.length - 1;
        for(int i = security.length - 2; i >= 0; i--) {
            if(security[i + 1] >= security[i]) {
               b[i] = start - i;
            }else {
                start = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < security.length; i++) {
            if(a[i] >= time && b[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
