package com.company.array;

public class 总持续时间可被60整除的歌曲 {
    public int numPairsDivisibleBy60(int[] time) {
        int [] map = new int[60];
        int res = 0;
        for(int i=0;i<time.length;i++) {
            int item = time[i]%60;
            int key = 60-item;
            if(key==60) {
                res += map[0];
            }else {
                res += map[key];
            }
            map[item]++;
        }
        return res;
    }
}
