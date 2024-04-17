package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

import java.util.TreeMap;

/**
 * @Classname 从链表中移除节点
 * @Date 2024/1/3 00:16
 * @Created by sheen
 * @Description TODO
 */
public class 从链表中移除节点 {
    public static void main(String[] args) {
        从链表中移除节点 s = new 从链表中移除节点();
        ListNode list = new ListNode(5);
        list.next = new ListNode(2);
        list.next.next = new ListNode(13);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(8);
        s.removeNodes(list);
    }
    public ListNode removeNodes(ListNode head) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ListNode root = head;
        while (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            root = root.next;
        }
        ListNode newRoot = null;
        ListNode now = null;
        root = head;
        while (root != null) {
            map.put(root.val, map.get(root.val) - 1);
            if (map.get(root.val) == 0) {
                map.remove(root.val);
            }
            if(map.higherKey(root.val) == null) {
                if(newRoot == null) {
                    newRoot = root;
                    now = root;
                }else {
                    now.next = root;
                    now = root;
                }
            }
            root = root.next;
        }
        if(now != null) {
            now.next = null;
        }
        return newRoot;
    }
}
