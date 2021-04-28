package com.company.list;

import com.company.common.ListNode;
import com.company.common.TreeNode;
import com.company.util.ArrayUtils;

import java.util.HashMap;

public class 删除排序链表中的重复元素II {

    public static void main(String[] args) {
        删除排序链表中的重复元素II s = new 删除排序链表中的重复元素II();
        ArrayUtils.print(s.deleteDuplicates(ArrayUtils.getNodeList(1,1,2,2,3,5)));
    }
    /*public ListNode deleteDuplicates(ListNode head) {
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
    }*/

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = null;
        ListNode now = null;
        while (head != null) {
            if(head.next==null || head.val != head.next.val) {
                if(now == null) {
                    root = head;
                    now = head;
                }else {
                    now.next = head;
                    now = now.next;
                }
                head = head.next;
                now.next = null;
                continue;
            }
            ListNode item = head;
            while (item.next!=null && head.val == item.next.val) {
                item = item.next;
            }
            head = item.next;
            item.next = null;
        }
        return root;
    }

}
