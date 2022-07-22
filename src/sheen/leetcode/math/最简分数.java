package sheen.leetcode.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 最简分数
 * @Date 2022/2/10 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最简分数 {
    public static void main(String[] args) {
        最简分数 s = new 最简分数();
        System.out.println(s.simplifiedFractions(1));
    }
    public List<String> simplifiedFractions(int n) {
        Set<String> set = new HashSet<>();
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                int c = process(i, j);
                int m = i / c;
                int z = j / c;
                set.add(z + "/" + m);
            }
        }
        return new ArrayList<>(set);
    }

    public int process(int a, int b) {
        if(b == 0) {
            return a;
        }
        int c = a % b;
        return process(b, c);
    }
}
