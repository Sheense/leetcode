package sheen.leetcode.design;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @Classname 求出MK平均值
 * @Date 2023/1/18 12:58 上午
 * @Created by sheen
 * @Description TODO
 */
public class 求出MK平均值 {
    public static void main(String[] args) {

        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(4010);
        obj.addElement(2926);
        System.out.println(obj.calculateMKAverage());
        obj.addElement(3336);
        obj.addElement(85138);
        System.out.println(obj.calculateMKAverage());
        obj.addElement(70965);
        obj.addElement(1207);
        System.out.println(obj.calculateMKAverage());
        obj.addElement(49966);





        /*MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
        System.out.println(obj.calculateMKAverage()); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [3,1,10]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [5,5,5]*/

    }
    static class MKAverage {

        private int m;
        private int k;
        private TreeMap<Integer, Integer> s1 = new TreeMap<>();
        private TreeMap<Integer, Integer> s2 = new TreeMap<>();
        private TreeMap<Integer, Integer> s3 = new TreeMap<>();
        private Queue<Integer> queue = new LinkedList<>();
        private int sum = 0;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            queue.offer(num);

            if(queue.size() < m) {
                return;
            }else if(queue.size() == m) {
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
                for(int value : queue) {
                    priorityQueue.offer(value);
                }

                for(int i = 0; i < k; i++) {
                    int key = priorityQueue.poll();
                    addNum(s1, key);
                }

                for(int i = 0; i < (m - 2 * k); i++) {
                    int key = priorityQueue.poll();
                    addNum(s2, key);
                    sum += key;
                }

                for(int i = 0; i < k; i++) {
                    int key = priorityQueue.poll();
                    addNum(s3, key);
                }
            }else {
                int newNum = num;
                int oldNum = queue.poll();
                if(s1.containsKey(oldNum)) {
                    removeNum(s1, oldNum);
                    if(newNum <= s2.firstKey()) {
                        addNum(s1, newNum);
                    }else if(newNum > s2.firstKey() && newNum <= s3.firstKey()) {
                        int firstKey = s2.firstKey();
                        removeNum(s2, firstKey);
                        addNum(s2, newNum);
                        sum -= firstKey;
                        addNum(s1, firstKey);
                        sum += newNum;
                    }else {
                        int s3First = s3.firstKey();
                        removeNum(s3, s3First);
                        addNum(s3, newNum);
                        addNum(s2, s3First);
                        sum += s3First;
                        int s2First = s2.firstKey();
                        removeNum(s2, s2First)  ;
                        sum -= s2First;
                        addNum(s1, s2First);
                    }
                }else if(s2.containsKey(oldNum)) {
                    removeNum(s2, oldNum);
                    sum -= oldNum;
                    if(newNum < s1.lastKey()) {
                        addNum(s1, newNum);
                        int s1Last = s1.lastKey();
                        removeNum(s1, s1Last);
                        addNum(s2, s1Last);
                        sum += s1Last;
                    }else if(newNum >= s1.lastKey() && newNum <= s3.firstKey()) {
                        addNum(s2, newNum);
                        sum += newNum;
                    }else {
                        int s3First = s3.firstKey();
                        removeNum(s3, s3First);
                        addNum(s3, newNum);
                        addNum(s2, s3First);
                        sum += s3First;
                    }
                }else {
                    removeNum(s3, oldNum);

                    if(newNum < s2.firstKey()) {
                        int s1Last = s1.lastKey();
                        addNum(s1, newNum);
                        removeNum(s1, s1Last);
                        sum += s1Last;
                        addNum(s2, s1Last);
                        int s2Last = s2.lastKey();
                        removeNum(s2, s2Last);
                        sum -= s2Last;

                        addNum(s3, s2Last);
                    }else if(newNum >= s2.firstKey() && (s3.isEmpty() || newNum < s3.firstKey())) {
                        addNum(s2, newNum);
                        sum += newNum;
                        int s2Last = s2.lastKey();
                        removeNum(s2, s2Last);
                        sum -= s2Last;

                        addNum(s3, s2Last);
                    }else {
                        addNum(s3, newNum);
                    }
                }
            }
        }

        public int calculateMKAverage() {
            TreeMap<Integer, Integer> t1 = s1;
            TreeMap<Integer, Integer> t2 = s2;
            TreeMap<Integer, Integer> t3 = s3;

            if(queue.size() < m) {
                return -1;
            }

            return sum / (m - 2 * k);
        }

        private void addNum(TreeMap<Integer, Integer> map, int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        private void removeNum(TreeMap<Integer, Integer> map, int num) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
    }
}
