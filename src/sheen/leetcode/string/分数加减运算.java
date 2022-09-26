package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 分数加减运算
 * @Date 2022/7/27 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 分数加减运算 {
    public static void main(String[] args) {
        分数加减运算 s = new 分数加减运算();
        System.out.println(s.fractionAddition("-1/2+1/2+1/3"));
    }
    public String fractionAddition(String expression) {
        List<String[]> list = new ArrayList<>();
        int i = 0;
        while (i < expression.length()) {
            String[] item = new String[3];
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                item[0] = String.valueOf(expression.charAt(i));
                i++;
            }else {
                item[0] = "+";
            }

            int index = i;
            while (i < expression.length() && expression.charAt(i) != '/') {
                i++;
            }
            item[1] = expression.substring(index, i);
            i++;
            index = i;
            while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                i++;
            }
            item[2] = expression.substring(index, i);
            list.add(item);
        }
        String[] res = list.get(0);
        for(int j = 1; j < list.size(); j++) {
            res = and(res, list.get(j));
        }

        return (res[0].equals("-") ? res[0] : "") + res[1] + "/" + res[2];
    }

    public String[] and(String[] a, String[] b) {
        int aZ = Integer.valueOf(a[1]);
        int aM = Integer.valueOf(a[2]);

        int bZ = Integer.valueOf(b[1]);
        int bM = Integer.valueOf(b[2]);

        String[] res = new String[3];
        if(a[0].equals("+") && b[0].equals("+")) {
            res[0] = "+";
            int allZ = aZ * bM + bZ * aM;
            int allM = aM * bM;
            int mod = mod(Math.max(allM, allZ), Math.min(allM, allZ));
            res[1] = String.valueOf(allZ / mod);
            res[2] = String.valueOf(allM / mod);
        }else if(a[0].equals("-") && b[0].equals("-")) {
            res[0] = "-";
            int allZ = aZ * bM + bZ * aM;
            int allM = aM * bM;
            int mod = mod(Math.max(allM, allZ), Math.min(allM, allZ));
            res[1] = String.valueOf(allZ / mod);
            res[2] = String.valueOf(allM / mod);
        }else if(a[0].equals("-") && b[0].equals("+")) {
            int allZ = -aZ * bM + bZ * aM;
            if(allZ >= 0) {
               res[0] = "+";
            }else {
                res[0] = "-";
                allZ = Math.abs(allZ);
            }
            int allM = aM * bM;
            int mod = mod(Math.max(allM, allZ), Math.min(allM, allZ));
            res[1] = String.valueOf(allZ / mod);
            res[2] = String.valueOf(allM / mod);
        }else {
            int allZ = aZ * bM - bZ * aM;
            if(allZ >= 0) {
                res[0] = "+";
            }else {
                res[0] = "-";
                allZ = Math.abs(allZ);
            }
            int allM = aM * bM;
            int mod = mod(Math.max(allM, allZ), Math.min(allM, allZ));
            res[1] = String.valueOf(allZ / mod);
            res[2] = String.valueOf(allM / mod);
        }
        return res;
    }

    public int mod(int a, int b) {
        if(b == 0) {
            return a;
        }
        int yu = a % b;
        return mod(b, yu);
    }
}
