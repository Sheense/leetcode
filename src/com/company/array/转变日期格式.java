package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 转变日期格式 {

    public static void main(String[] args) {
        转变日期格式 s = new 转变日期格式();
        System.out.println(s.reformatDate("6th Jun 1933"));
    }
    public String reformatDate(String date) {
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] strings = date.split(" ");
        String res = "";
        for(int i=2;i>=0;i--) {
            if(i==2) {
                res+=strings[i] + "-";
            }
            if(i==1) {
                for(int j=0;j<month.length;j++) {
                    if(month[j].equals(strings[i])) {
                        if(j+1>=10) {
                            j++;
                            res+=j;
                        }else {
                            j++;
                            res+="0"+j;
                        }
                        res+="-";
                        break;
                    }
                }
            }
            if(i==0) {
                res+= strings[i].length()==4?strings[i].substring(0,2):"0"+strings[i].substring(0,1);
            }
        }
        return res;
    }
}
