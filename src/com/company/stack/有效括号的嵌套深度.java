package com.company.stack;

import com.company.util.ArrayUtils;

public class 有效括号的嵌套深度 {

    public static void main(String[] args) {
        有效括号的嵌套深度 s = new 有效括号的嵌套深度();
        ArrayUtils.print(s.maxDepthAfterSplit("(()())"));
    }
    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int [] res = new int[chars.length];
        int d = 0;
        for(int i=0;i<chars.length;i++) {
            if(chars[i]=='(') {
                d++;
                res[i] = d%2;
            }else if(chars[i]==')'){
                res[i] = d%2;
                d--;
            }
        }
        return res;
    }
}
