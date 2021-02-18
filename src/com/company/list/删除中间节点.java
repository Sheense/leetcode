package com.company.list;

import com.company.common.ListNode;

public class 删除中间节点 {
    public void deleteNode(ListNode node) {
        ListNode root = node;
        ListNode pre = null;
        while(root.next!=null) {
            root.val = root.next.val;
            pre = root;
            root = root.next;
        }
        pre.next = null;
    }
}
