package com.company.tree;

import com.company.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 路径总和III {
    public int pathSum(TreeNode root, int sum) {
        return recall(new HashMap<>(), root, 0 ,sum);
    }

    public int recall(Map<Integer, Integer> map, TreeNode root, int res, int sum) {
        if(root==null) return res;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i: map.keySet()) {
            m.put(i+root.val, map.get(i));
        }
        m.put(root.val, m.getOrDefault(root.val, 0) + 1);
        res+= m.getOrDefault(sum, 0);
        res = recall(m, root.left, res, sum);
        return recall(m, root.right, res, sum);
    }
}
