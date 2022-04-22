package com.company.design;

import java.util.*;

/**
 * @Classname O1时间插入删除和获取随机元素
 * @Date 2022/4/13 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class O1时间插入删除和获取随机元素 {
    public static void main(String[] args) {
        RandomizedSet s = new RandomizedSet();
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.insert(0));
        System.out.println(s.getRandom());
        System.out.println(s.remove(0));
        System.out.println(s.insert(0));
    }
    static class RandomizedSet {

        private List<Integer> list = new ArrayList<>();
        private Map<Integer, Integer> map = new HashMap<>();
        private Random random = new Random();
        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }
            int i = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(i, last);
            map.put(last, i);
            list.remove(list.size() - 1);
            map.remove(val);




            /*if(i == list.size() - 1) {
                list.remove(list.size() - 1);
                map.remove(val);
            }else {
                int last = list.get(list.size() - 1);
                list.set(i, last);
                list.remove(list.size() - 1);
                map.put(last, i);
            }*/
            return true;
        }

        public int getRandom() {
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }
}
