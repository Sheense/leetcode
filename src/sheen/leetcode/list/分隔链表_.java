package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 分隔链表_ {
    public static void main(String[] args) {
        分隔链表_ s = new 分隔链表_();
        s.splitListToParts(ArrayUtils.getNodeList(1,2,3,4),5);
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode head = root;
        while(head!=null) {
            len++;
            head = head.next;
        }
        int yu = len % k;
        int item = len / k;
        ListNode[] res = new ListNode[k];
        ListNode start = root;
        for(int i=0;i<k&&start!=null;i++) {
            int time = item;
            ListNode node = null;
            while(time--!=0) {
                if(node==null) node = start;
                else start = start.next;
            }
            if(yu>0) {
                if(node == null) node = start;
                else start = start.next;
                yu--;
            }
            res[i] = node;
            if(start==null) break;
            ListNode n = start.next;
            start.next = null;
            start = n;
        }
        return res;
    }
}
