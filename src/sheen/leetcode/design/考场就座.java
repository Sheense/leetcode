package sheen.leetcode.design;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Classname 考场就座
 * @Date 2022/12/30 12:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 考场就座 {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(9);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(9);
        examRoom.seat();
        examRoom.leave(1);
        examRoom.seat();
        examRoom.leave(8);
        examRoom.seat();
        examRoom.leave(2);
        examRoom.seat();
        examRoom.leave(1);
        examRoom.seat();
        examRoom.leave(0);
        examRoom.leave(1);
        examRoom.seat();
        System.out.println(examRoom.seat());





    }
    static class ExamRoom {
        /**
         * 区间[start, end], key = start, value = end，start和end必须存在点，才会作为key，value存入
         */
        private TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        /**
         * 根据区间长度除以/2作为排序，因为从例子可以知道0到4，4到9，最终取2，不取6，明明6到9距离是3，说明是按正数平均距离去排序，然后取序号小的
         */
        private PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {

            int len2 = (y[1] - y[0]) / 2;
            int len1 = (x[1] - x[0]) / 2;
            if(len1 == len2) {
                return x[0] - y[0];
            }

            return len2 - len1;
        });
        private int n;


        public ExamRoom(int n) {
            this.n = n;
        }

        public int seat() {

            if(treeMap.isEmpty()) {
                treeMap.put(0, n - 1);
                queue.offer(new int[]{0, n - 1});
                return 0;
            }

            if(treeMap.size() == 1) {
                int now = treeMap.firstEntry().getKey();
                if(n - 1 - now > now - 0) {
                    queue.offer(new int[]{treeMap.lastKey(), n - 1});
                    queue.offer(new int[]{n - 1, n - 1});
                    treeMap.put(treeMap.lastKey(), n - 1);
                    treeMap.put(n - 1, n - 1);
                    return n - 1;
                }else {
                    treeMap.put(0, now);
                    queue.offer(new int[]{0, now});
                    return 0;
                }
            }

            /**
             * 1、去掉队列区间大小为1的区间
             * 2、去掉过期的区间，treemap保存区间，只要key-value不一样了就说明区间发生变化，原先的失效了
             * 3、去掉已经不存在的区间
             */
            while (!queue.isEmpty() && (!treeMap.containsKey(queue.peek()[0]) || treeMap.get(queue.peek()[0]) != queue.peek()[1] || (queue.peek()[1] - queue.peek()[0] <= 1))) {
                queue.poll();
            }


            /**
             * 前后两个区间拿出来
             */
            int leftLen = treeMap.firstKey();
            int rightLen = n - 1 - treeMap.lastKey();

            int[] item = queue.peek();
            int len = 0;
            if(item != null) {
                len = (item[1] - item[0]) / 2;
            }
            if(leftLen >= rightLen) {
                if(leftLen >= len) {
                    queue.offer(new int[]{0, treeMap.firstKey()});
                    treeMap.put(0, treeMap.firstKey());
                    return 0;
                }
            }else {
                if(rightLen > len) {
                    queue.offer(new int[]{treeMap.lastKey(), n - 1});
                    treeMap.put(treeMap.lastKey(), n - 1);
                    treeMap.put(n - 1, n - 1);
                    return n - 1;
                }
            }

            queue.poll();
            int mid = (item[1] + item[0]) / 2;
            treeMap.put(item[0], mid);
            treeMap.put(mid, item[1]);
            queue.offer(new int[]{item[0], mid});
            queue.offer(new int[]{mid, item[1]});
            return mid;
        }

        public void leave(int p) {
            Integer nextSeat = treeMap.remove(p);
            if(p > 0) {
                if(p == n - 1) {
                    Integer floorKey = treeMap.floorKey(p);
                    if(floorKey != null) {
                        //没有后继节点作为区间了，赋值自己保证放到队列最后面
                        treeMap.put(floorKey, floorKey);
                        queue.offer(new int[]{floorKey, floorKey});
                    }
                    return;
                }
                Integer floorKey = treeMap.floorKey(p);
                if(floorKey != null) {
                    treeMap.put(floorKey, nextSeat);
                    queue.offer(new int[]{floorKey, nextSeat});
                }
            }
        }
    }
}
