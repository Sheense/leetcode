package com.company.string;

public class Z字形变换 {
    public static void main(String[] args) {
        Z字形变换 s = new Z字形变换();
        System.out.println(s.convert("LEETCODEISHIRING",1));
    }
    public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        char[] res = new char[s.length()];
        int index = 0;
        char[] chars = s.toCharArray();
        int interval = numRows*2 - 2;
        for(int i=0;i<numRows;i++) {
            if(i==0||i==numRows-1) {
                for(int j=i;j<chars.length;j=j+interval) {
                    res[index++] = chars[j];
                }
                continue;
            }

            for(int j=i;j<chars.length;j=j+interval) {
                res[index++] = chars[j];
                int next = j+(numRows-(i+1))*2;
                if(next<chars.length) res[index++]=chars[next];
            }
        }
        return new String(res);
    }
}
