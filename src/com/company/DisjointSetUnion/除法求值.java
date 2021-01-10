package com.company.DisjointSetUnion;

import com.company.util.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 除法求值 {
    public static void main(String[] args) {
        除法求值 s = new 除法求值();
        ArrayUtils.print(s.calcEquation(Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c"),Arrays.asList("bc","cd")),new double[]{1.5,2.5,5.0},Arrays.asList(Arrays.asList("a","c"),Arrays.asList("c","b"),Arrays.asList("bc","cd"),Arrays.asList("cd","bc"))));
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String, Node> map = new HashMap<>();
        for(int i=0;i<equations.size();i++) {
            List<String> list = equations.get(i);
            double value = values[i];
            Node fenzi = map.computeIfAbsent(list.get(0), x -> new Node());
            Node fenmu = map.computeIfAbsent(list.get(1), x-> new Node());
            Node p1 = findRoot(fenzi);
            Node p2 = findRoot(fenmu);
            p1.parent = p2;
            p1.weight = value * (p2.rootValue / p1.rootValue);
        }
        for(int i=0;i<queries.size();i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Node fenzi = map.get(a);
            Node fenmu = map.get(b);
            if(fenzi==null||fenmu==null) {
                res[i] = -1;
                continue;
            }
            Node p1 = findRoot(fenzi);
            double rootv1 = p1.rootValue;
            Node p2 = findRoot(fenmu);
            double rootv2 = p2.rootValue;
            if(p1!=p2) {
                res[i] = -1;
            }else {
                res[i] = rootv1 / rootv2;
            }
        }
        return res;
    }

    public Node findRoot(Node node) {
        double rootValue = 1;
        while(node.parent != node) {
            rootValue *= node.weight;
            node = node.parent;
        }
        node.rootValue = rootValue;
        return node;
    }

    private class Node{
        Node parent = this;
        double weight = 1;
        double rootValue = 1;
    }
}
