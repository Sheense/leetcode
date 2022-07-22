package sheen.leetcode.tree;

/**
 * @Classname 从二叉树一个节点到另一个节点每一步的方向
 * @Date 2021/12/5 11:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 从二叉树一个节点到另一个节点每一步的方向 {
    /*public String getDirections(TreeNode root, int startValue, int destValue) {
        recall(root, startValue, destValue);

    }

    public boolean getPath(TreeNode root, int start, int end, List<String> res) {
        if(root == null) {
            return false;
        }
        res.add("L");
        getPath(root.left, start, end, res);
        res.remove(res.size() - 1);
    }
    private TreeNode target = null;
    public Set<Integer> recall(TreeNode root, int startValue, int destValue) {
        if(root == null) {
            return new HashSet<>();
        }
        Set<Integer> res = new HashSet<>();
        res.add(root.val);

        Set<Integer> left = recall(root.left, startValue, destValue);
        if(left.contains(startValue) && left.contains(destValue)) {
            return left;
        }

        Set<Integer> right = recall(root.right, startValue, destValue);
        if(left.contains(startValue) && left.contains(destValue)) {
            return right;
        }
        res.addAll(left);
        res.addAll(right);
        target = root;
        return res;
    }*/

}
