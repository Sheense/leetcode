package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ergodic(res, root);
        return res;
    }

    public void ergodic(List<Integer> list , TreeNode root) {
        if(root==null) return ;
        ergodic(list, root.left);
        list.add(root.val);
        ergodic(list, root.right);
    }


}
