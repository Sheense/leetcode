package sheen.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname N叉树的后序遍历
 * @Date 2022/3/12 12:52 上午
 * @Created by sheen
 * @Description TODO
 */
public class N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        recall(root, res);
        return res;
    }

    public void recall(Node root, List<Integer> res) {
        List<Node> child = root.children;
        if(child != null && child.size() > 0) {
            for(Node node : child) {
                recall(node, res);
            }
        }
        res.add(root.val);
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
