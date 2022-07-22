package sheen.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 寻找最近的回文数
 * @Date 2022/3/2 12:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 寻找最近的回文数 {
    public static void main(String[] args) {
        寻找最近的回文数 s = new 寻找最近的回文数();
        System.out.println(s.nearestPalindromic("1805170081"));
    }
    public String nearestPalindromic(String n) {
        List<Long> list = new ArrayList<>();
        long num = Long.parseLong(n);
        list.add((long)Math.pow(10, n.length() - 1) - 1);
        list.add((long)Math.pow(10, n.length()) + 1);

        long pre = Long.parseLong(n.substring(0, n.length() % 2 == 0 ? n.length() / 2 : n.length() / 2 + 1));
        long a = pre - 1;
        long b = pre + 1;
        long c = pre;
        list.add(rev(a, n.length()));
        list.add(rev(b, n.length()));
        list.add(rev(c, n.length()));

        long res = -1;
        for(long v : list) {
            if(check(v) && (Math.abs(num - v) < Math.abs(num - res) || (Math.abs(num - v) == Math.abs(num - res) ) && v < res) && num != v) {
                res = v;
            }
        }
        return String.valueOf(res);
    }

    public boolean check(long a) {
        String s = String.valueOf(a);
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public long rev(long a, int n) {
        if(n % 2 == 0) {
            long v = a;
            while (v != 0) {
                long yu = v % 10;
                v /= 10;
                a = a * 10 + yu;
            }
        }else {
            long v = a / 10;
            while (v != 0) {
                long yu = v % 10;
                v /= 10;
                a = a * 10 + yu;
            }
        }
        return a;
    }
}
