package com.company.array;

public class 有效的山脉数组 {
    public boolean validMountainArray(int[] A) {
        int index = 0;
        while(index+1<A.length&&A[index]<A[index+1]) {
            index++;
        }
        if(index==0||index==A.length-1) return false;
        while(index+1<A.length&&A[index+1]<A[index]) {
            index++;
        }
        if(index==A.length-1) return true;
        return false;
    }
}
