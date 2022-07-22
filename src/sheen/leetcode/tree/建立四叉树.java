package sheen.leetcode.tree;

/**
 * @Classname 建立四叉树
 * @Date 2022/4/29 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 建立四叉树 {

    public static void main(String[] args) {
        建立四叉树 s = new 建立四叉树();
        s.construct(new int[][]{
                {1,1,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0},
                {1,1,0,0,0,0,1,1},
                {1,1,0,0,0,0,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,1,1},
                {1,1,1,1,1,1,0,0},
                {1,1,1,1,1,1,0,0}
        });
    }

    public Node construct(int[][] grid) {
        String[] strings = new String[grid.length];
        for(int i = 0; i < grid.length; i++) {
            String str = "";
            for(int j = 0; j < grid[i].length; j++) {
                str += grid[i][j];
            }
            strings[i] = str;
        }
        return recall( strings,0, 0, grid.length);
    }

    public Node recall(String[] strings, int x, int y, int len) {
        String str = strings[x].substring(y, y + len);
        boolean flag = true;
        for(int i = 0; i < len; i++) {
            String s = strings[x + i].substring(y, y + len);
            if(!s.equals(str)) {
                flag = false;
                break;
            }
        }
        Node node = new Node();

        if(flag) {
            for(int i = y; i < y + len; i++) {
                if(strings[x].charAt(y) != strings[x].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                node.isLeaf = true;
                node.val = strings[x].charAt(y) == '1';
                return node;
            }
        }

        node.isLeaf = false;
        node.topLeft = recall(strings, x, y, len / 2);
        node.bottomLeft = recall(strings, x + len / 2, y, len / 2);
        node.topRight = recall(strings, x, y + len / 2, len / 2);
        node.bottomRight = recall(strings, x + len / 2, y + len / 2, len / 2);
        return node;
    }


    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
}
