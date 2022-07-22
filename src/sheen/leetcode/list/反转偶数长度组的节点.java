package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 反转偶数长度组的节点
 * @Date 2021/11/14 11:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 反转偶数长度组的节点 {
    public static void main(String[] args) {
        反转偶数长度组的节点 s = new 反转偶数长度组的节点();
        s.reverseEvenLengthGroups(ArrayUtils.getNodeList(5,2,6,3,9,1,7,3,8,4));
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int i = 1;
        ListNode pre = null;
        ListNode now = head;
        while (now != null) {

            int len = 0;
            ListNode n = now;
            while (n != null && len < i) {
                len ++;
                n = n.next;
            }

            if(len % 2 == 1) {
                for(int j = 0; j < i && now != null; j++) {
                    if(pre == null) {
                        pre = now;
                    }else {
                        pre.next = now;
                        pre = now;
                    }
                    now = now.next;
                }
            }else {
                int j = 0;
                ListNode l = now;
                ListNode next = now.next;
                while (next != null && j < i - 1) {
                    ListNode node = next.next;
                    next.next = now;
                    now = next;
                    next = node;
                    j ++;
                }
                pre.next = now;
                l.next = next;
                now = next;
                pre = l;
            }
            i ++;
        }
        return head;
    }


}
