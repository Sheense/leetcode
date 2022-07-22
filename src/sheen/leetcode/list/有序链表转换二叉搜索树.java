package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.common.TreeNode;
import sheen.leetcode.util.ArrayUtils;

public class 有序链表转换二叉搜索树 {
    public static void main(String[] args) {
        有序链表转换二叉搜索树 s = new 有序链表转换二叉搜索树();
        s.sortedListToBST(ArrayUtils.getNodeList(-10,-3,0,5,9));
    }

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode root = head;
        while(root!=null) {
            n++;
            root = root.next;
        }
        return build(head, n);
    }
    public TreeNode build(ListNode head, int n) {
        if(n<=0) return null;
        if(n==1) return new TreeNode(head.val);
        int time = n/2 + 1;
        ListNode now = head;
        int i=1;
        while(i!=time) {
            now = now.next;
            i++;
        }
        TreeNode node = new TreeNode(now.val);
        node.left = build(head, i-1);
        node.right = build(now.next, n-i);
        return node;
    }
}
