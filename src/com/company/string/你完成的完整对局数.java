package com.company.string;

public class 你完成的完整对局数 {
    public int numberOfRounds(String startTime, String finishTime) {
        String[] s1 = startTime.split(":");
        String[] s2 = finishTime.split(":");

        int h1 = Integer.parseInt(s1[0]);
        int m1 = Integer.parseInt(s1[1]) % 15 != 0 ? Integer.parseInt(s1[1]) / 15 +1 : Integer.parseInt(s1[1]) / 15;

        int h2 = Integer.parseInt(s2[0]);
        int m2 = Integer.parseInt(s2[1]) / 15;

        int res = 0;
        if (h2 > h1) {
            res = 4 - m1 + m2;
            h1++;
            res += (h2 - h1) * 4;
        }else if(h2 == h1 && m1 <= m2){
            res = m2 - m1;
        }else {
            h2 += 24;
            res = 4 - m1 + m2;
            h1++;
            res += (h2 - h1) * 4;
        }
        return res;
    }
}
