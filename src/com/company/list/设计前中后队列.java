package com.company.list;

import com.company.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 设计前中后队列 {
    public static void main(String[] args) {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        s.pushFront(1);
        s.pushBack(2);
        s.pushMiddle(3);
        s.pushMiddle(4);
        System.out.println(s.popFront());
        System.out.println(s.popMiddle());
        System.out.println(s.popMiddle());

    }
    static class FrontMiddleBackQueue {

        private Deque<Integer> front ;
        private Deque<Integer> back ;


        public FrontMiddleBackQueue() {
            front = new LinkedList<>();
            back = new LinkedList<>();
        }

        public void pushFront(int val) {
            front.addFirst(val);
            update();
        }

        public void pushMiddle(int val) {
            if(front.size() == back.size()) {
                front.addLast(val);
            }else if(front.size() - back.size()==1) {
                back.addFirst(front.pollLast());
                front.addLast(val);
            }
        }

        public void pushBack(int val) {
            back.addLast(val);
            update();
        }

        public int popFront() {
            if(front.size()==0) {
                return -1;
            }
            int r = front.pollFirst();
            update();
            return r;
        }

        public int popMiddle() {
            if(front.size()==0) return -1;
            int r = front.pollLast();
            update();
            return r;
        }

        public int popBack() {
            if(back.size()==0) {
                if(front.size()==0) return -1;
                return front.pollLast();
            }
            int r = back.pollLast();
            update();
            return r;
        }

        private void update() {
            if(front.size() - back.size()==2) {
                back.addFirst(front.pollLast());
            }else if(back.size() - front.size()==1) {
                front.addLast(back.pollFirst());
            }
        }
    }
}
