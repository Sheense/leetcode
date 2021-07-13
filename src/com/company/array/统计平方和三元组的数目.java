package com.company.array;

public class 统计平方和三元组的数目 {
    public int countTriples(int n) {
        int res = 0;
        for(int i = 1; i <= n - 2; i++) {
            for(int j = i+1; j <= n - 1; j++) {
                for(int z = j + 1; z <= n ; z++){
                    if(Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(z, 2)) {
                        res += 2;
                    }
                }
            }
        }
        return res;
    }
}
