package com.company.tree;

import com.company.common.ListNode;
import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 特定深度节点链表 {
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = null;
            ListNode now = null;
            while(size--!=0) {
                TreeNode node = queue.poll();
                if(head==null) {
                    head = new ListNode(node.val);
                    now = head;
                }else {
                    now.next = new ListNode(node.val);
                    now = now.next;
                }
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            res.add(head);
        }
        ListNode[] ans = new ListNode[res.size()];
        for(int i=0;i<ans.length;i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
