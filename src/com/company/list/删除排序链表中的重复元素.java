package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;

public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        删除排序链表中的重复元素 S = new 删除排序链表中的重复元素();
        ArrayUtils.print(S.deleteDuplicates(ArrayUtils.getNodeList(1,1,2)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode root = null;
        ListNode now = null;
        while(head!=null) {
            if(root == null) {
                root = head;
                now = head;
            }else {
                if(head.val == now.val) {
                    while(head.next!=null&&head.next.val==now.val) {
                        head = head.next;
                    }
                }else {
                    now.next = head;
                    now = now.next;
                }
            }
            head = head.next;
        }
        now.next = null;
        return root;
    }
}
