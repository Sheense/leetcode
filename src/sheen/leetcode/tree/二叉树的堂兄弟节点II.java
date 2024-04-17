package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Classname 二叉树的堂兄弟节点II
 * @Date 2024/2/7 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树的堂兄弟节点II {
    public static void main(String[] args) {
        二叉树的堂兄弟节点II s = new 二叉树的堂兄弟节点II();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(s.replaceValueInTree(root));
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root, null});
        while (!queue.isEmpty()) {
            List<TreeNode[]> list = new ArrayList<>();
            int size = queue.size();
            int all = 0;
            while (size-- != 0) {
                TreeNode[] arr = queue.poll();
                list.add(arr);

                if(arr[0] != null) {
                    all += arr[0].val;
                    if(arr[0].left != null || arr[0].right != null) {
                        queue.offer(new TreeNode[]{arr[0].left, arr[0].right});
                    }
                }

                if(arr[1] != null) {
                    all += arr[1].val;
                    if(arr[1].left != null || arr[1].right != null) {
                        queue.offer(new TreeNode[]{arr[1].left, arr[1].right});
                    }
                }
            }

            for(TreeNode[] arr : list) {
                int left = arr[0] == null ? 0 : arr[0].val;
                int right = arr[1] == null ? 0 : arr[1].val;
                if(arr[0] != null) {
                    arr[0].val = all - (left + right);
                }
                if(arr[1] != null) {
                    arr[1].val = all - (left + right);
                }
            }
        }
        return root;
    }
}
