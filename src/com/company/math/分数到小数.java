package com.company.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 分数到小数
 * @Date 2021/10/3 3:16 下午
 * @Created by sheen
 * @Description TODO
 */
public class 分数到小数 {
    public static void main(String[] args) {
        分数到小数 s = new 分数到小数();
        System.out.println(s.fractionToDecimal(1, 333));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        String res = "";
        if(a * b < 0) {
            res += "-";
        }

        a = Math.abs(a);
        b = Math.abs(b);

        res += (a / b);
        a = a % b;

        Map<Long, Integer> map = new HashMap<>();
        String item = "";

        while (!map.containsKey(a)) {
            if(a == 0) {
                break;
            }
            map.put(a, item.length());
            a *= 10;
            if(a < b) {
                while (a < b) {
                    item += "0";
                    a *= 10;
                }
            }
            int q = (int)(a/b);
            item += q;
            a = a % b;
        }

        if(a == 0) {
            if(item.length() > 0) {
                res += ".";
            }
            res += item;
        }else {
            String sub = item.substring(map.get(a));
            res += ".";
            res += item.substring(0, map.get(a));
            res += "(";
            res += sub;
            res += ")";
        }
        return res;
    }
}
