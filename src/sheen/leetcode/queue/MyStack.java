package sheen.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);;
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }


    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue2.isEmpty()) queue1.offer(x);
        else queue2.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> q1 = queue1.isEmpty()?queue2:queue1;
        Queue<Integer> q2 = queue1.isEmpty()?queue1:queue2;
        int n = q1.poll();
        while(!q1.isEmpty()) {
            q2.offer(n);
            n = q1.poll();
        }
        return n;
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> q1 = queue1.isEmpty()?queue2:queue1;
        Queue<Integer> q2 = queue1.isEmpty()?queue1:queue2;
        int n = 0;
        while(!q1.isEmpty()) {
            n = q1.poll();
            q2.offer(n);
        }
        return n;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue2.size()==0&&queue1.size()==0) return true;
        else  return false;
    }
}
