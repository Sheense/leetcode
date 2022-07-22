package sheen.leetcode.dp;

import java.util.*;

/**
 * @Classname 超级丑数
 * @Date 2021/8/9 12:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 超级丑数 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);
        long num = 1L;
        while (n-- != 1) {
            num = queue.poll();
            n--;
            for(int i = 0; i < primes.length; i++) {
                long next = num * primes[i];
                if(!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }


        return (int)num;
    }
}
