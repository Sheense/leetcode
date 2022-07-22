package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 删除链表中的节点 {
    public static void main(String[] args) {
        删除链表中的节点 s = new 删除链表中的节点();
        ListNode node = ArrayUtils.getNodeList(4,5,1,9);
        ListNode n = node.next.next;
        s.deleteNode(n);
    }
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        node = node.next;
        while (node.next!=null){
            pre.val = node.val;
            pre = node;
            node = node.next;
        }
        pre.val = node.val;
        pre.next = null;
    }
}
