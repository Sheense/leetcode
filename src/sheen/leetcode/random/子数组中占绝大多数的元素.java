package sheen.leetcode.random;

import java.util.*;

/**
 * @Classname 子数组中占绝大多数的元素
 * @Date 2023/4/16 11:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 子数组中占绝大多数的元素 {
    public static void main(String[] args) {
        MajorityChecker s = new MajorityChecker(new int[]{1, 1, 2, 2, 1, 1});
        System.out.println(s.query(0, 5, 4));
        System.out.println(s.query(0, 3, 3));
        System.out.println(s.query(2, 3, 2));
    }
    static class MajorityChecker {

        private Map<Integer, List<Integer>> map = new HashMap<>();
        private Random random = new Random();
        private int[] arr;
        private int K = 20;
        public MajorityChecker(int[] arr) {
            this.arr = arr;
            for(int i = 0; i < arr.length; i++) {
                map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int threshold) {
            int len = right - left + 1;
            for(int i = 0; i < K; i++) {
                int v = arr[left + random.nextInt(len)];
                int start = searchStart(left, map.get(v));
                int end = searchEnd(right, map.get(v));
                int count = end - start + 1;
                if(count >= threshold) {
                    return v;
                }
            }
            return -1;
        }

        public int searchStart(int left, List<Integer> list) {
            int start = 0;
            int end = list.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if(list.get(mid) >= left) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            return start;
        }

        public int searchEnd(int right, List<Integer> list) {
            int start = 0;
            int end = list.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if(list.get(mid) > right) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            return end;
        }
    }

}
