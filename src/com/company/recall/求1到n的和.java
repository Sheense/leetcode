package com.company.recall;

public class 求1到n的和 {


    public static void main(String[] args) {
        求1到n的和 s = new 求1到n的和();
        System.out.println(s.sumNums(9));
    }

    public int sumNums(int n) {
        boolean flag = n!=0 && (n+=sumNums(n-1))>0;
        return n;
    }
}
