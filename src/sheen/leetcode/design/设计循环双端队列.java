package sheen.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname 设计循环双端队列
 * @Date 2022/8/15 12:45 上午
 * @Created by sheen
 * @Description TODO
 */
public class 设计循环双端队列 {
    static class MyCircularDeque {

        private int size;
        private int count = 0;
        private Node front = null;
        private Node last = null;

        private static class Node{
            int val;
            Node next;
            Node pre;
        }

        public MyCircularDeque(int k) {
            this.size = k;
        }

        public boolean insertFront(int value) {
            if(count == size) {
                return false;
            }

            Node node = new Node();
            node.val = value;
            count++;
            if(count == 1) {
                front = node;
                last = node;
                front.next = last;
                front.pre = last;
            }else {
                Node pre = front.pre;
                node.next = front;
                front.pre = node;
                node.pre = pre;
                pre.next = node;
                front = node;
            }
            return true;
        }

        public boolean insertLast(int value) {
            if(count == size) {
                return false;
            }
            Node node = new Node();
            node.val = value;
            count++;
            if(count == 1) {
                front = node;
                last = node;
                front.next = last;
                front.pre = last;
            }else {
                Node next = last.next;
                node.next = next;
                next.pre = node;
                node.pre = last;
                last.next = node;
                last = node;
            }
            return true;
        }

        public boolean deleteFront() {
            if(count == 0) {
                return false;
            }
            count--;
            if(count == 0) {
                front = null;
                last = null;
            }else {
                Node newFront = front.next;
                Node pre = front.pre;
                newFront.pre = pre;
                pre.next = newFront;
                front = newFront;
            }
            return true;
        }

        public boolean deleteLast() {
            if(count == 0) {
                return false;
            }
            count--;
            if(count == 0) {
                front = null;
                last = null;
            }else {
                Node newLast = last.pre;
                Node next = last.next;
                newLast.next = next;
                next.pre = newLast;
                last = newLast;
            }

            return true;
        }

        public int getFront() {
            if(count == 0) {
                return -1;
            }
            return front.val;
        }

        public int getRear() {
            if(count == 0) {
                return -1;
            }

            return last.val;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == size;
        }
    }

}
