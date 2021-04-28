package com.company.stack;

import java.util.ArrayList;
import java.util.List;

public class 括号 {

    public static void main(String[] args) {
        括号 s = new 括号();
        System.out.println(s.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        find(res, new StringBuilder(), 0 , n);
        return res;
    }

    public void find(List<String> res, StringBuilder now, int has, int n) {
        if (n == 0 ) {
            while (has!=0) {
                now.append(')');
                has--;
            }
            res.add(now.toString());
            return;
        }
        StringBuilder copy = new StringBuilder(now);

        now.append('(');
        find(res, now, has+1, n - 1);

        if(has > 0) {
            copy.append(')');
            find(res, copy, has - 1, n);
        }
    }
}
