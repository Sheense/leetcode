package com.company.stack;

public class 括号的分数 {

    public static void main(String[] args) {
        括号的分数 s = new 括号的分数();
        System.out.println(s.scoreOfParentheses("(()(()))"));
    }


    public int scoreOfParentheses(String S) {
        if(S.length()==0) return 0;
        char[] chars = S.toCharArray();
        int res = 0;
        int num = 0;
        int i = 0;
        while(i<chars.length) {
            if(chars[i]=='(') {
                num ++;
                i++;
            }else {
                if(num==1)  {
                    res += 1;
                    num --;
                    i++;
                } else {
                    res += Math.pow(2, num-1);
                    num--;
                    i++;
                    while(i<chars.length&&chars[i]==')') {
                       num--;
                       i++;
                    }
                }
            }
        }
        return res;
    }
}
