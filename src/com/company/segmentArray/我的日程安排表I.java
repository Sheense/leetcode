package com.company.segmentArray;

import java.util.*;

/**
 * @Classname 我的日程安排表I
 * @Date 2022/7/5 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 我的日程安排表I {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10 , 20));
        System.out.println(calendar.book(12, 15));
        System.out.println(calendar.book(20 ,30));
    }
    static class MyCalendar {

        private TreeMap<Integer, Integer> leftMap = new TreeMap<>();
        private TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            if(leftMap.ceilingKey(start) != null) {
                int l = leftMap.ceilingKey(start);
                if(l < end) {
                    return false;
                }
            }

            if(leftMap.floorKey(start) != null) {
                int l = leftMap.floorKey(start);
                int r = leftMap.get(l);
                if(r > start) {
                    return false;
                }
            }

            if(rightMap.floorKey(end) != null) {
                int r = rightMap.floorKey(end);
                if(r > start) {
                    return false;
                }
            }

            if(rightMap.ceilingKey(end) != null) {
                int r = rightMap.ceilingKey(end);
                int l = rightMap.get(r);
                if(l < end) {
                    return false;
                }
            }

            leftMap.put(start, end);
            rightMap.put(end, start);
            return true;
        }


    }
}
