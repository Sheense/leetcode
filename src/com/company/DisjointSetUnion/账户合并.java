package com.company.DisjointSetUnion;

import java.sql.Array;
import java.util.*;

public class 账户合并 {
    public static void main(String[] args) {
        账户合并 s = new 账户合并();
        System.out.println(s.accountsMerge(Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"), Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),Arrays.asList("Mary","mary@mail.com"),Arrays.asList("John","johnnybravo@mail.com"))));
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(accounts);

        for(int i=0;i<accounts.size();i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                map.put(accounts.get(i).get(j), i);
            }
        }
        for(int i=0;i<accounts.size();i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                int emailIndex = map.get(accounts.get(i).get(j));
                int r1 = unionFind.findRoot(i);
                int r2 = unionFind.findRoot(emailIndex);
                unionFind.union(r1, r2);
            }
        }
        return unionFind.getResult();
    }

    public class UnionFind{
        private int parent[];
        private List<String> name = new ArrayList<>();
        private List<Set<String>> emails = new ArrayList<>();
        public UnionFind(List<List<String>> accounts) {
            parent = new int[accounts.size()];
            for(int i=0;i<parent.length;i++) {
                parent[i] = i;
                name.add(accounts.get(i).get(0));
                emails.add(new HashSet<>(accounts.get(i).subList(1, accounts.get(i).size())));
            }
        }

        public int findRoot(int i) {
            while(i!=parent[i]) {
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            if(i==j) return;
            parent[i] = j;
            emails.get(j).addAll(emails.get(i));
        }

        public List<List<String>> getResult() {
            List<List<String>> res = new ArrayList<>();
            for(int i=0;i<parent.length;i++) {
                if(i==parent[i]) {
                    List<String> list = new ArrayList<>();
                    list.add(name.get(i));
                    List<String> l = new ArrayList(emails.get(i));
                    Collections.sort(l);
                    list.addAll(l);
                    res.add(list);
                }
            }
            return res;
        }

    }
}

