package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @Classname 二叉搜索树最近节点查询
 * @Date 2024/2/24 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 二叉搜索树最近节点查询 {
    public static void main(String[] args) {
        二叉搜索树最近节点查询 s = new 二叉搜索树最近节点查询();
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(9);
        System.out.println(s.closestNodes(root, Arrays.asList(3)));
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet();
        build(set, root);
        for(int v : queries) {
            Integer max = set.ceiling(v);
            Integer min = set.floor(v);
            res.add(Arrays.asList(min == null ? -1: min,max == null ? -1 : max));
        }
        return res;
    }





    public void build(TreeSet<Integer> treeSet, TreeNode root) {
        if(root == null) {
            return;
        }
        treeSet.add(root.val);
        build(treeSet, root.left);
        build(treeSet, root.right);
    }
}
