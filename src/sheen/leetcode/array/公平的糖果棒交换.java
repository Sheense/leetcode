package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class 公平的糖果棒交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int allA = 0;
        int allB = 0;
        int indexI = 0;
        int indexJ = 0;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        while(indexI<A.length||indexJ<B.length) {
            if(indexI<A.length) {
                setA.add(A[indexI]);
                allA += A[indexI++];
            }
            if(indexJ<B.length) {
                setB.add(B[indexJ]);
                allB += B[indexJ++];
            }
        }
        int v = Math.abs((allA-allB)/2);
        if(allA>=allB) {
            for(int i=v+1;i<=100000;i++) {
                if(setA.contains(i)&&setB.contains(i-v)) {
                    return new int[]{i, i-v};
                }
            }
        }else {
            for(int i=v+1;i<=100000;i++) {
                if(setB.contains(i)&&setA.contains(i-v)) {
                    return new int[]{i-v, i};
                }
            }
        }
        return new int[]{};
    }
}
