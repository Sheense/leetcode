package com.company.map;

import java.util.*;

public class 概率最大的路径 {
    public static void main(String[] args) {
        概率最大的路径 s = new 概率最大的路径();
        System.out.println(s.maxProbability(3,new int[][]{{0,1}},new double[]{0.5,0.5,0.3},0,2));
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Set<Integer>> elem = new HashMap<>();
        double[][] map = new double[n][n];
        for(int i= 0;i<edges.length;i++) {
            map[edges[i][0]][edges[i][1]] = succProb[i];
            map[edges[i][1]][edges[i][0]] = succProb[i];
            elem.computeIfAbsent(edges[i][0],x->new HashSet<>()).add(edges[i][1]);
            elem.computeIfAbsent(edges[i][1],x->new HashSet<>()).add(edges[i][0]);
        }
        Map<Integer, List<Integer>> elem1 = new HashMap<>();
        for(int key:elem.keySet()) {
            List<Integer> list = new ArrayList<>(elem.get(key));
            sort(list,map,key,0,list.size()-1);
            elem1.put(key,list);
        }
        Set<Integer> set = new HashSet<>();
        set.add(start);
        return find(map,start,end,1,elem,set);

    }

    public void sort(List<Integer> list, double[][] map,int begin, int start, int end) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int key = left;
        int keyValue = list.get(left);
        while(left<right) {
            while(left!=right&&map[begin][list.get(key)]>=map[begin][list.get(right)]) right--;
            list.set(key, list.get(right));
            key = right;
            while(left!=right&&map[begin][list.get(key)]<=map[begin][list.get(left)]) left++;
            list.set(key,list.get(left));
            key = left;
        }
        list.set(key, keyValue);
        sort(list,map,begin,start,left-1);
        sort(list,map,begin,left+1,end);
    }

    public double find(double[][] map, int start, int end, double res, Map<Integer,Set<Integer>> elem, Set<Integer> set){
        double max = 0;
        if(elem.containsKey(start)) {
            Set<Integer> list = elem.get(start);
            for(int x:list) {
                if(set.contains(x)) {
                    continue;
                }
                double v = res*map[start][x];
                if(v<max) break;
                if(x==end) {
                    if(max<v) max=v;
                    break;
                }
                set.add(x);
                double q = find(map, x,end,v,elem,set);
                set.remove(x);
                if(q>max) max = q;
            }
        }
        return max;
    }

}
