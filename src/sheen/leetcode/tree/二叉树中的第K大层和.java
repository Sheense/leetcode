package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Classname 二叉树中的第K大层和
 * @Date 2024/2/23 00:43
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树中的第K大层和 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> map = new HashMap<>();
        recall(root, 0, map);
        if(map.size() < k) {
            return -1;
        }

        List<Long> list = new ArrayList<>(map.values());
        Collections.sort(list, (x, y) -> {
            if(y > x) {
                return 1;
            }else {
                return -1;
            }
        });
        return list.get(k - 1);
    }

    public void recall(TreeNode root, int now, Map<Integer, Long> map) {
        if(root == null) {
            return;
        }

        map.put(now, map.getOrDefault(now, 0L) + root.val);

        recall(root.left, now + 1,  map);
        recall(root.right, now + 1,  map);
    }
}
