package com.company.math;

import java.util.*;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        把数组排成最小的数 s = new 把数组排成最小的数();
        System.out.println(s.minNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));
    }
    public String minNumber(int[] nums) {
        Map<Character, PriorityQueue<String>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.computeIfAbsent(String.valueOf(nums[i]).charAt(0), x -> new PriorityQueue<>((o1,o2)->{
                String r1 = o1 + o2;
                String r2 = o2 + o1;
                for(int j=0;j<r1.length();j++) {
                    if(r1.charAt(j)!=r2.charAt(j)) {
                        return r1.charAt(j) - r2.charAt(j);
                    }
                }
                return 0;
            })).add(String.valueOf(nums[i]));
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        String res ="";
        for(char key:list) {
            PriorityQueue<String> queue = map.get(key);
            while (!queue.isEmpty()){
                String value = queue.poll();
                res += value;
            }
        }
        return res;
    }


}
