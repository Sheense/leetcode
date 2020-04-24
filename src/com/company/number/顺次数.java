package com.company.number;

import java.util.ArrayList;
import java.util.List;

public class 顺次数 {

    public static void main(String[] args) {
        顺次数 s = new 顺次数();
        System.out.println(s.sequentialDigits(58,Integer.MAX_VALUE));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        int start = low/(int)Math.pow(10,9)!=0?10:0;
        int end = high/(int)Math.pow(10,9)!=0?10:0;
        while((low/(int)Math.pow(10,start)!=0&&low/(int)Math.pow(10,9)==0)||high/(int)Math.pow(10,end)!=0&&high/(int)Math.pow(10,9)==0) {
            if(low/(int)Math.pow(10,start)!=0&&low/(int)Math.pow(10,9)==0) start++;
            if(high/(int)Math.pow(10,end)!=0&&high/(int)Math.pow(10,9)==0) end++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=start;i<=end;i++) {
             if(i==10) {
                 break;
             }
             int s = low/(int)Math.pow(10,i-1);
             if(s<=10-i) {
                 int num = 0;
                 int index = s;
                 for(int j=i-1;j>=0;j--) {
                     num += index*Math.pow(10,j);
                     index++;
                 }
                 while(s<=10-i) {
                     if(num<=high) {
                         if(num>=low) res.add(num);
                     }
                     else break;
                     int wei = num%10;
                     num %= Math.pow(10, i-1);
                     num = num*10+wei+1;
                     s = num/(int)Math.pow(10,i-1);
                 }
             }
             low = (int)Math.pow(10,i);
        }
        return res;
    }
}
