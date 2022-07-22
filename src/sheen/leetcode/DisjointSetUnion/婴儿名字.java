package sheen.leetcode.DisjointSetUnion;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 婴儿名字 {
    public static void main(String[] args) {
        婴儿名字 s = new 婴儿名字();
        ArrayUtils.print(s.trulyMostPopular(new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"}, new String[]{"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"}));
    }
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Node> map = new HashMap<>();
        for(int i=0;i<names.length;i++) {
            String[] str = names[i].split("\\(");
            Node node = new Node();
            node.name = str[0];
            node.time = Integer.valueOf(str[1].substring(0, str[1].length()-1));
            map.put(node.name, node);
        }
        for(int i=0;i<synonyms.length;i++) {
            String n[] = synonyms[i].substring(1, synonyms[i].length()-1).split(",");
            Node r1 = findRoot(map.getOrDefault(n[0], new Node(n[0])));
            Node r2 = findRoot(map.getOrDefault(n[1], new Node(n[1])));
            if(r1!=r2) {
                if(r1.name.compareTo(r2.name)>=0) {
                    r2.time += r1.time;
                    r1.parent = r2;
                }else {
                    r1.time += r2.time;
                    r2.parent = r1;
                }
            }
        }
        List<Node> list = new ArrayList<>();
        for(Node node:map.values()) {
            if(node.parent==node) list.add(node);
        }
        String[] res = new String[list.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = list.get(i).name+"("+list.get(i).time+")";
        }
        return res;
    }

    public Node findRoot(Node node) {
        while(node.parent!=node) {
            node = node.parent;
        }
        return node;
    }

    public class Node{
        public Node() {}
        public Node(String name) {
            this.name = name;
        }
        Node parent = this;
        int time = 0;
        String name = "";
    }
}
