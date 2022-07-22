package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int start , int end) {
        if(start>end) return null;
        if(start==end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start+end)%2==1?(start+end)/2+1:(start+end)/2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, start, mid-1);
        root.right = build(nums, mid+1, end);
        return root;
    }
}
