package com.company.queue;

import java.math.BigInteger;
import java.util.*;

public class 销售价值减少的颜色球_优先队列 {

    public static void main(String[] args) {
        销售价值减少的颜色球_优先队列 s = new 销售价值减少的颜色球_优先队列();
        System.out.println(s.maxProfit(new int[]{1000000000}, 1000000000));
    }
    public int maxProfit(int[] inventory, int orders) {
        Queue<Integer> pq = new PriorityQueue<>(11, (i1, i2) -> i2 - i1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inventory.length;i++) {
            if(map.containsKey(inventory[i])) {
                map.put(inventory[i], map.get(inventory[i])+1);
            } else {
                pq.add(inventory[i]);
                map.put(inventory[i], 1);
            }
        }
        int res = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        while(orders!=0) {
            int value = pq.poll();
            int time = map.get(value);
            int next= pq.size() == 0 ? 0 : pq.peek();
            if (time*(value-next)<orders) {
                orders -= time*(value-next);
                int a = BigInteger.valueOf(value+next+1)
                        .multiply(BigInteger.valueOf(value-next))
                       .divideAndRemainder(BigInteger.valueOf(2))[0]
                        .divideAndRemainder(BigInteger.valueOf(mod))[1]
                        .multiply(BigInteger.valueOf(time))
                        .divideAndRemainder(BigInteger.valueOf(mod))[1].intValue();
                res = (int)(((long)res + a) % mod);
                map.remove(value);
                map.put(next, map.get(next) + time);
            } else {
                int q = orders / time;
                int yu = orders % time;
                int n = BigInteger.valueOf(value+value-q+1).multiply(BigInteger.valueOf(q))
                        .divideAndRemainder(BigInteger.valueOf(2))[0]
                        .divideAndRemainder(BigInteger.valueOf(mod))[1]
                        .multiply(BigInteger.valueOf(time))
                        .divideAndRemainder(BigInteger.valueOf(mod))[1]
                        .intValue();
                int m = value - q ;
                res += BigInteger.valueOf(m)
                        .multiply(BigInteger.valueOf(yu))
                        .divideAndRemainder(BigInteger.valueOf(mod))[1]
                        .intValue();
                res = (int)(((long)res + n) % mod);
                orders = 0;
            }
        }
        return res;
    }
}
