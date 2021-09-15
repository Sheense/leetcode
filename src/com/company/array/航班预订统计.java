package com.company.array;

/**
 * @Classname 航班预订统计
 * @Date 2021/8/31 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for(int i = 0 ; i < bookings.length; i++) {
            int l = bookings[i][0] - 1;
            int r = bookings[i][1] - 1;
            int inc = bookings[i][2];
            arr[l] += inc;
            if(r+1 < n) {
                arr[r+1] -= inc;
            }
        }
        for(int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
}
