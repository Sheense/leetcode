package com.company.array;

import java.util.HashSet;
import java.util.Set;

public class 等价多米诺骨牌对的数量 {
    public static void main(String[] args) {
        等价多米诺骨牌对的数量 s = new 等价多米诺骨牌对的数量();
        System.out.println(s.numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}}));
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        int res = 0;
        for(int i=0;i<dominoes.length;i++) {
            int v = dominoes[i][0]>dominoes[i][1]?(dominoes[i][0]*10+dominoes[i][1]):(dominoes[i][1]*10+dominoes[i][0]);
            map[v]++;
        }
        for(int i=0;i<map.length;i++) {
            if(map[i]>1) {
                res += (map[i]*(map[i]-1))/2;
            }
        }
        return res;
    }
}
