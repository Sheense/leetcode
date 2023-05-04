package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.TreeMap;

/**
 * @Classname 节点与其祖先之间的最大差值
 * @Date 2023/4/18 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 节点与其祖先之间的最大差值 {
    public int maxAncestorDiff(TreeNode root) {
        return recall(root, new TreeMap<>());
    }

    public int recall(TreeNode root, TreeMap<Integer, Integer> map) {
        if(root == null) {
            return -1;
        }

        int max = 0;
        if(!map.isEmpty()) {
            max = Math.max(Math.abs(map.firstKey() - root.val), Math.abs(map.lastKey() - root.val));
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        max = Math.max(recall(root.left, map), max);
        max = Math.max(recall(root.right, map), max);

        map.put(root.val, map.get(root.val) - 1);
        if(map.get(root.val) == 0) {
            map.remove(root.val);
        }
        return max;
    }
}
