package sheen.leetcode.design;

import java.util.*;

/**
 * @Classname 最大频率栈
 * @Date 2022/11/30 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大频率栈 {
    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(1);
        stack.push(6);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    static class FreqStack {

        private int ID = 0;
        private Map<Integer, Stack<Integer>> map = new HashMap<>();
        private Stack<Integer> EMPTY_STACK = new Stack<>();
        private TreeSet<Integer> treeSet = new TreeSet<>((x, y) -> {

            if(map.getOrDefault(y, EMPTY_STACK).size() == map.getOrDefault(x, EMPTY_STACK).size()) {
                if(map.getOrDefault(y, EMPTY_STACK).size() == 0) {
                    return 0;
                }
                return Integer.compare(map.getOrDefault(y, EMPTY_STACK).peek(), map.getOrDefault(x, EMPTY_STACK).peek());
            }

            return map.getOrDefault(y, EMPTY_STACK).size() - map.getOrDefault(x, EMPTY_STACK).size();
        });

        public FreqStack() {

        }

        public void push(int val) {
            if(treeSet.contains(val)) {
                treeSet.remove(val);
            }
            map.computeIfAbsent(val, x -> new Stack<>()).push(ID++);
            treeSet.add(val);
        }

        public int pop() {
            int res = treeSet.first();
            treeSet.remove(res);
            map.get(res).pop();
            if(map.get(res).isEmpty()) {
                map.remove(res);
            }else {
                treeSet.add(res);
            }

            return res;
        }
    }
}
