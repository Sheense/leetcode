package com.company.binarySearch;

import java.util.Arrays;

public class 两球之间的磁力 {
    public static void main(String[] args) {
        两球之间的磁力 s = new 两球之间的磁力();
        System.out.println(s.maxDistance(new int[]{82,68,79,17,70,51,5,46,27,44,39,57,94,45,88,56}, 9));
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        if(m==position.length) {
            return getMin(position);
        }
        if(m==2) return position[position.length-1] - position[0];;
        int count = m - 2;
        int min = Integer.MAX_VALUE;
        int frist = 0;
        int last =  position.length-1;
        while(count!=0) {
            int interval = (position[last] - position[frist])/(2+count-1);
            int start = frist+1;
            int end = last-1;
            while(start<=end) {
                int mid = (start+end)/2;
                if(position[mid] - position[frist] > interval) {
                    start = mid + 1;
                    if(start>end) {
                        min = Math.min(position[start] - position[frist], min);
                        frist = start;
                        count --;
                        break;
                    }
                } else if(position[mid] - position[frist] < interval) {
                    end = mid - 1;
                    if(start>end) {
                        min = Math.min(position[end] - position[frist], min);
                        frist = end;
                        count --;
                        break;
                    }
                } else {
                    frist = mid;
                    count--;
                    break;
                }
            }
            if(count==0) {
                min = Math.min(position[last] - position[frist], min);
            }
        }
        return min;
    }
    public int getMin(int[] position) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<position.length-1;i++) {
            min = Math.min(position[i+1]-position[i], min);
        }
        return min;
    }
}
