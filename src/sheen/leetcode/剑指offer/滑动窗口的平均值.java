package sheen.leetcode.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 滑动窗口的平均值
 * @Date 2022/7/16 1:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 滑动窗口的平均值 {
    class MovingAverage {

        private Queue<Double> queue = new LinkedList<>();
        private double all = 0;
        private int size = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if(queue.size() < size) {
                queue.offer((double)val);
                all += val;
            }else {
                all -= queue.poll();
                all += val;
                queue.offer((double)val);
            }
            return all / queue.size();
        }
    }
}
