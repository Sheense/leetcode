package sheen.leetcode.design;

/**
 * @Classname 设计循环队列
 * @Date 2022/8/2 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 设计循环队列 {
    public static void main(String[] args) {
        String pre = "a`b`c";
        String str = "a`b`c`d`g";
        System.out.println(str.indexOf(pre));
    }
    static class MyCircularQueue {

        private int[] arr;
        private int start = 0;
        private int end = 0;
        private int count = 0;
        private int k;
        public MyCircularQueue(int k) {
            arr = new int[k];
            this.k = k;
        }

        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }
            arr[end] = value;
            count++;
            end = (end + 1) % arr.length;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) {
                return false;
            }
            start = (start + 1) % arr.length;
            count--;
            return true;
        }

        public int Front() {
            if(isEmpty()) {
                return -1;
            }
            return arr[start];
        }

        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            int index = (end - 1 < 0 ? end - 1 + arr.length : end - 1) % arr.length;

            return arr[index];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == arr.length;
        }
    }
}
