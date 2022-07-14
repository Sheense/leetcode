package com.company.design;

import java.util.TreeSet;

/**
 * @Classname 无限集中的最小数字
 * @Date 2022/7/10 11:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 无限集中的最小数字 {
    static class SmallestInfiniteSet {
        private TreeSet<Integer> treeSet = new TreeSet<>();
        Integer min = 1;
        public SmallestInfiniteSet() {

        }

        public int popSmallest() {
            int res = min;
            treeSet.add(min);
            while (treeSet.contains(min)) {
                min++;
            }
            return res;
        }

        public void addBack(int num) {
            treeSet.remove(num);
            min = Math.min(num, min);
        }
    }
}
