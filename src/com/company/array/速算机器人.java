package com.company.array;

public class 速算机器人 {
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for(int i=0;i<s.length();i++) {
            switch (s.charAt(i)) {
                case 'A':{
                   x = 2*x +y;
                   break;
                }
                case 'B':{
                    y = 2*y + x;
                    break;
                }
            }
        }
        return x + y;
    }
}
