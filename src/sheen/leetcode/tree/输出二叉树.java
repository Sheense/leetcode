package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 输出二叉树
 * @Date 2022/8/22 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 输出二叉树 {
    public static void main(String[] args) {
        输出二叉树 s = new 输出二叉树();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        s.printTree(root);
    }
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int height = findHeight(root);
        int n = (int)Math.pow(2, height) - 1;
        for(int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }
        build(res, 0, (n - 1) / 2, root, height - 1);
        return res;
    }

    public void build(List<List<String>> list, int row, int index, TreeNode node, int height) {
        if(node == null) return;
        list.get(row).set(index, String.valueOf(node.val));
        build(list, row + 1, index - (int)Math.pow(2, height - row - 1), node.left, height);
        build(list, row + 1, index + (int)Math.pow(2, height - row - 1), node.right, height);
    }

    public int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
