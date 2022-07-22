package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

import java.util.Stack;

/**
 * @Classname 链表最大孪生和
 * @Date 2022/1/8 10:42 下午
 * @Created by sheen
 * @Description TODO
 */
public class 链表最大孪生和 {
    public static void main(String[] args) {
        链表最大孪生和 s = new 链表最大孪生和();
        System.out.println(s.pairSum(ArrayUtils.getNodeList(5,4,2,1)));
    }
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode a = head;
        ListNode b = head;
        while (b != null) {
            stack.push(a.val);
            a = a.next;
            b = b.next.next;
        }
        int max = 0;
        while (a != null) {
            int v = a.val + stack.pop();
            max = Math.max(max, v);
            a = a.next;
        }
        return max;
    }
}
