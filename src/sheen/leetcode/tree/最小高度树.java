package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 最小高度树 {
    public static void main(String[] args) {
        最小高度树 s = new 最小高度树();
        s.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(0, nums.length-1, nums);
    }

    public TreeNode build(int start, int end, int[] nums) {
        if(start > end) return null;
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (end - start + 1)%2==1 ? (end + start) / 2 : (end + start) / 2+1;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(start, mid-1, nums);
        System.out.println(mid+1 + "," + end);
        root.right = build(mid + 1, end, nums);
        return root;
    }
}
