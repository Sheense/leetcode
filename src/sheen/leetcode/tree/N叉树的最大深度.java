package sheen.leetcode.tree;

import java.util.List;

/**
 * @Classname N叉树的最大深度
 * @Date 2021/11/21 12:30 下午
 * @Created by sheen
 * @Description TODO
 */
public class N叉树的最大深度 {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int max = 0;
        for(int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepth(root.children.get(i)), max);
        }

        return max + 1;
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
