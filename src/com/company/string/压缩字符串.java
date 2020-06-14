package com.company.string;

public class 压缩字符串 {

    public int compress(char[] chars) {
        int i =0;
        int index = 0;
        while(i<chars.length) {
            int time = 1;
            int item = chars[i];
            while(++i<chars.length&&chars[i]==item) {
                time++;
            }
            chars[index++] = (char) item;
            if(time!=1) {
                while(time/10!=0) {
                    chars[index++] = (char)(time/10+'0');
                    time%=10;
                }
                chars[index++] = (char) (time+'0');
            }
        }
        return index;
    }
}
