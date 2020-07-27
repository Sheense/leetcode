package com.company.tree;

import com.company.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 好叶子节点对的数量 {
    public static void main(String[] args) {
        好叶子节点对的数量 s = new 好叶子节点对的数量();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(s.countPairs(root,3));
    }
    public int countPairs(TreeNode root, int distance) {
        return recall(root, 0, new HashMap<>(), 0, distance);
    }
    public int recall(TreeNode root, int floor, Map<Integer, Integer> leave, int res, int distance) {
        if(root.left==null&&root.right==null) {
            leave.put(floor, leave.getOrDefault(floor, 0)+1);
            return res;
        }
        Map<Integer,Integer> left = new HashMap<>();
        if(root.left!=null) {
            res = recall(root.left, floor + 1, left, res,distance);
        }
        Map<Integer,Integer> right = new HashMap<>();
        if(root.right!=null) {
            res =recall(root.right,floor+1,right,res,distance);
        }
        for (Integer key : left.keySet()) {
            if(floor+1<=key) {
                int d = distance - (key- floor);
                for(int j = floor+1;j<=floor+d;j++) {
                    if(right.containsKey(j)) {
                        res += left.get(key)*right.get(j);
                    }
                }
            }
        }
        for(int i : left.keySet()) {
            leave.put(i,leave.getOrDefault(i,0)+left.get(i));
        }
        for(int i : right.keySet()) {
            leave.put(i,leave.getOrDefault(i,0)+right.get(i));
        }
        return res;
    }
}
