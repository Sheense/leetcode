package com.company.binarySearch;

public class 在D天内送达包裹的能力 {

    public static void main(String[] args) {
        在D天内送达包裹的能力 s = new 在D天内送达包裹的能力();
        System.out.println(s.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
    }

    public int shipWithinDays(int[] weights, int D) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < weights.length; i++) {
            if (start < weights[i]) {
                start = weights[i];
            }
            end += weights[i];
        }
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            int item = 0;
            int day = 1;
            for (int i = 0; i < weights.length; i++) {
                if (item + weights[i] > mid) {
                    day++;
                    item = weights[i];
                    if (day > D) {
                        break;
                    }
                } else {
                    item += weights[i];
                }
            }
            if (day > D) {
                start = mid + 1;
            } else {
                end = mid - 1;
                if (min > mid) min = mid;
            }
        }
        return min;
    }

}
