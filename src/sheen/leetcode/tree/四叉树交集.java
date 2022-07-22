package sheen.leetcode.tree;

/**
 * @Classname 四叉树交集
 * @Date 2022/7/15 1:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 四叉树交集 {
    public Node intersect(Node quadTree1, Node quadTree2) {

        if(quadTree1.isLeaf && quadTree2.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }else if(quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }else if(quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        Node res = new Node();
        res.topLeft = recall(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight = recall(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft = recall(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = recall(quadTree1.bottomRight, quadTree2.bottomRight);
        if(isTrue(res.topLeft) && isTrue(res.topRight) && isTrue(res.bottomLeft) && isTrue(res.bottomRight)) {
            res = new Node();
            res.isLeaf = true;
            res.val = true;
        }else if(isFalse(res.topLeft) && isFalse(res.topRight) && isFalse(res.bottomLeft) && isFalse(res.bottomRight)) {
            res = new Node();
            res.isLeaf = true;
            res.val = false;
        }
        return res;
    }

    public boolean isTrue(Node node) {
        return node.isLeaf && node.val;
    }

    public boolean isFalse(Node node) {
        return node.isLeaf && !node.val;
    }

    public Node recall(Node a, Node b) {
        Node res;
        if(a.isLeaf && b.isLeaf) {
            if(a.val) {
                res = a;
            }else {
                res = b;
            }
        }else if(a.isLeaf) {
            res = a.val ? a : b;
        }else if(b.isLeaf) {
            res = b.val ? b : a;
        }else {
            res = intersect(a, b);
        }
        return res;
    }
    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
}
