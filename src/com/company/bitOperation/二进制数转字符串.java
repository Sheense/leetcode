package com.company.bitOperation;

public class 二进制数转字符串 {
    public static void main(String[] args) {
        二进制数转字符串 s = new 二进制数转字符串();
        System.out.println(s.printBin(0.625));
    }
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        double item = 1;
        for(int i=1;i<=30;i++) {
            item = item * 0.5;
            if(num == 0.0) break;
            if(num>=item) {
                sb.append('1');
                num -= item;
            }else {
                sb.append('0');
            }
        }
        if(num>0) {
            return "ERROR";
        }
        return sb.toString();
    }
}
