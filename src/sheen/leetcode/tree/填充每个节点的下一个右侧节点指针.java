package sheen.leetcode.tree;


import sheen.leetcode.common.next.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size--!=0) {
                Node node = queue.poll();
                if(size!=0) node.next = queue.peek();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return root;
    }
}
