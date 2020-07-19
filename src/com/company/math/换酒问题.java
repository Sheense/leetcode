package com.company.math;

public class 换酒问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles>=numExchange) {
            res += numBottles/numExchange;
            numBottles = numBottles/numExchange + numBottles%numExchange;
        }
        return res;
    }
}
