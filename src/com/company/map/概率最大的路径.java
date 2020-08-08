package com.company.map;

import java.util.*;

public class 概率最大的路径 {
    public static void main(String[] args) {
        概率最大的路径 s = new 概率最大的路径();
        System.out.println(s.maxProbability(3,new int[][]{{0,1},{1,2},{0,2}},new double[]{0.5,0.5,0.3},0,2));
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Queue<Integer> queueLine = new LinkedList<>();
        Queue<Double> queueScore = new LinkedList<>();
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        double [] scores = new double[n];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<edges.length;i++) {
            int pre = edges[i][0];
            int last = edges[i][1];
            Map<Integer, Double> map1 = map.computeIfAbsent(pre, x -> new HashMap<>());
            Map<Integer, Double> map2 = map.computeIfAbsent(last, x -> new HashMap<>());
            map1.put(last, succProb[i]);
            map2.put(pre, succProb[i]);
        }
        double res = 0;
        if(!map.containsKey(start)||!map.containsKey(end)) {
            return res;
        }
        queueLine.offer(start);
        queueScore.offer(1.0);
        while(!queueLine.isEmpty()) {
            int size = queueLine.size();
            boolean flag = false;
            while(size-->0) {
                int point = queueLine.poll();
                double score = queueScore.poll();
                //保留遍历该点的最大分数
                if((!set.contains(point)||score>scores[point])&&point!=end) {
                    scores[point] = score;
                    set.add(point);
                    for (Integer i : map.get(point).keySet()) {
                        double newScore = score*map.get(point).get(i);
                        queueLine.offer(i);
                        queueScore.offer(newScore);
                    }
                }else if(point==end) {
                    if(score>res) {
                        res = score;
                    }
                }
            }
        }
        return res;
    }





}
