package com.company.map;

import java.util.*;

public class 克隆图 {

    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node res = new Node(node.val);
        build(new HashMap<>(), node, res, new HashSet<>());
        return res;
    }

    public void build(Map<Integer, Node> map, Node node, Node cloner,Set<Integer> set) {
        set.add(cloner.val);
        map.put(cloner.val, cloner);
        for(Node n : node.neighbors) {
            if(set.contains(n.val)) {
                Node v = map.get(n.val);
                cloner.neighbors.add(v);
            } else {
                Node v = new Node(n.val);
                cloner.neighbors.add(v);
                build(map, n, v, set);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
