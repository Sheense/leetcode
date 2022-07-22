package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//遍历子树的节点
public class 首个共同祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return select(root, new HashSet<>(Arrays.asList(p.val, q.val)), new HashSet<>());
    }

    public TreeNode select(TreeNode root, Set<Integer> target, Set<Integer> allNode) {
        if(root == null) return null;
        Set<Integer> leftSet = new HashSet<>();
        TreeNode res = select(root.left, target, leftSet);
        if(res != null) return res;
        Set<Integer> rightSet = new HashSet<>();
        res = select(root.right, target, rightSet);
        if(res != null) return res;
        allNode.addAll(leftSet);
        allNode.addAll(rightSet);
        allNode.add(root.val);
        if(allNode.containsAll(target)) {
            return root;
        }
        return null;
    }
}
