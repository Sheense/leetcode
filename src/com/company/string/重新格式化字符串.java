package com.company.string;

public class 重新格式化字符串 {

    public static void main(String[] args) {
        重新格式化字符串 s = new 重新格式化字符串();
        System.out.println(s.reformat("covid2019"));
    }

    public String reformat(String s) {
        char[] num = new char[s.length()];
        char[] zimu = new char[s.length()];
        int i=0;
        int j=0;
        for(int z=0;z<s.length();z++) {
            if(s.charAt(z)>='a'&&s.charAt(z)<='z'){
                zimu[j] = s.charAt(z);
                j++;
            }
            if(s.charAt(z)>='0'&&s.charAt(z)<='9'){
                num[i] = s.charAt(z);
                i++;
            }
        }
        if(i==j+1||i==j||j==i+1) {
            int q = 0;
            int p = 0;
            StringBuilder sb = new StringBuilder();
            while(q!=i||p!=j) {
                if(i>=j) {
                    if(q!=i) {
                        sb.append(num[q]);
                        q++;
                    }
                    if(p!=j) {
                        sb.append(zimu[p]);
                        p++;
                    }
                }else {
                    if(p!=j) {
                        sb.append(zimu[p]);
                        p++;
                    }
                    if(q!=i) {
                        sb.append(num[q]);
                        q++;
                    }
                }
            }
            return sb.toString();
        }else {
            return "";
        }
    }
}
