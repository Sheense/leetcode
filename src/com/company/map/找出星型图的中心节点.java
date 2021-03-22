package com.company.map;

import java.util.HashMap;
import java.util.Map;

public class 找出星型图的中心节点 {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length+1];
        for(int i=0;i<edges.length;i++) {
            arr[edges[i][0]-1]++;
            arr[edges[i][1]-1]++;
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == arr.length-1) return i+1;
        }
        return -1;
    }
}
