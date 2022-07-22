package sheen.leetcode.recall;

import java.math.BigInteger;

public class 将字符串拆分为递减的连续值 {
    public static void main(String[] args) {
        将字符串拆分为递减的连续值 s = new 将字符串拆分为递减的连续值();
        System.out.println(s.splitString("99999999999999999998"));
    }
    public boolean splitString(String s) {
        return recall(s, 0, Long.MAX_VALUE, 0);
    }

    public boolean recall(String s, int start, long pre, int len) {
        if(start>= s.length()) {
            return len>1;
        }
        for(int i=start;i<s.length();i++) {
            BigInteger next = new BigInteger(s.substring(start, i + 1));
            if(next.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) >=1) break;

            long n = Long.parseLong(s.substring(start, i + 1));
            if((pre == n + 1 || pre == Long.MAX_VALUE)) {
                boolean flag = recall(s, i+1, n, len+1);
                if(flag) return true;
            }
        }
        return false;
    }
}
