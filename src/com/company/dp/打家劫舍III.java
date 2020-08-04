package com.company.dp;

import com.company.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 打家劫舍III {
    public int rob(TreeNode root) {
        if(root==null) return 0;
        //选择根节点
        Map<TreeNode, Integer> f = new HashMap<>();
        //不选根节点
        Map<TreeNode, Integer> g = new HashMap<>();
        return dp(root, f,g,0);
    }

    public int dp(TreeNode root, Map<TreeNode, Integer> f, Map<TreeNode, Integer> g, int max) {
        if(root.left != null) {
            max = dp(root.left, f, g, max);
        }
        if(root.right != null) {
            max = dp(root.right, f,g,max);
        }
        int leftf = 0;
        int leftg = 0;
        int rightf = 0;
        int rightg = 0;
        if(root.left!=null) {
            leftf = f.get(root.left);
            leftg = g.get(root.left);
        }
        if(root.right != null) {
            rightf = f.get(root.right);
            rightg = g.get(root.right);
        }

        int of = root.val + leftg + rightg;
        int og = Math.max(Math.max(leftf+rightf, leftg+rightg), Math.max(leftg+rightf, leftf+rightg));
        f.put(root, of);
        g.put(root, og);
        return Math.max(Math.max(of,og), max);
    }

}
