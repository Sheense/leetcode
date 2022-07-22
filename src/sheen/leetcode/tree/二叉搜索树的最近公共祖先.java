package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode maxNode = p.val>q.val?p:q;
        TreeNode minNode = p.val>q.val?q:p;
        List<TreeNode> parentNode = new ArrayList<>();
        TreeNode now = root;
        while(now.val!=maxNode.val) {
            parentNode.add(now);
            if(now.val>maxNode.val) {
                now = now.left;
            }else {
                now = now.right;
            }
        }
        parentNode.add(maxNode);
        for(int i=parentNode.size()-1;i>=0;i--) {
            now = parentNode.get(i);
            if(now.val==minNode.val) return  minNode;
            while(now!=null&&now.val!=minNode.val) {
                if(now.val>minNode.val) {
                    now = now.left;
                }else {
                    now = now.right;
                }
            }
            if(now!=null) return parentNode.get(i);
        }
        return null;
    }
}
