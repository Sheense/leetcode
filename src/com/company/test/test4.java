package com.company.test;

import java.util.Arrays;
import java.util.List;

public class test4 {
    public static void main(String[] args) {
        System.out.println(water(Arrays.asList(4,3,2,1)));
    }

    public static int water(List<Integer> height){
        int res = 0;
        int index = 0;
        int has = 0;
        for(int i=0;i<height.size();i++){
            if(height.get(i)>=height.get(index)) {
                res += has;
                has = 0;
                index = i;
            }else {
                has+=(height.get(index) - height.get(i));
            }
        }
        int begin = height.size()-1;
        has = 0;
        for(int i=begin;i>=index;i--) {
            if(height.get(i) >= height.get(begin)) {
                res += has;
                has = 0;
                begin = i;
            }else {
                has +=(height.get(begin) - height.get(i));
            }
        }
        return res;
    }

}
