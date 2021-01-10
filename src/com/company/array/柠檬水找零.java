package com.company.array;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twe = 0;
        for(int i=0;i<bills.length;i++) {
            if(bills[i]==5) five++;
            else if(bills[i]==10) {
                if (five==0) return false;
                five--;
                ten++;
            }else {
                if(ten==0) {
                    if(five>=3) {
                        five-=3;
                        twe ++;
                    }else {
                        return false;
                    }
                }else {
                    if(five>0) {
                        five--;
                        ten--;
                        twe++;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
