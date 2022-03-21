package com.company.array;

/**
 * @Classname 银行中的激光束数量
 * @Date 2022/1/2 10:41 上午
 * @Created by sheen
 * @Description TODO
 */
public class 银行中的激光束数量 {
    public int numberOfBeams(String[] bank) {
        int pre = 0;
        int res = 0;
        for(int i = 0; i < bank.length; i++) {
            int count = 0;
            for(int j = 0; j < bank[i].length(); j++) {
                if(bank[i].charAt(j) == '1') {
                    count ++;
                }
            }
            res += count * pre;
            if(count != 0) {
                pre = count;
            }
        }
        return res;
    }
}
