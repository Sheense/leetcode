package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Classname 二叉树中所有距离为K的结点
 * @Date 2021/7/28 12:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树中所有距离为K的结点 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<TreeNode>> parent = new HashMap<>();
        Map<Integer, Set<Integer>> childrenLeft = new HashMap<>();
        Map<Integer, Set<Integer>> childrenRight = new HashMap<>();
        parent.put(root.val, new ArrayList<>());
        recall(root, parent, childrenLeft, childrenRight);
        List<Integer> res = new ArrayList<>();
        dfs(target, 0, k, res);
        List<TreeNode> list = parent.get(target.val);
        int i = 1;

        while (i <= list.size()) {
            if(i == k) {
                res.add(list.get(list.size() - i).val);
                break;
            }

            TreeNode node = list.get(list.size() - i);
            if(childrenLeft.containsKey(node.val) && !childrenLeft.get(node.val).contains(target.val)) {
                dfs(node.left, 1, k - i, res);
            }
            if(childrenRight.containsKey(node.val) && !childrenRight.get(node.val).contains(target.val)) {
                dfs(node.right, 1, k - i, res);
            }
            i++;
        }

        return res;
    }

    public void dfs(TreeNode root, int now, int end, List<Integer> res) {
        if(now == end) {
            res.add(root.val);
            return;
        }
        if(root.left != null) {
            dfs(root.left, now + 1, end, res);
        }
        if(root.right != null) {
            dfs(root.right, now + 1, end, res);
        }
    }


    public Set<Integer> recall(TreeNode root, Map<Integer, List<TreeNode>> parent,
                               Map<Integer,Set<Integer>> childrenLeft,
                               Map<Integer,Set<Integer>> childrenRight) {

        List<TreeNode> nodes = parent.get(root.val);
        Set<Integer> set = new HashSet<>();

        if(root.left != null) {
            List<TreeNode> leftNode = new ArrayList<>(nodes);
            leftNode.add(root);
            parent.put(root.left.val, leftNode);
            Set<Integer> leftSet = recall(root.left, parent, childrenLeft, childrenRight);
            childrenLeft.put(root.val, leftSet);
            set.addAll(leftSet);
        }

        if(root.right != null) {
            List<TreeNode> rightNode  = new ArrayList<>(nodes);
            rightNode.add(root);
            parent.put(root.right.val, rightNode);
            Set<Integer> rightSet = recall(root.right, parent, childrenLeft, childrenRight);
            childrenRight.put(root.val, rightSet);
            set.addAll(rightSet);
        }

        set.add(root.val);
        return set;
    }
}
