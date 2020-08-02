package com.company.sort;

import java.util.*;

public class 最大数 {

    public static void main(String[] args) {
        最大数 s = new 最大数();
        System.out.println(s.largestNumber(new int[]{3,30,34,5,9}));
    }
    public String largestNumber(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            String value = String.valueOf(nums[i]);
            map.computeIfAbsent(value.charAt(0)-'0', x->new ArrayList<>()).add(nums[i]);
        }
        Map<Integer, String> res = new HashMap<>();
        for(int key:map.keySet()) {
            List<Integer> list = map.get(key);
            if(key!=0) {
                sort(list);
            }
            String r = "";
            for(int i=0;i<list.size();i++) {
                r+=list.get(i);
            }
            res.put(key, r);
        }
        List<Integer> l = new ArrayList<>(res.keySet());
        Collections.sort(l);
        String string = "";
        for(int i=l.size()-1;i>=0;i--) {
            if(i==l.size()-1&&l.get(i)==0) {
                return "0";
            }
            string+=res.get(l.get(i));
        }
        return string;
    }

    public void sort(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
            int j = i-1;
            int value = list.get(i);
            String a = String.valueOf(value);
            while(j>=0) {
                String b = String.valueOf(list.get(j));
                String s1 = a+b;
                String s2 = b+a;
                if(compare(s1,s2)){
                    break;
                }else {
                    list.set(j+1,list.get(j));
                }
                j--;
            }
            list.set(j+1, value);
        }
    }

    public boolean compare(String s1, String s2) {
        for(int i=0;i<s1.length();i++) {
            int c1 = s1.charAt(i);
            int c2 = s2.charAt(i);
            if(c1<c2) {
                return true;
            }else if(c1>c2) {
                return false;
            }
        }
        return false;
    }

}
