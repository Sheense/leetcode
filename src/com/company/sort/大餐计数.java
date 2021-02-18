package com.company.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 大餐计数 {
    public static void main(String[] args) {
        System.out.println((100000*99999)/2%((int)Math.pow(10,9)+7));
    }
    public int countPairs(int[] deliciousness) {
        Map<Long, Long> map = new HashMap<>();
        int res = 0;
        int mod = (int)Math.pow(10,9)+7;
        for (int i=0;i<deliciousness.length;i++) {
            map.put((long)deliciousness[i], map.getOrDefault((long)deliciousness[i], 0L)+1);
        }
        List<Long> list = new ArrayList<>(map.keySet());
        for(long key:list) {
            long num = map.get(key);
            if (num <= 0) continue;
            for(int i=0;i<=40;i++) {
                long all = (long)Math.pow(2 ,i);
                if(all-key==key) {
                    int a = (int)(((num*(num-1))/2)%mod);
                    res += a;
                }else if(map.containsKey(all-key)){
                    int a = (int)((map.get(all-key)*num)%mod);
                    res += a;
                }
                res %= mod;
            }
            map.remove(key);
        }
        return res;
    }
}
