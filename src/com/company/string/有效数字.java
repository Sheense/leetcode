package com.company.string;

public class 有效数字 {

    public static void main(String[] args) {
        有效数字 s = new 有效数字();
       System.out.println(Double.valueOf("-3"));
        System.out.println(s.isNumber("44e016912630333"));
    }
    public boolean isNumber(String s) {
        int eCount = 0;
        int eIndex = -1;
        for(int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >='a' & s.charAt(i) <= 'z' && s.charAt(i) != 'e') ||
                (s.charAt(i) >='A' & s.charAt(i) <= 'Z' && s.charAt(i) != 'E') ) {
                return false;
            }

            if(eCount > 1 && s.charAt(i) == '.') {
                return false;
            }

            if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                eCount++;
                if(eCount == 1) eIndex = i;
            }
        }
        if (eCount == 0) {
            try {
                Double.valueOf(s);
            }catch (NumberFormatException e) {
                return false;
            }
            return true;
        } else if(eCount == 1){
            if(eIndex == s.length() - 1) return false;
            try {
                Double.valueOf(s.substring(0, eIndex));
            }catch (NumberFormatException e) {
                return false;
            }

            double num = 0.0;
            try {
                num = Double.valueOf(s.substring(eIndex +1));
            }catch (NumberFormatException e) {
                return false;
            }
            if(num - (long)num > 0) return false;
            return true;
        }else{
            return false;
        }
    }
}
