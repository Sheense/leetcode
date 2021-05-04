package com.company.sort;

import com.company.util.ArrayUtils;

import java.util.*;

public class 最近的房间 {
    public static void main(String[] args) {

        Integer a = 1000000;
        Integer b = 1000001;
        System.out.println(a < b);
        最近的房间 s = new 最近的房间();
        ArrayUtils.print(s.closestRoom(new int[][]
                {{1,4},{2,3},{3,5},{4,1},{5,2}},
                new int[][]{{2,3},{2,4},{2,5}}));
    }
    public int[] closestRoom(int[][] rooms, int[][] queries) {

        int[][] q = new int[queries.length][3];
        for(int i=0;i<queries.length;i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (x,y) -> y[1] - x[1]);
        Arrays.sort(rooms, (x,y) -> y[1] - x[1]);

        TreeSet<Integer> set = new TreeSet<>();
        int res[] = new int[queries.length];
        Arrays.fill(res, -1);
        int index = 0;
        for(int i=0;i<q.length;i++) {
            while (index<rooms.length&&rooms[index][1]>=q[i][1]){
                set.add(rooms[index][0]);
                index++;
            }
            Integer ceil = set.ceiling(q[i][0]);
            Integer floor = set.floor(q[i][0]);
            if(ceil!=null && floor!=null) {
                if(Math.abs(ceil-q[i][0])>Math.abs(floor-q[i][0])) {
                    res[q[i][2]] = floor;
                }else if(Math.abs(ceil-q[i][0])<Math.abs(floor-q[i][0])){
                    res[q[i][2]] = ceil;
                }else {
                    if(ceil > floor) {
                        res[q[i][2]] = floor;
                    }else {
                        res[q[i][2]] = ceil;
                    }
                }
            }else if(ceil != null) {
                res[q[i][2]] = ceil;
            }else if(floor != null) {
                res[q[i][2]] = floor;
            }
        }

        return res;
    }

}
