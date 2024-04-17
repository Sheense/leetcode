package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 所有可能的真二叉树
 * @Date 2024/4/2 00:10
 * @Created by sheen
 * @Description TODO
 */
public class 所有可能的真二叉树 {
    public static void main(String[] args) {
        所有可能的真二叉树 s = new 所有可能的真二叉树();
        System.out.println(s.allPossibleFBT(7).size());
    }
    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0) {
            return Arrays.asList();
        }

        if(n == 1) {
            return Arrays.asList(new TreeNode(0));
        }

        List<TreeNode> res = new ArrayList<>();

        List<TreeNode> list = allPossibleFBT(n - 1);
        for(TreeNode node : list) {
            TreeNode item = new TreeNode(0);
            item.right = node;
            res.add(item);
        }
        for(TreeNode node : list) {
            TreeNode item = new TreeNode(0);
            item.right = node;
            res.add(item);
        }

        for(int i = 1; i < n - 1; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }

        return res;
    }


}
