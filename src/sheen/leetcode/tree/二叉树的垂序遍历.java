package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Classname 二叉树的垂序遍历
 * @Date 2021/7/31 1:22 下午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树的垂序遍历 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        recall(0, 0, root, map);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            List<Integer> item = new ArrayList<>();
            Map<Integer, List<Integer>> m = map.get(list.get(i));
            List<Integer> list1 = new ArrayList<>(m.keySet());
            Collections.sort(list1);
            for(int j = 0; j < list1.size(); j++) {
                List<Integer> l = m.get(list1.get(i));
                Collections.sort(l);
                item.addAll(l);
            }
            res.add(item);
        }
        return res;
    }

    public void recall(int row, int col, TreeNode root, Map<Integer, Map<Integer, List<Integer>>> map) {
        if(root == null) {
            return;
        }
        map.computeIfAbsent(col, x -> new HashMap<>()).computeIfAbsent(row, x -> new ArrayList<>())
                .add(root.val);
        recall(row+1, col-1, root.left, map);
        recall(row+1, col+1, root.right, map);
    }



}
