package com.company.dfs;

/**
 * @Classname 文件的最长绝对路径
 * @Date 2022/4/20 12:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 文件的最长绝对路径 {
    public static void main(String[] args) {
        文件的最长绝对路径 s = new 文件的最长绝对路径();
        System.out.println(s.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext\n"));
    }
    public int lengthLongestPath(String input) {
        String[] strings = input.split("\n");
        Node[] nodes = new Node[strings.length];
        for(int i = 0; i < strings.length; i++) {
            nodes[i] = getSplit(strings[i]);
        }

        recall(nodes, 0, "", 0);
        return res;
    }

    private int res = 0;

    public int recall(Node[] nodes, int expect, String pre, int index) {
        if(index >= nodes.length || nodes[index].num != expect) {
            if(pre.contains(".")) {
                res = Math.max(pre.length() - 1, res);
            }

            return index;
        }

        while (index < nodes.length && nodes[index].num == expect) {
            String str = pre + "/" + nodes[index].str;
            index = recall(nodes, expect + 1, str, index + 1);
        }

        return index;
    }

    public static class Node{
        int num;
        String str;
        public Node(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }

    public Node getSplit(String str) {
        int res = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '\t') {
                res++;
            }else {
                break;
            }
        }

        return new Node(res, str.substring(res));
    }
}
