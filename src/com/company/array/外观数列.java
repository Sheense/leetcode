package com.company.array;

public class 外观数列 {
    public static void main(String[] args) {
        外观数列 s = new 外观数列();
        System.out.println(s.countAndSay(6));
    }
    public String countAndSay(int n) {
        String num = "1";
        if(n==1) return num;
        for(int i=2;i<=n;i++) {
            int time = 0;
            int index = 0;
            char value = num.charAt(index);
            String res = "";
            while(index<num.length()) {
                if(num.charAt(index)==value) {
                    time++;
                    index++;
                }else{
                    res += time + String.valueOf(value);
                    time = 0;
                    value = num.charAt(index);
                }
            }
            res += time + String.valueOf(value);
            num = res;
        }
        return num;
    }
}
