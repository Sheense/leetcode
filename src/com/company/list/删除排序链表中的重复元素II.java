package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;

public class 删除排序链表中的重复元素II {

    public static void main(String[] args) {
        删除排序链表中的重复元素II s = new 删除排序链表中的重复元素II();
        ArrayUtils.print(s.deleteDuplicates(ArrayUtils.getNodeList(1,1)));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = null;
        ListNode now = null;
        while(head!=null) {
            ListNode item = head;
            boolean flag = false;
            while(head.next!=null&&item.val==head.next.val) {
                flag = true;
                head = head.next;
            }
            if(!flag) {
                if(root==null) {
                    root = item;
                    now = item;
                } else {
                    now.next = item;
                    now = now.next;
                }
            }
            head = head.next;
        }
        if(now!=null)now.next = null;
        return root;
    }

}
