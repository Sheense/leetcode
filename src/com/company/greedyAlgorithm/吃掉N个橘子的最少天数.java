package com.company.greedyAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class 吃掉N个橘子的最少天数 {

    public static void main(String[] args) {
        吃掉N个橘子的最少天数 s = new 吃掉N个橘子的最少天数();
        System.out.println(s.minDays(1569034053));
    }
    public int minDays(int n) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        find(n, map1,map2, 0);
        System.out.println(map1);
        System.out.println(map2);
        return map2.get(0);
    }

    public void find(int n, Map<Integer, Integer> map1, Map<Integer, Integer> map2, int num) {
        if(n==0) {
            map1.put(num, 0);
            map2.put(0, num);
            return;
        }
        int time = 0;
        int value = n;
        while(value%3!=0) {
            time++;
            value--;
        }
        int yu1 = value/3;
        int num1 = 0;
        if(value == 0) {
            num1 = time;
        }else {
            num1 = time+1;
        }
        if(!map1.containsKey(num1+num)||yu1<map1.get(num1+num)){
           map1.put(num1+num, yu1);
           if(!map2.containsKey(yu1)||(num1+num<map2.get(yu1))) {
               map2.put(yu1, num1+num);
               find(yu1, map1, map2,num1+num);
           }
        }else {
            if(!map2.containsKey(yu1)||(num1+num<map2.get(yu1))) {
                map2.put(yu1, num1+num);
                find(yu1, map1, map2,num1+num);
            }
        }

        value = n;
        if(value%2==1) {
            time = 1;
            value--;
        }else {
            time = 0;
        }
        int yu2 = n - time - value/2;
        int num2 = 0;
        if(value==0) {
            num2 = time;
        }else {
            num2 = time + 1;
        }
        if(!map1.containsKey(num2+num)||yu2<map1.get(num2+num)) {
            map1.put(num2+num, yu2);
            if(!map2.containsKey(yu2)||(num2+num<map2.get(yu2))) {
                map2.put(yu2, num2+num);
                find(yu2, map1, map2,num2+num);
            }
        }else {
            if(!map2.containsKey(yu2)||(num2+num<map2.get(yu2))) {
                map2.put(yu2, num2+num);
                find(yu2, map1, map2,num2+num);
            }
        }
    }

    /*public int minDays(int n) {
        if(n==0) return 0;
        int time1 = 0;
        int value1 = n;
        int num1= 0;
        while(value1%3!=0) {
            value1--;
            time1++;
        }
        int yu1 = value1/3;
        if(value1==0) {
            num1 = time1;
        }else {
            num1 = time1+1;
        }
        int res1 = minDays(yu1) + num1;

        int time2 = 0;
        int value2 = n;
        int num2= 0;
        if(value2%2!=0) {
            value2--;
            time2++;
        }
        int yu2 = value2/2;
        if(value2==0) {
            num2 = time2;
        }else {
            num2 = time2+1;
        }
        int res2 = minDays(yu2)+num2;
        return Math.min(res1, res2);
    }*/
}
