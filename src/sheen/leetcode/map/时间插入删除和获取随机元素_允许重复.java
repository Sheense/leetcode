package sheen.leetcode.map;

import java.util.*;

public class 时间插入删除和获取随机元素_允许重复 {
    public static void main(String[] args) {
        RandomizedCollection c = new RandomizedCollection();
        c.insert(0);
        c.insert(1);
        c.insert(2);
        c.insert(3);
        c.insert(4);
        c.insert(5);
        c.insert(6);
        c.insert(7);
        c.remove(0);
        c.remove(4);
        c.remove(5);
        c.remove(1);
        c.remove(2);
        c.remove(6);
        c.remove(3);
        c.remove(7);
        c.getRandom();
    }
    static class RandomizedCollection {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        /** Initialize your data structure here. */
        public RandomizedCollection() {

        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            list.add(val);
            int index = list.size()-1;
            Set<Integer> l =  map.computeIfAbsent(val, x -> new HashSet<>());
            l.add(index);
            return map.get(val).size()==1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)||map.get(val).size()==0) return false;
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if(list.size()==1||index==list.size()-1) list.remove(list.size()-1);
            else {
                list.set(index, list.get(list.size()-1));
                int replace = list.get(list.size()-1);
                map.get(replace).remove(list.size()-1);
                map.get(replace).add(index);
                list.remove(list.size()-1);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get((int)(Math.random() * list.size()));
        }
    }
}
