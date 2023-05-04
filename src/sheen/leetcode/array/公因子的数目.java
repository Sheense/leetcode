package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 公因子的数目
 * @Date 2023/4/5 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 公因子的数目 {
    public int commonFactors(int a, int b) {
        int res = 0;
        Set<Integer> s1 = getY(a);
        Set<Integer> s2 = getY(b);
        for(int v1 : s1) {
            if(s2.contains(v1)) {
                res++;
            }
        }
        return res;
    }

    public Set<Integer> getY(int v) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= (int)Math.sqrt(v); i++) {
            if(v % i == 0) {
                set.add(i);
                set.add(v / i);
            }
        }
        return set;
    }
}
