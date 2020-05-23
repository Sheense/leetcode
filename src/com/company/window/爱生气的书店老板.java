package com.company.window;

public class 爱生气的书店老板 {

    public static void main(String[] args) {
        爱生气的书店老板 s = new 爱生气的书店老板();
        System.out.println(s.maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int window = 0;
        int max = 0;
        int res = 0;
        for(int i=0;i<customers.length;i++) {
            if(i>=X&&grumpy[i-X]==1) {
                window -= customers[i-X];
            }
            if(grumpy[i]==1) {
                window += customers[i];
            }
            if(grumpy[i]==0) res += customers[i];
            if(max<window) max = window;
        }
        return res+max;
    }
}



