package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class 数组形式的整数加法 {

    public static void main(String[] args) {
        数组形式的整数加法 s = new 数组形式的整数加法();
        System.out.println(s.addToArrayForm(new int[]{2,1,5}, 806));
    }
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        while(K!=0) {
            res.add(K%10);
            K/=10;
        }
        int j = 0;
        int index = 0;
        int size = res.size();
        for(int i=A.length-1;i>=0;i--) {
            if(index>=size) {
                res.add((A[i]+j)%10);
                j = (A[i]+j)/10;
            }else {
                int value = res.get(index);
                res.set(index, (value+A[i]+j)%10);
                j = (value+A[i]+j)/10;
                index++;
            }
        }
        while (index<size) {
            int value = res.get(index);
            res.set(index, (j+value)%10);
            j = (j+value)/10;
            index++;
        }
        if(j==1) {
            res.add(j);
        }
        for(int i=0;i<res.size()/2;i++) {
            int item = res.get(i);
            res.set(i, res.get(res.size()-1-i));
            res.set(res.size()-1-i, item);
        }
        return res;
    }
}
