package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 链表组件 {
    public int numComponents(ListNode head, int[] G) {
        int size = 1;
        Set<Integer> set = new HashSet<>();
        for(int i:G) {
            set.add(i);
        }
        int res = 0;
        int len = 0;
        while(head!=null) {
            if(set.contains(head.val)) {
                len++;
            }else {
                if(len>0) {
                    res++;
                }
                len=0;
            }
            head = head.next;
        }
        if(len>0) res++;
        return res;
    }
}
