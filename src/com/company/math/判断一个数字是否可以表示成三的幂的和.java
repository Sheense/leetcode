package com.company.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 判断一个数字是否可以表示成三的幂的和 {
    public static void main(String[] args) {
        判断一个数字是否可以表示成三的幂的和 s = new 判断一个数字是否可以表示成三的幂的和();
        System.out.println(s.checkPowersOfThree(14));
    }
    public boolean checkPowersOfThree(int n) {
        int last = -1;
        while (n > 0) {
            int item = 1;
            while(item*3<=n) {
                item *= 3;
            }
            if(item == last) {
                return false;
            }
            n -= item;
            last = item;
        }
        return true;
    }




}
