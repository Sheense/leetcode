package com.company.tree;

import com.company.common.TreeNode;
import com.company.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 出现次数最多的子树元素和
 * @Date 2022/6/19 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 出现次数最多的子树元素和 {
    public static void main(String[] args) {
        出现次数最多的子树元素和 s = new 出现次数最多的子树元素和();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        ArrayUtils.print(s.findFrequentTreeSum(root));
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        recall(map, root);
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (x, y) -> map.get(y) - map.get(x));
        int index = 0;
        while (index < list.size() && map.get(list.get(0)) == map.get(list.get(index))) {
            index++;
        }

        int[] res = new int[index];
        for(int j = 0; j < index; j++) {
            res[j] = list.get(j);
        }
        return res;
    }

    public int recall(Map<Integer, Integer> map, TreeNode root) {
        if(root == null) return 0;
        int v = root.val;
        v += recall(map, root.left);
        v += recall(map, root.right);
        map.put(v, map.getOrDefault(v, 0) + 1);
        return v;
    }
}
