package com.company.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 堆盘子 {
    public static void main(String[] args) {
        StackOfPlates s = new StackOfPlates(0);
        s.push(62);
        System.out.println(s.pop());
    }
    static class StackOfPlates {
        private List<Stack<Integer>> linklist = new LinkedList<>();
        private int cap;
        private Stack<Integer> oneCap;
        public StackOfPlates(int cap) {
            this.cap = cap;
        }

        public void push(int val) {
            if(cap == 0) return ;
            if(linklist.isEmpty()||linklist.get(linklist.size()-1).size() == cap) {
                linklist.add(new Stack<>());
            }
            linklist.get(linklist.size()-1).push(val);
        }

        public int pop() {
            if(cap == 0) return -1;
            if(linklist.isEmpty()) return -1;
            int res = linklist.get(linklist.size()-1).pop();
            if(linklist.get(linklist.size()-1).size()==0) {
                linklist.remove(linklist.size()-1);
            }
            return res;
        }

        public int popAt(int index) {
            if(cap == 0) return -1;
            if(index >= linklist.size()) return -1;
            Stack<Integer> stack = linklist.get(index);
            int res = stack.pop();
            if(stack.size() == 0) linklist.remove(index);
            return res;
        }
    }
}
