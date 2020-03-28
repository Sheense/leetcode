package com.company.math;

import java.util.ArrayList;
import java.util.List;

public class 回文数 {
    public static void main(String[] args) {
        回文数 s = new 回文数();
        System.out.println(s.isPalindrome(10));
    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        List<Integer> list = new ArrayList<>();
        while (x>0) {
            list.add(x%10);
            x /= 10;
        }
        for(int i=0;i<list.size()/2;i++) {
            if(list.get(i)!=list.get(list.size()-1-i)) return false;
        }
        return true;
    }
}
