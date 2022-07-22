package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 找到指定长度的回文数
 * @Date 2022/3/27 11:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找到指定长度的回文数 {
    public static void main(String[] args) {
        找到指定长度的回文数 s = new 找到指定长度的回文数();
        ArrayUtils.print(s.kthPalindrome(new int[]{2,201429812,8,520498110,492711727,339882032,462074369,9,7,6}, 1));
    }
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] res = new long[queries.length];
        if(intLength == 1) {
            for(int i = 0; i < queries.length; i++) {
                if(queries[i] <= 10) {
                    res[i] = queries[i];
                }else {
                    res[i] = -1;
                }
            }
            return res;
        }

        if(intLength == 2) {
            for(int i = 0; i < queries.length; i++) {
                if(queries[i] <= 9) {
                    res[i] = queries[i] * 10 + queries[i];
                }else {
                    res[i] = -1;
                }
            }
            return res;
        }

        if(intLength % 2 == 0) {
            long max = (long)Math.pow(10 ,intLength / 2);
            long a = (long)Math.pow(10 , intLength / 2 - 1);
            for(int i = 0; i < queries.length; i++) {
                long pre = a + queries[i] - 1;
                if(pre >= max) {
                    res[i] = -1;
                }else {
                    res[i] = pre * (long)Math.pow(10, intLength / 2) + build(pre);
                }
            }
        }else {
            long max = (long)Math.pow(10 ,intLength / 2 + 1);
            int a = (int)Math.pow(10 ,intLength / 2);
            for(int i = 0; i < queries.length; i++) {
                long pre = a + queries[i] - 1;
                if(pre >= max) {
                    res[i] = -1;
                }else {
                    res[i] = pre * (long)Math.pow(10, intLength / 2) + build(pre/10);
                }
            }
        }
        return res;
    }

    public long build(long pre) {
        int res = 0;
        while (pre != 0) {
            long yu = pre % 10;
            pre/=10;
            res *= 10;
            res += yu;
        }
        return res;
    }
}
