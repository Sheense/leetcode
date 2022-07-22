package sheen.leetcode.segmentArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 我的日程安排表III
 * @Date 2022/6/6 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 我的日程安排表III {
    public static void main(String[] args) {
        MyCalendarThree tree = new MyCalendarThree();
        System.out.println(tree.book(10, 20));
        System.out.println(tree.book(50, 60));
        System.out.println(tree.book(10, 40));

        System.out.println(tree.book(5, 15));
        System.out.println(tree.book(5, 10));
        System.out.println(tree.book(25,55));

    }

    static class MyCalendarThree {
        private Map<Integer, Integer> tree = new HashMap<>();
        private Map<Integer, Integer> lazy = new HashMap<>();
        private int n = (int) Math.pow(10, 9);
        public MyCalendarThree() {

        }

        public int book(int start, int end) {
            add(1, 0, n, start, end - 1);
            return tree.getOrDefault(1, 0);
        }

        public void add(int index, int left, int right, int start, int end) {
            if(start > right || end < left) {
                return;
            }

            if(start <= left && right <= end) {
                tree.put(index, tree.getOrDefault(index, 0) + 1);
                lazy.put(index, lazy.getOrDefault(index, 0) + 1);
            }else {
                int mid = (right - left) / 2 + left;
                add(index * 2, left, mid, start, end);
                add(index * 2 + 1, mid + 1, right, start, end);
                tree.put(index, lazy.getOrDefault(index, 0) + Math.max(tree.getOrDefault(index * 2, 0), tree.getOrDefault(index * 2 + 1, 0)));
            }
        }
    }
}
