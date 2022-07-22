package sheen.leetcode.sort;

import java.util.Arrays;

public class 消灭怪物的最大数量 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] minute = new int[dist.length];
        for(int i = 0; i < dist.length; i++) {
            minute[i] = (int)Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(minute);
        int now = 0;
        for(int i = 0 ; i < minute.length; i++) {
            if(now >= minute[i]) {
                return i;
            }
            now++;
        }
        return dist.length;
    }
}
