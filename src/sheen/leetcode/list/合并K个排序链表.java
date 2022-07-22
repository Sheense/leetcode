package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 合并K个排序链表 {

    public static void main(String[] args) {
        合并K个排序链表 s = new 合并K个排序链表();
        ListNode[] list = {
                            ArrayUtils.getNodeList(1,4,5),
                            ArrayUtils.getNodeList(1,3,4),
                            ArrayUtils.getNodeList(2,6)
        };
        ArrayUtils.print(s.mergeKLists(list));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        ListNode now = null;
        while(true) {
            boolean flag = false;
            int min = 0;
            for(int i=0;i<lists.length;i++) {
                if(lists[i]!=null){
                    flag = true;
                    if(lists[min]==null||lists[min].val>lists[i].val) {
                        min = i;
                    }
                }
            }
            if(flag) {
                if(root==null) {
                    root = lists[min];
                    now = lists[min];
                }else {
                    now.next = lists[min];
                    now = now.next;
                }
                lists[min] = lists[min].next;
            }else {
                break;
            }
        }
        return root;
    }
}
