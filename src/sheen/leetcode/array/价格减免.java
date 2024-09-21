package sheen.leetcode.array;

import java.text.DecimalFormat;

/**
 * @Classname 价格减免
 * @Date 2022/5/29 10:37 上午
 * @Created by sheen
 * @Description TODO
 */
public class 价格减免 {
    public static void main(String[] args) {
        价格减免 s = new 价格减免();
        System.out.println(s.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }
    public String discountPrices(String sentence, int discount) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String[] strs = sentence.split(" ");
        for(int i = 0; i < strs.length; i++) {
            char c = strs[i].charAt(0);
            if(c == '$') {
                double v = 0;
                boolean flag = true;
                try {
                    String str = strs[i].substring(1);
                    if (check(str)) {
                        v = Double.parseDouble(str);
                    }else {
                        flag = false;
                    }
                }catch (Exception e) {
                    flag = false;
                    continue;
                }

                if(flag) {
                    v = v - (v * discount) / 100 ;
                    strs[i] = "$" + df.format(v);
                }
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

    public boolean check(String str) {
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) != '.') {
                if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return false;
                }
            }

            i++;
        }
        return true;
    }
}
