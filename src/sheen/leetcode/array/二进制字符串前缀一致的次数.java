package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname 二进制字符串前缀一致的次数
 * @Date 2023/6/14 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二进制字符串前缀一致的次数 {
    public static void main(String[] args) {
        二进制字符串前缀一致的次数 s = new 二进制字符串前缀一致的次数();
        System.out.println(s.numTimesAllBlue(new int[]{3,2,4,1,5}));
    }
    public int numTimesAllBlue(int[] flips) {
        int res = 0;
        int[] arr = new int[flips.length];
        int num = 0;
        for(int i = 0; i < flips.length; i++) {
            if(flips[i] <= i + 1) {
                num++;
            }else {
                arr[flips[i] - 1] = 1;
            }
            if(arr[i] == 1) {
                num++;
            }

            if(num == i + 1) {
                res++;
            }
        }
        return res;
    }
}
