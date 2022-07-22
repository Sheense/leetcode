package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 返回倒数第k个节点 {

    public int kthToLast(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>(10000);
        while(head!=null) {
            list.add(head);
            head = head.next;
        }
        return list.size()==0?null:list.get(list.size()-k).val;
    }
}
