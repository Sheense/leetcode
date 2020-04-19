package com.company.string;

import java.util.ArrayList;
import java.util.List;

public class 数青蛙 {

    public static void main(String[] args) {
        数青蛙 s = new 数青蛙();
        System.out.println(s.minNumberOfFrogs("crocakcroraoakk"));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
         int c = 0;
         int r = 0;
         int o = 0;
         int a = 0;
         int res = 0;
         for(int i=0;i<croakOfFrogs.length();i++) {
             switch (croakOfFrogs.charAt(i)) {
                 case 'c':{
                     c++;
                     if(c>res) res = c;
                     break;
                 }
                 case 'r':++r;break;
                 case 'o':++o;break;
                 case 'a':++a;break;
                 case 'k':{
                     c--;
                     r--;
                     o--;
                     a--;
                     break;
                 }
             }
             if(c<r||r<o||o<a) return -1;
         }
         if(c==0&&r==0&&o==0&&a==0) {
             return res;
         }else {
             return -1;
         }
    }
}
