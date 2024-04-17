package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 在受污染的二叉树中查找元素
 * @Date 2024/3/12 00:20
 * @Created by sheen
 * @Description TODO
 */
public class 在受污染的二叉树中查找元素 {
    static class FindElements {

        private Set<Integer> set = new HashSet<>();
        public FindElements(TreeNode root) {
            root.val = 0;
            recall(root, set);
        }

        public void recall(TreeNode root, Set<Integer> set) {
            if(root == null) {
                return;
            }
            set.add(root.val);
            if(root.left!= null) {
                root.left.val = 2 * root.val + 1;
            }
            if(root.right!=null) {
                root.right.val = 2 * root.val + 2;
            }

            recall(root.left, set);
            recall(root.right, set);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
