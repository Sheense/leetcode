package com.company.array;

/**
 * @Classname _1比特与2比特字符
 * @Date 2022/2/20 1:47 上午
 * @Created by sheen
 * @Description TODO
 */
public class _1比特与2比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if(bits[i] == 0) {
                i++;
            }else {
                i+= 2;
            }
        }
        if(i == bits.length - 1 && bits[i] == 0) {
            return true;
        }

        return false;
    }
}
