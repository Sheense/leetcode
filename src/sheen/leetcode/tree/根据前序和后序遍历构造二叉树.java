package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 根据前序和后序遍历构造二叉树
 * @Date 2024/2/22 00:34
 * @Created by sheen
 * @Description TODO
 */
public class 根据前序和后序遍历构造二叉树 {
    public static void main(String[] args) {
        根据前序和后序遍历构造二叉树 s = new 根据前序和后序遍历构造二叉树();
        s.constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return recall(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode recall(int[] preorder, int[] postorder, int ps1, int pe1, int ps2, int pe2) {
        if(ps1 == pe1) {
            return new TreeNode(preorder[ps1]);
        }
        if(ps1 > pe1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps1]);
        int i = ps1 + 1;
        int j = ps2;
        int v1 = 0;
        int v2 = 0;
        while (i <= pe1) {
            v1 |= 1 << preorder[i];
            v2 |= 1 << postorder[j];
            if(v1 == v2) {
                break;
            }
            i++;
            j++;
        }
        root.left = recall(preorder, postorder, ps1 + 1, i, ps2, j);
        root.right = recall(preorder, postorder, i + 1, pe1, j + 1, pe2 - 1);
        return root;
    }
}
