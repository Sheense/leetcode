package sheen.leetcode.list;

/**
 * @Classname 展平多级双向链表
 * @Date 2023/5/5 11:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 展平多级双向链表 {
    public static void main(String[] args) {
        展平多级双向链表 s = new 展平多级双向链表();
        Node root = new Node();
        root.val = 1;
        Node second = new Node();
        second.val = 2;
        Node third = new Node();
        third.val = 3;
        root.child = second;
        second.child = third;
        Node res = s.flatten(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public Node flatten(Node head) {
        Node root = head;
        while (root != null) {
            if(root.child != null) {
                Node tail = findTail(root.child);
                Node next = root.next;
                root.next = root.child;
                root.child.prev = root;
                if(next != null) {
                    next.prev = tail;
                }
                tail.next = next;
                root.child = null;
                root = next;
            }else {
                root = root.next;
            }
        }
        return head;
    }

    public Node findTail(Node node) {
        Node pre = null;
        while (node != null) {
            if(node.child != null) {
                Node tail = findTail(node.child);
                Node next = node.next;
                node.next = node.child;
                node.child.prev = node;
                tail.next = next;
                if(next != null) {
                    next.prev = tail;
                }
                node.child = null;
                pre = tail;
                node = next;
            }else {
                pre = node;
                node = node.next;
            }
        }
        return pre;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
