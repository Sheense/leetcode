package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class 移除重复节点 {
    public static void main(String[] args) {
        移除重复节点 s = new 移除重复节点();
        ArrayUtils.print(s.removeDuplicateNodes(ArrayUtils.getNodeList(1,2,3,3,2,1)));
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode root = head;
        ListNode now = head;
        set.add(head.val);
        while(head.next!=null) {
            if(!set.contains(head.next.val)) {
                set.add(head.next.val);
                now.next = head.next;
                now = now.next;
            }
            head = head.next;
        }
        now.next=null;
        return root;
    }
}
