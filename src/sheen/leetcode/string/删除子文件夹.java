package sheen.leetcode.string;

import java.util.*;

/**
 * @Classname 删除子文件夹
 * @Date 2023/2/8 6:34 下午
 * @Created by sheen
 * @Description TODO
 */
public class 删除子文件夹 {
    public static void main(String[] args) {
        删除子文件夹 s = new 删除子文件夹();
        System.out.println(s.removeSubfolders(new String[]{"/c","/d/c/e"}));
    }
    public List<String> removeSubfolders(String[] folder) {
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < folder.length; i++) {
            list.add(folder[i].substring(1).split("/"));
        }
        Collections.sort(list, (x, y) -> x.length - y.length);
        Map<String, Node> tree = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String[] item : list) {
            if(!hasPre(item, tree)) {
                res.add(getItem(item));
                updateTree(tree, item);
            }
        }

        return res;
    }

    public void updateTree(Map<String, Node> tree, String[] items) {
        Node node = tree.computeIfAbsent(items[0], x -> new Node(items[0]));
        int i = 1;
        while (i < items.length) {
            String key = items[i];
            node = node.next.computeIfAbsent(items[i], x -> new Node(key));
            i++;
        }

        node.isLeaf = true;
    }

    public String getItem(String[] item) {
        String res = "";
        for(String s : item) {
            res += "/" + s;
        }
        return res;
    }

    public boolean hasPre(String[] path, Map<String, Node> tree) {
        for(int i = 0; i < path.length; i++) {
            if(tree.containsKey(path[i])) {
                if(tree.get(path[i]).isLeaf) {
                    return true;
                }
                tree = tree.get(path[i]).next;
            }else {
                return false;
            }
        }
        return false;
    }



    public static class Node{
        public String nodeName;
        public Map<String, Node> next = new HashMap<>();
        public boolean isLeaf = false;
        public Node(String name) {
            this.nodeName = name;
        }
    }


}
