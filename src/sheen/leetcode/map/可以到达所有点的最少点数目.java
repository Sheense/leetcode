package sheen.leetcode.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 可以到达所有点的最少点数目 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int [] map = new int[n];
        for(int i=0;i<edges.size();i++) {
            map[edges.get(i).get(1)]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<map.length;i++) {
            if(map[i]==0) {
                list.add(i);
            }
        }
        return list;
    }
}
