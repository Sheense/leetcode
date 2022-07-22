package sheen.leetcode.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class 最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2)->o2-o1);
        for(int i:stones) {
            queue.add(i);
        }
        while (queue.size()>1) {
            int y = queue.poll();
            int x = queue.poll();
            if(y-x>0) {
                queue.add(y-x);
            }
        }
        if(queue.isEmpty()) return 0;
        return queue.peek();
    }
}
