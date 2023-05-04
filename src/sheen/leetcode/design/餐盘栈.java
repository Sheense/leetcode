package sheen.leetcode.design;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @Classname 餐盘栈
 * @Date 2023/4/28 3:34 下午
 * @Created by sheen
 * @Description TODO
 */
public class 餐盘栈 {
    public static void main(String[] args) {
        DinnerPlates s = new DinnerPlates(1);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.popAtStack(0));
        s.push(20);
        s.push(21);
        System.out.println(s.popAtStack(0));
        System.out.println(s.popAtStack(2));
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
    static class DinnerPlates {
        //保存栈和栈的索引，维护里面的lastkey不会超过map的大小
        private TreeMap<Integer, MyStack> map = new TreeMap<>();
        //保存没有满的栈，按序号排序
        private PriorityQueue<MyStack> queue;

        private int capacity;
        public DinnerPlates(int capacity) {
            this.capacity = capacity;
            queue = new PriorityQueue<>((x, y) -> x.index - y.index);
        }

        public void push(int val) {
            if(queue.isEmpty()) {
                int index = map.size();
                MyStack myStack = new MyStack();
                myStack.index = index;
                map.put(index, myStack);
                myStack.stack.push(val);
                if(myStack.stack.size() < capacity) {
                    queue.offer(myStack);
                }
                return;
            }

            MyStack myStack = queue.poll();

            //处理掉在队尾为空，在map中已经清理掉的栈，这里的队尾不是说是优先队列的队尾，是总的队尾
            if(myStack.stack.isEmpty() && myStack.index > map.size() - 1) {
                myStack.index = map.size();
                map.put(myStack.index, myStack);
            }
            myStack.stack.push(val);

            //不满就加到优先队列中
            if(myStack.stack.size() < capacity) {
                queue.offer(myStack);
            }
        }

        public int pop() {
            //从真实的队尾，把空的栈删除
            while (!map.isEmpty() && map.get(map.lastKey()).stack.isEmpty()) {
                map.remove(map.lastKey());
            }

            if(map.isEmpty()) {
                return -1;
            }

            int lastKey = map.lastKey();
            MyStack value = map.get(lastKey);

            int res = value.stack.pop();
            if(value.stack.isEmpty()) {
                map.remove(lastKey);
            }

            //原先是满的，弹出元素后，不满了，加到优先队列
            if(value.stack.size() == capacity - 1) {
                queue.offer(value);
            }

            return res;
        }

        public int popAtStack(int index) {
            if(map.get(index) == null || map.get(index).stack.isEmpty()) {
                return -1;
            }

            MyStack value = map.get(index);

            int res = value.stack.pop();
            //如果pop的编号为index的stack，刚好index是队尾且为空，清理掉
            if(value.stack.isEmpty() && map.size() - 1 == index) {
                map.remove(index);
            }

            //原先是满的，弹出元素后，不满了，加到优先队列
            if(value.stack.size() == capacity - 1) {
                queue.offer(value);
            }

            return res;
        }

        private static class MyStack{
            private Stack<Integer> stack = new Stack<>();
            private int index;
        }
    }
}
