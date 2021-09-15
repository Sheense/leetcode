package com.company.binarySearch;

import java.util.Arrays;

public class 两球之间的磁力 {
    public static void main(String[] args) {
        两球之间的磁力 s = new 两球之间的磁力();
        System.out.println(s.maxDistance(new int[]{4784,9049,3151,7537,2734,1287,2875,6770,9565,6254,6898,2509,6583}, 13));
        //System.out.println(s.maxDistance(new int[]{1,2,3,4,7}, 3));
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(check(m, position, mid)) {
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int m, int[] position, int target) {
        int pre = position[0];
        int cnt = 1;
        for(int i = 1; i < position.length; i++) {
            if(position[i] - pre >= target) {
                pre = position[i];
                cnt++;
            }
        }
        return cnt >= m;
    }
}
