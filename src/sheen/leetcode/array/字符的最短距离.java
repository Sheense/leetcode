package sheen.leetcode.array;

import java.util.TreeSet;

/**
 * @Classname 字符的最短距离
 * @Date 2022/4/19 12:28 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字符的最短距离 {
    public int[] shortestToChar(String s, char c) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                treeSet.add(i);
            }
        }

        int[] res = new int[s.length()];
        for(int i = 0; i < res.length; i++) {
            Integer a = treeSet.ceiling(i);
            Integer b = treeSet.floor(i);
            if(a == null) {
                res[i] = Math.abs(b - i);
            }else if(b == null) {
                res[i] = Math.abs(a - i);
            }else {
                res[i] = Math.min(Math.abs(a - i), Math.abs(b - i));
            }
        }
        return res;
    }
}
