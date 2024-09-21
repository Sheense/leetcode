package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Classname 感染二叉树需要的总时间
 * @Date 2024/4/24 00:34
 * @Created by sheen
 * @Description TODO
 */
public class 感染二叉树需要的总时间 {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        build(map, root, null);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> set = new HashSet<>();
        int res = 0;
        set.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size--!=0) {
                int item = queue.poll();
                for(int next : map.getOrDefault(item, new ArrayList<>())) {
                    if(!set.contains(next)) {
                        set.add(next);
                        queue.offer(next);
                    }
                }
            }

            res++;
        }
        return res - 1;
    }

    public void build(Map<Integer, List<Integer>> map, TreeNode root, TreeNode pre) {

        if(pre != null) {
            map.computeIfAbsent(root.val, x -> new ArrayList<>()).add(pre.val);
        }

        if(root.left != null) {
            map.computeIfAbsent(root.val, x -> new ArrayList<>()).add(root.left.val);
            build(map, root.left, root);
        }
        if(root.right != null) {
            map.computeIfAbsent(root.val, x -> new ArrayList<>()).add(root.right.val);
            build(map, root.right, root);
        }

    }



}
