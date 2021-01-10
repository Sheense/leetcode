package com.company.array;

import com.company.util.ArrayUtils;

import java.util.*;

public class 最接近原点的K个点 {
    public static void main(String[] args) {
        最接近原点的K个点 s = new 最接近原点的K个点();
        ArrayUtils.print2(s.kClosest(new int[][]{{0,1},{1,0}}, 2));
    }
    public int[][] kClosest(int[][] points, int K) {
        Map<Double, List<int[]>> map = new HashMap<>();
        for(int i=0;i<points.length;i++) {
            double n = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1],2));
            map.computeIfAbsent(n, x -> new ArrayList<>()).add(points[i]);
        }
        List<Double> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int [][] res = new int[K][2];
        int index = 0;
        int i = 0;
        while (K!=0) {
            List<int[]> l = map.get(list.get(i++));
            if(K-l.size()>=0) {
                K-=l.size();
                int size = l.size();
                int j = 0;
                while(j<size) {
                    res[index++] = l.get(j++);
                }
            }else {
                int j = 0;
                while(j<K) {
                    res[index++] = l.get(j++);
                }
                K=0;
            }
        }
        return res;
    }
}
