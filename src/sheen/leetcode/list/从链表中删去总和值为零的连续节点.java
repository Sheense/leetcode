package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class 从链表中删去总和值为零的连续节点 {
    public static void main(String[] args) {
        从链表中删去总和值为零的连续节点 s = new 从链表中删去总和值为零的连续节点();
        ArrayUtils.print(s.removeZeroSumSublists(ArrayUtils.getNodeList(1,2,3,-3,-2)));
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode root = head;
        while(root!=null) {
            root = head;
            Map<Integer, ListNode> map = new HashMap<>();
            int now = 0;
            do {
                now += root.val;
                if(map.containsKey(now)) {
                    break;
                }
                map.put(now, root);
                root = root.next;
            }while(root!=null&&now!=0);
            if(now==0) {
                head = root;
            }else if(map.containsKey(now)&&root!=null) {
                ListNode pre = map.get(now);
                pre.next = root.next;
            }
        }
        return head;
    }
}
