package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 根到叶路径上的不足节点
 * @Date 2023/5/22 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 根到叶路径上的不足节点 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return recall(root, null, true, 0, limit);
    }

    //pre 上一个节点，当前节点是isLeft=true是上一个节点的左节点，all=根节点到前一个节点的值
    public TreeNode recall(TreeNode node, TreeNode pre, boolean isLeft, int all, int limit) {
        if(node.left == null && node.right == null) {
            if(all + node.val < limit) {
                if(pre != null) {
                    if(isLeft) {
                        pre.left = null;
                    }else {
                        pre.right = null;
                    }
                }else {
                    return null;
                }
            }

            return node;
        }

        if(node.left != null) {
            recall(node.left, node, true, all + node.val, limit);
        }

        if(node.right != null) {
            recall(node.right, node, false, all + node.val, limit);
        }


        //如果左右节点都被删了，说明链路没了，删除当前节点
        if(node.left == null && node.right == null) {
            if(pre == null) {
                return null;
            }

            if(isLeft) {
                pre.left = null;
            }else {
                pre.right = null;
            }
        }
        return node;
    }
}
