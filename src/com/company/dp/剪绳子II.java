package com.company.dp;

import java.math.BigInteger;

public class 剪绳子II {

    public int cuttingRope(int n) {
        int mod = 1000000007;
        long[] arr = new long[n+1];
        BigInteger[] time = new BigInteger[n+1];
        time[1] = new BigInteger(String.valueOf(0));
        for(int i=2;i<=n;i++) {
            long v = 1;
            BigInteger t = new BigInteger(String.valueOf(0));
            for(int j = i-1;j>=1;j--) {
                long v1 = (arr[j] * (i-j)) % mod;
                BigInteger t1 =  time[j].multiply(new BigInteger(String.valueOf(i-j))).add(new BigInteger(String.valueOf(((arr[j] * (i-j)) / mod))));
                long v2 = (j * (i - j)) % mod;
                BigInteger t2 = new BigInteger(String.valueOf(j * (i - j) / mod));
                if(equals(t1, v1, t2, v2) >= 0) {
                    if(equals(t1,v1,t,v)>=0) {
                        t = t1;
                        v = v1;
                    }
                }else {
                    if(equals(t2,v2,t,v)>=0) {
                        t = t2;
                        v = v2;
                    }
                }
            }
            arr[i] = v;
            time[i] = t;
        }
        return (int)arr[n];
    }

    public int equals(BigInteger t1, long v1, BigInteger t2, long v2) {
        if(t1.compareTo(t2)<0) {
            return -1;
        }else if(t1.compareTo(t2)>0) {
            return 1;
        }else {
            if(v1 == v2) return 0;
            else if(v1 > v2) return 1;
            else return -1;
        }
    }
}
