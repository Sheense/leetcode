package com.company.window;

import com.company.util.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最短超串 {
    public static void main(String[] args) {
        最短超串 s = new 最短超串();
        ArrayUtils.print(s.shortestSeq(new int[]{7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7}, new int[]{1,5,9}));
    }
    public int[] shortestSeq(int[] big, int[] small) {
        int len = Integer.MAX_VALUE;
        int [] res = new int[2];
        if(big.length < small.length) return new int[]{};
        Set<Integer> noHas = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<small.length;i++) {
            noHas.add(small[i]);
            set.add(small[i]);
        }
        int left = 0;
        int right = 0;
        Map<Integer, Integer> has = new HashMap<>();
        while (right<big.length) {
            if(!set.contains(big[left])) {
                left++;
                right++;
                continue;
            }
            while (right<big.length && !noHas.isEmpty()) {
                if(set.contains(big[right])) {
                    noHas.remove(big[right]);
                    has.put(big[right], has.getOrDefault(big[right],0)+1);
                }
                right++;
            }
            if(noHas.isEmpty()&&len > (right - left)) {
                len = right - left;
                res[0] = left;
                res[1] = right-1;
            }
            has.put(big[left], has.get(big[left])-1);
            if(has.get(big[left])==0) {
                noHas.add(big[left]);
            }
            left++;
            while (left<right&&!set.contains(big[left])) {
                left++;
            }
        }
        if(noHas.isEmpty() &&len > (right - left)) {
            len = right - left;
            res[0] = left;
            res[1] = right-1;
        }
        if(Integer.MAX_VALUE == len) return new int[]{};
        return res;
    }
}
