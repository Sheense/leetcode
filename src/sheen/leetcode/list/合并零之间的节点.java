package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

/**
 * @Classname 合并零之间的节点
 * @Date 2022/2/20 10:58 上午
 * @Created by sheen
 * @Description TODO
 */
public class 合并零之间的节点 {
    public ListNode mergeNodes(ListNode head) {
        ListNode res = null;
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            if (node.val == 0) {
                node = node.next;
            }else {
                int and = 0;
                if(res == null) {
                    res = node;
                    pre = node;
                }else {
                    pre.next = node;
                    pre = pre.next;
                }
                while (node.val != 0) {
                    and += node.val;
                    node = node.next;
                }

                pre.val = and;
            }
        }
        pre.next = null;
        return res;
    }
}
