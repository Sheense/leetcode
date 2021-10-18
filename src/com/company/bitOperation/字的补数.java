package com.company.bitOperation;

/**
 * @Classname 字的补数
 * @Date 2021/10/18 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字的补数 {
    public int findComplement(int num) {
        int res = 0;
        for(int i = 0; i < 31; i++) {
            int a = 1 << i;
            if(a > num) {
                break;
            }
            if((num & (1 << i)) == 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
