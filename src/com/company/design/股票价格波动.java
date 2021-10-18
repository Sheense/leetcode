package com.company.design;

import java.util.*;

/**
 * @Classname 股票价格波动
 * @Date 2021/10/10 11:49 下午
 * @Created by sheen
 * @Description TODO
 */
public class 股票价格波动 {
    class StockPrice {
        private TreeMap<Integer, Integer> timeToPrice = new TreeMap<>();
        private TreeMap<Integer, Set<Integer>> priceToTime = new TreeMap<>();
        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if(!timeToPrice.containsKey(timestamp)) {
                timeToPrice.put(timestamp, price);
                priceToTime.computeIfAbsent(price, x -> new HashSet<>()).add(timestamp);
            }else {
                int old = timeToPrice.get(timestamp);
                Set<Integer> set = priceToTime.get(old);
                set.remove(timestamp);
                if(set.size() == 0) {
                    priceToTime.remove(old);
                }
                timeToPrice.put(timestamp, price);
                priceToTime.computeIfAbsent(price, x -> new HashSet<>()).add(timestamp);
            }
        }

        public int current() {
            return timeToPrice.lastEntry().getValue();
        }

        public int maximum() {
            return priceToTime.lastKey();
        }

        public int minimum() {
            return priceToTime.firstKey();
        }
    }
}
