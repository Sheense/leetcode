package com.company.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 统计最高分的节点数目
 * @Date 2021/10/24 4:26 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计最高分的节点数目 {
    public static void main(String[] args) {
        统计最高分的节点数目 s = new 统计最高分的节点数目();
        System.out.println(s.countHighestScoreNodes(new int[]{-1,2,0}));
    }
    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, Node> map = new HashMap<>();
        Node root = null;
        for(int i = 0; i < parents.length; i++) {
            map.put(i, new Node());
            if(parents[i] == -1) {
                root = map.get(i);
            }
        }

        for(int i = 0; i < parents.length; i++) {
            int p = parents[i];
            if(p == -1) {
                continue;
            }
            Node r = map.get(p);
            if(r.left == null) {
                r.left = map.get(i);
            }else {
                r.right = map.get(i);
            }
        }
        long max = 0;
        int res = 0;
        count(root);
        for(int i = 0; i < parents.length; i++) {
            Node node = map.get(i);
            long leftSize = node.left == null ? 1 : node.left.count;
            long rightSize = node.right == null ? 1 : node.right.count;
            long pSize = 1;
            if(parents[i] != -1) {
                pSize = parents.length - node.count;
            }
            long value = leftSize * rightSize * pSize;
            if(max == value) {
                res++;
            }else if(max < value) {
                max = value;
                res = 1;
            }
        }
        return res;
    }

    public int count(Node root) {
        if(root == null) {
            return 0;
        }
        int c = count(root.left) + count(root.right) + 1;
        root.count = c;
        return c;
    }



    public static class Node{
        Node left;
        Node right;
        int count = 1;
    }
}
