package sheen.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname N叉树的前序遍历
 * @Date 2022/3/10 12:28 上午
 * @Created by sheen
 * @Description TODO
 */
public class N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if(node.children != null) {
                for(int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return res;
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
