package sheen.leetcode.math;

import java.util.*;

/**
 * @Classname 强整数
 * @Date 2023/5/2 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 强整数 {
    public static void main(String[] args) {
        强整数 s = new 强整数();
        System.out.println(s.powerfulIntegers(2, 1, 10));
    }
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if(bound == 0) {
            return new ArrayList<>();
        }

        if(x == 1 && y == 1) {
            if(bound > 1) {
                return Collections.singletonList(2);
            }
            return new ArrayList<>();
        }

        if(x == 1) {
            int i = 0;
            List<Integer> res = new ArrayList<>();
            while (Math.pow(y, i) <= bound) {
                res.add((int)Math.pow(y, i) + 1);
                i++;
            }
            return res;
        }

        if(y == 1) {
            int i = 0;
            List<Integer> res = new ArrayList<>();
            while (Math.pow(x, i) <= bound) {
                res.add((int)Math.pow(x, i) + 1);
                i++;
            }
            return res;
        }

        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (Math.pow(x, i) <= bound) {
            int v = (int)Math.pow(x, i);
            int j = 0;
            while (Math.pow(y, j) + v <= bound) {
                set.add((int)Math.pow(y, j) + v);
                j++;
            }
            i++;
        }
        return new ArrayList<>(set);
    }
}
