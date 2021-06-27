package com.company.design;

import java.util.*;

public class 设计电影租借系统 {
    class MovieRentingSystem {
        private Map<Integer, Map<Integer, Boolean>> report = new HashMap<>();
        private Map<Integer, Map<Integer, Integer>> price = new HashMap<>();
        private Map<Integer, PriorityQueue<Integer>> exist = new HashMap<>();
        private Map<Integer, Set<Integer>> hasSearch = new HashMap<>();
        private PriorityQueue<List<Integer>> rent = new PriorityQueue<>((o1, o2) -> {
            int price1 = price.get(o1.get(0)).get(o1.get(1));
            int price2 = price.get(o2.get(0)).get(o2.get(1));
            int diff = price1 - price2;
            if(diff == 0) {
                diff = o1.get(0) - o2.get(0);
                if(diff == 0) return o1.get(1) - o2.get(1);
            }
            return diff;
        });
        private Map<Integer, Set<Integer>> hasReport = new HashMap<>();
        public MovieRentingSystem(int n, int[][] entries) {
            for(int i = 0; i < entries.length; i++) {
                report.computeIfAbsent(entries[i][0], x -> new HashMap<>()).put(entries[i][1], false);
                price.computeIfAbsent(entries[i][0], x -> new HashMap<>()).put(entries[i][1], entries[i][2]);
                Integer movie = entries[i][1];
                exist.computeIfAbsent(entries[i][1], x -> {
                    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
                        int diff =  price.get(o1).get(movie) - price.get(o2).get(movie);
                        if(diff == 0) return o1 - o2;
                        return diff;
                    });
                    return queue;
                }).add(entries[i][0]);
                hasSearch.computeIfAbsent(entries[i][1], x -> new HashSet<>()).add(entries[i][0]);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> res = new ArrayList<>();
            PriorityQueue<Integer> queue = exist.get(movie);
            if(queue == null) return res;
            Set<Integer> set = hasSearch.get(movie);
            int index = 0;
            while (index < 5 && !queue.isEmpty()) {
                int shop = queue.poll();
                if(!report.get(shop).get(movie)) {
                    res.add(shop);
                    index++;
                }else {
                    set.remove(shop);
                }
            }
            for(int key:res) {
                queue.add(key);
            }
            return res;
        }

        public void rent(int shop, int movie) {
            report.get(shop).put(movie, true);
            Set<Integer> set = hasReport.computeIfAbsent(shop, x -> new HashSet<>());
            if(!set.contains(movie)) {
                rent.add(Arrays.asList(shop, movie));
                set.add(movie);
            }
        }

        public void drop(int shop, int movie) {
            report.get(shop).put(movie, false);
            if(!hasSearch.get(movie).contains(shop)) {
                PriorityQueue<Integer> queue = exist.get(movie);
                Set<Integer> set = hasSearch.get(movie);
                queue.add(shop);
                set.add(shop);
            }
        }

        public List<List<Integer>> report() {
            List<List<Integer>> res = new ArrayList<>();

            int index = 0;
            while (index < 5 && !rent.isEmpty()) {
                List<Integer> item = rent.poll();
                if(report.get(item.get(0)).get(item.get(1))) {
                    res.add(item);
                    index++;
                }else {
                    hasReport.get(item.get(0)).remove(item.get(1));
                }
            }
            for(List<Integer> value : res) {
                rent.add(value);
            }
            return res;
        }
    }
}
