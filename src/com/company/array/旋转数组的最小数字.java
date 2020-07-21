package com.company.array;

public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        旋转数组的最小数字 s = new 旋转数组的最小数字();
        System.out.println(s.minArray(new int[]{10,1,10,10,10}));
    }
    public int minArray(int[] numbers) {
        for(int i=0;i<numbers.length-1;i++) {
            if(numbers[i]>numbers[i+1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}
