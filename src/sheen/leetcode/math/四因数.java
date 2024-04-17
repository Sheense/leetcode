package sheen.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 四因数
 * @Date 2023/5/5 12:17 下午
 * @Created by sheen
 * @Description TODO
 */
public class 四因数 {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> set = find(nums[i]);
            if(set.size() == 4) {
                for(int v : set) {
                    res += v;
                }
            }
        }
        return res;
    }

    public Set<Integer> find(int v) {
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
