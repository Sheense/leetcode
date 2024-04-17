package sheen.leetcode.DisjointSetUnion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 统计无向图中无法互相到达点对数
 * @Date 2023/10/21 00:57
 * @Created by sheen
 * @Description TODO
 */
public class 统计无向图中无法互相到达点对数 {
    public static void main(String[] args) {
        统计无向图中无法互相到达点对数 s= new 统计无向图中无法互相到达点对数();
        System.out.println(s.countPairs(10000, new int[][]{}));
    }
    public long countPairs(int n, int[][] edges) {
        UnionSet set = new UnionSet(n);
        for(int i = 0; i < edges.length; i++) {
            set.union(edges[i][0], edges[i][1]);
        }
        return set.getRes();
    }

    public static class UnionSet {
        private int[] next;
        private int[] count;
        Set<Integer> set = new HashSet<>();
        public UnionSet(int n) {
            next = new int[n];
            count = new int[n];
            for(int i = 0; i < next.length; i++) {
                next[i] = i;
                count[i] = 1;
            }
        }

        public int findRoot(int v) {
            while (next[v] != v) {
                v = next[v];
            }

            return v;
        }

        public void union(int a, int b) {
            set.add(a);
            set.add(b);
            int r1 = findRoot(a);
            int r2 = findRoot(b);
            if(r1 == r2) {
                return ;
            }

            next[r1] = r2;
            count[r2] += count[r1];
        }

        public long getRes() {
            long res = 0;
            List<Integer> list = new ArrayList<>();
            for(int i : set) {
                if(next[i] == i) {
                    list.add(count[i]);
                }
            }

            for(int i = 0; i < list.size() - 1; i++) {
                for(int j = i + 1; j < list.size(); j++) {
                    res += (long)list.get(i) * list.get(j);
                }
            }

            int yu = next.length - set.size();
            res += (long)yu * set.size();
            res += (long)yu * (yu - 1) / 2;
            return res;
        }
    }
}
