package com.company.binarySearch;

public class 在D天内送达包裹的能力 {

    public static void main(String[] args) {
        在D天内送达包裹的能力 s = new 在D天内送达包裹的能力();
        System.out.println(s.shipWithinDays(new int[]{3,2,2,4,1,4},3));
    }

    /*public int shipWithinDays(int[] weights, int D) {
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
    }*/
    public int shipWithinDays(int[] weights, int D) {
        int end = 0;
        int start = weights[0];
        for(int i=0;i<weights.length;i++) {
            end += weights[i];
            if(weights[i] > start) start = weights[i];
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            int day = 0;
            int now = 0;
            int i = 0;
            while (i<weights.length) {
                if(now+weights[i] < mid) {
                    now += weights[i];
                }else {
                    day ++;
                    if(now + weights[i] == mid) {
                        now = 0;
                    }else {
                        now = weights[i];
                    }
                }
                i++;
                if(day == D) {
                    break;
                }
            }
            if(day == D && (now > 0 || i < weights.length)) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
