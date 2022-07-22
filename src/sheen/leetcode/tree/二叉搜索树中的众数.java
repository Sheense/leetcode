package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;
import sheen.leetcode.util.ArrayUtils;

import java.util.*;

public class 二叉搜索树中的众数 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        二叉搜索树中的众数 s = new 二叉搜索树中的众数();
        ArrayUtils.print(s.findMode(root));
    }

    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> res = new ArrayList<>();
        recall(root,res);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:res) {
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        int max = 0;
        for(int i:map.values()) {
            if(max<i) max = i;
        }
        List<Integer> list = new ArrayList<>();
        for(int i:map.keySet()) {
            if(map.get(i)==max) {
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void recall(TreeNode root,List<Integer> res) {
        if(root.left==null&&root.right==null) {
            res.add(root.val);
            return;
        }
        if(root.left!=null) recall(root.left, res);
        res.add(root.val);
        if(root.right!=null) recall(root.right, res);
    }


}
