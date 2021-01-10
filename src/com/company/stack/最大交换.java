package com.company.stack;

import java.util.Comparator;
import java.util.Stack;

public class 最大交换 {
    public int maximumSwap(int num) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = String.valueOf(num).toCharArray();
        char[] res = String.valueOf(num).toCharArray();
        for(int i=0;i<chars.length;i++) {
            for(int j=i+1;j<chars.length;j++) {
                res = comparator(i, j, res, num);
            }
        }
        return Integer.parseInt(String.valueOf(res));

    }
    private char[] comparator(int top, int down, char[] a, int instance) {
        char[] b = String.valueOf(instance).toCharArray();
        b[top] = (char)(b[top] + b[down]);
        b[down] = (char)(b[top] - b[down]);
        b[top] = (char)(b[top] - b[down]);
        for(int i=0;i<a.length;i++) {
            if(a[i]>b[i]) return a;
            else if(a[i]<b[i]) return b;
        }
        return a;
    }
}
