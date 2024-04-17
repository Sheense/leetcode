package sheen.leetcode.dfs;

import sheen.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 二叉搜索子树的最大键值和
 * @Date 2023/5/20 1:54 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉搜索子树的最大键值和 {
    private int ans = 0;
    public int maxSumBST(TreeNode root) {
        Map<TreeNode, int[]> map = new HashMap<>();

        getMaxMinMap(map, root);
        getMax(root, map);
        return ans;
    }

    public void getMaxMinMap(Map<TreeNode, int[]> map, TreeNode root) {

        int max = root.val;
        int min = root.val;
        if(root.left != null) {
            getMaxMinMap(map, root.left);
            int[] v = map.get(root.left);
            max = Math.max(max, v[0]);
            min = Math.min(min, v[1]);
        }

        if(root.right != null) {
            getMaxMinMap(map, root.right);
            int[] v = map.get(root.right);
            max = Math.max(max, v[0]);
            min = Math.min(min, v[1]);
        }

        map.put(root, new int[]{max, min});
    }

    public int[] getMax(TreeNode node, Map<TreeNode, int[]> map) {
        int code = 0;
        int res = node.val;
        int all = node.val;

        if(node.left != null) {
            int[] max = getMax(node.left, map);
            if(max[0] == 1) {
                code = 1;
            }else {
                if(res > max[1]) {
                    all += max[2];
                }else {
                    code = 1;
                }
            }
        }


        if(node.right != null) {
            int[] min = getMin(node.right, map);
            if(min[0] == 1) {
                code = 1;
            }else {
                if(res < min[1]) {
                    all += min[2];
                }else {
                    code = 1;
                }
            }
        }

        if(code == 0) {
            if(node.right != null) {
                int[] v = map.get(node.right);
                res = Math.max(v[0], res);
            }
            ans = Math.max(ans, all);
        }
        return new int[] {code, res, all};

    }

    public int[] getMin(TreeNode node, Map<TreeNode, int[]> map) {
        int code = 0;
        int res = node.val;
        int all = node.val;

        if(node.left != null) {
            int[] max = getMax(node.left, map);
            if(max[0] == 1) {
                code = 1;
            }else {
                if(res > max[1]) {
                    all += max[2];
                }else {
                    code = 1;
                }
            }
        }

        if(node.right != null) {
            int[] min = getMin(node.right, map);
            if(min[0] == 1) {
                code = 1;
            }else {
                if(res < min[1]) {
                    all += min[2];
                }else {
                    code = 1;
                }
            }
        }

        if(code == 0) {
            if(node.left != null) {
                int[] v = map.get(node.left);
                res = Math.min(v[1], res);
            }
            ans = Math.max(ans, all);
        }
        return new int[] {code, res, all};
    }




}
