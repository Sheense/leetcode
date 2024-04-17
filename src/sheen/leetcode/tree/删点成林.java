package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 删点成林
 * @Date 2023/5/30 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删点成林 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int v : to_delete) {
            set.add(v);
        }
        recall(null, true, root, set, res);
        if(!set.contains(root.val)) {
            res.add(root);
        }
        return res;
    }

    public void recall(TreeNode pre, boolean isLeft, TreeNode root, Set<Integer> set, List<TreeNode> res) {
        if(root == null) {
            return;
        }
        recall(root, true, root.left, set, res);
        recall(root, false, root.right, set, res);
        if(set.contains(root.val)) {
            if(root.left != null) {
                res.add(root.left);
            }
            if(root.right != null) {
                res.add(root.right);
            }

            if(pre != null) {
                if(isLeft) {
                    pre.left = null;
                }else {
                    pre.right = null;
                }
            }
        }
    }
}
