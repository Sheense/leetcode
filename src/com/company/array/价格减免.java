package com.company.array;

import java.text.DecimalFormat;

/**
 * @Classname 价格减免
 * @Date 2022/5/29 10:37 上午
 * @Created by sheen
 * @Description TODO
 */
public class 价格减免 {
    public String discountPrices(String sentence, int discount) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String[] strs = sentence.split(" ");
        for(int i = 0; i < strs.length; i++) {
            char c = strs[i].charAt(0);
            if(c == '$') {
                double v;
                try {
                    v = Double.parseDouble(strs[i].substring(1));
                }catch (Exception e) {
                    continue;
                }

                v = v - (v * discount) / 100 ;
                strs[i] = "$" + df.format(v);
            }
        }
        String res = "";
        for(int i = 0; i < strs.length; i++) {
            res += strs[i];
            if(i != strs.length - 1) {
                res += " ";
            }
        }

        return res;
    }
}
