package com.company.string;

import java.util.Stack;

public class 基本计算器II {

    public static void main(String[] args) {
        基本计算器II s = new 基本计算器II();
        System.out.println(s.calculate("282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024"));
    }
    public int calculate(String s) {
        int index = 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> fu = new Stack<>();
        while(index<s.length()) {
            switch (s.charAt(index)) {
                case '+':{
                    fu.push('+');
                    index++;
                    break;
                }
                case '-':{
                    fu.push('-');
                    index++;
                    break;
                }
                case '*':{
                    fu.push('*');
                    index++;
                    break;
                }
                case '/':{
                    fu.push('/');
                    index++;
                    break;
                }
                case ' ': {
                    index++;
                    break;
                }
                default:{
                    int value = 0;
                    while(index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9') {
                        if(s.charAt(index)!=' ') {
                            value = value*10 + (s.charAt(index)-'0');
                        }
                        index++;
                    }
                    if(!fu.isEmpty()&&fu.peek()!='+') {
                        char f = fu.pop();
                        int n = nums.pop();
                        if(f=='*') {
                            nums.push(n*value);
                        }else if(f=='/'){
                            nums.push(n/value);
                        }else if(f=='-') {
                            while(index<s.length()&&s.charAt(index)==' ') {
                                index++;
                            }
                            if(index<s.length()&&s.charAt(index)!='*'&&s.charAt(index)!='/'&&(fu.isEmpty()||fu.peek()!='-')){
                                nums.push(n - value);
                            }else {
                                fu.push(f);
                                nums.push(n);
                                nums.push(value);
                            }
                        }
                    }else {
                        nums.push(value);
                    }
                }
            }
        }
        int res = nums.pop();
        while (!fu.isEmpty()) {
            char f = fu.pop();
            if(f=='+') {
                if(fu.isEmpty()||fu.peek()=='+') {
                    res = nums.pop()+res;
                }else {
                    res = nums.pop()-res;
                }
            }else if(f=='-'){
                if(fu.isEmpty()||fu.peek()=='+') {
                    res = nums.pop()-res;
                }else {
                    res = nums.pop()+res;
                }

            }
        }
        return res;
    }


}
