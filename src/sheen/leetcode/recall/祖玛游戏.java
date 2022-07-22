package sheen.leetcode.recall;

import java.util.*;

/**
 * @Classname 祖玛游戏
 * @Date 2021/11/9 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 祖玛游戏 {
    public static void main(String[] args) {
        祖玛游戏 s = new 祖玛游戏();
        System.out.println(s.findMinStep("RRWWRRBBRR", "WB"));
    }
    public int findMinStep(String board, String hand) {
        recall(0, board, hand, board.length());
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    int min = Integer.MAX_VALUE;
    public void recall(int index, String board, String hand, int origin) {
        if(check(board)) {
            min = Math.min(min, board.length() - origin);
            return;
        }
        if(index >= hand.length()) {
            return;
        }
        if(min != Integer.MAX_VALUE && min <= board.length() - origin + 1) {
            return;
        }
        for(int i = 0; i <= board.length(); i++) {
            if(i == 0) {
                recall(index + 1, hand.charAt(index) + board, hand, origin);
            }else if(i == board.length()) {
                recall(index + 1, board + hand.charAt(index), hand, origin);
            }else {
                recall(index + 1, board.substring(0, i) + hand.charAt(index) + board.substring(i), hand, origin);
            }
        }
        recall(index + 1, board, hand, origin);

    }
    public boolean check(String board) {
        Stack<Character> c_stack = new Stack<>();
        Stack<Integer> n_stack = new Stack<>();
        int index = 0;
        while (index < board.length()) {
            int i = index;
            while (i < board.length() && board.charAt(i) == board.charAt(index)) {
                i++;
            }
            if(i - index < 3) {
                if(c_stack.isEmpty() || c_stack.peek() != board.charAt(index)) {
                    c_stack.push(board.charAt(index));
                    n_stack.push(i - index);
                }else {
                    if((i - index) + n_stack.peek() >= 3) {
                        c_stack.pop();
                        n_stack.pop();
                    }else {
                        n_stack.push(n_stack.pop() + (i - index));
                    }
                }
            }
            index = i;
        }
        return c_stack.isEmpty();
    }
}
