package com.company.hashmap;


import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Classname 救生艇
 * @Date 2021/8/26 12:51 上午
 * @Created by sheen
 * @Description TODO
 */
public class 救生艇 {
    public static void main(String[] args) {
        救生艇 s = new 救生艇();
        System.out.println(s.numRescueBoats(new int[]{2, 4}, 5));
    }
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < people.length; i++) {
            map.put(people[i], map.getOrDefault(people[i], 0) + 1);
        }
        Arrays.sort(people);
        int count = 0;
        for(int i = people.length - 1; i >= 0; i--) {
            if(map.containsKey(people[i]) ) {
                if(map.get(people[i]) == 1) {
                    map.remove(people[i]);
                }else {
                    map.put(people[i], map.get(people[i]) -1);
                }
                count++;

                int target = limit - people[i];
                Integer key = map.floorKey(target);
                if(key != null) {
                    count++;
                    if(map.get(key) == 1) {
                        map.remove(key);
                    }else {
                        map.put(key, map.get(key) - 1);
                    }
                }
                res++;
            }
            if(count == people.length) break;
        }
        return res;
    }
}
