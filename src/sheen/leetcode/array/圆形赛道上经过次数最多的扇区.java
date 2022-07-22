package sheen.leetcode.array;

import java.util.*;

public class 圆形赛道上经过次数最多的扇区 {
    public static void main(String[] args) {
        圆形赛道上经过次数最多的扇区 s = new 圆形赛道上经过次数最多的扇区();
        System.out.println(s.mostVisited(2, new int[]{2,1,2,1,2,1,2,1,2}));
    }
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] map = new int[n];
        int max = 1;
        map[rounds[0]-1]++;
        for(int i=0;i<rounds.length-1;i++) {
            int start = rounds[i]%n;
            int end = rounds[i+1]-1;
            while(start!=end) {
                map[start]++;
                if(map[start]>max) max = map[start];
                start=(++start)%n;
            }
            map[end] ++;
            if(map[end]>max) max = map[end];
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(map[i]==max) {
                res.add(i+1);
            }
        }
        return res;
    }
}
