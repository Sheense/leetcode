package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Classname 寻找重复的子树
 * @Date 2022/9/5 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 寻找重复的子树 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> map = new HashMap<>();
        Set<String> has = new HashSet<>();
        List<TreeNode> res = new LinkedList<>();
        build(root, map, has, res);
        return res;
    }

    public void build(TreeNode root, Map<String, TreeNode> map, Set<String> set, List<TreeNode> res) {
        if(root == null) {
            return;
        }
        String pre = pre(root);
        String mid = mid(root);
        String key = pre + "_" + mid;
        if(map.containsKey(key) && !set.contains(key)) {
            res.add(root);
            set.add(key);
        }else if(!map.containsKey(key)) {
            map.put(key, root);
        }
        build(root.left, map, set, res);
        build(root.right, map, set, res);
    }

    public String pre(TreeNode root) {
        if(root == null) return "";
        return root.val + "#" + pre(root.left) + "#" + pre(root.right) + "#";
    }

    public String mid(TreeNode root) {
        if(root == null) return "";
        return mid(root.left) + "#" + root.val + "#" + mid(root.right) + "#";
    }
}
