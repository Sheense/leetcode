package sheen.leetcode.list;

import sheen.leetcode.common.ntree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++) {
                Node node = queue.poll();
                list.add(node.val);
                List<Node> nodes = node.children;
                queue.addAll(nodes);
                /*for(int j=0;j<nodes.size();j++){
                    queue.offer(nodes.get(j));
                }*/
            }
            size = queue.size();
            res.add(list);
        }
        return res;
    }
}
