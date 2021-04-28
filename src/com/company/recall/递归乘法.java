package com.company.recall;

public class 递归乘法 {
    public int multiply(int A, int B) {
        if(A>B) {
            return recall(A, B);
        } else {
            return recall(B, A);
        }
    }

    public int recall(int num, int time) {
        if(time == 0) return 0;
        return num+recall(num, time-1);
    }

}
