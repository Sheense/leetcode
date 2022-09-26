package sheen.leetcode.design;

/**
 * @Classname 设计链表
 * @Date 2022/9/23 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 设计链表 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(0);
        list.addAtIndex(1, 4);
        list.addAtTail(8);
        list.addAtHead(5);
        list.addAtIndex(4, 3);
        list.addAtTail(0);
        list.addAtTail(5);
        list.addAtIndex(6, 3);
        list.deleteAtIndex(7);
        list.deleteAtIndex(5);
        list.addAtTail(4);
    }
    public static class MyLinkedList {

        private Node root = null;
        private int count = 0;
        public MyLinkedList() {

        }

        public int get(int index) {
            if(index >= count || index < 0) return -1;
            int i = 0;
            Node node = root;
            while (i != index) {
                node = node.next;
                i++;
            }
            return node.val;
        }

        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            if(root == null) {
                root = node;
                node.next = node;
                node.pre = node;
            }else {
                Node pre = root.pre;
                root.pre = node;
                node.next = root;
                node.pre = pre;
                pre.next = node;
            }
            root = node;
            count++;
        }

        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
            if(root == null) {
                root = node;
                node.next = node;
                node.pre = node;
            }else {
                Node tail = root.pre;
                tail.next = node;
                node.pre = tail;
                node.next = root;
                root.pre = node;
            }
            count++;
        }

        public void addAtIndex(int index, int val) {
            if(index <= 0) {
                addAtHead(val);
                return;
            }

            if(index == count) {
                addAtTail(val);
                return;
            }

            if(index < count) {
                int i = 0;
                Node newNode = new Node();
                newNode.val = val;
                Node node = root;
                Node pre = root.pre;
                while (i != index) {
                    pre = node;
                    node = node.next;
                    i++;
                }
                pre.next = newNode;
                newNode.next = node;
                node.pre = newNode;
                newNode.pre = pre;

                count++;
            }

        }

        public void deleteAtIndex(int index) {
            if(index >= 0 && index < count) {
                if(count == 1) {
                    root = null;
                }else {
                    int i = 0;
                    Node pre = root.pre;
                    Node node = root;
                    while (i != index) {
                        pre = node;
                        node = node.next;
                        i++;
                    }
                    Node next = node.next;
                    node.next.pre = pre;
                    pre.next = next;
                    node.next = null;
                    node.pre = null;
                    if(index == 0) {
                        root = next;
                    }
                }
                count --;
            }
        }
    }

    public static class Node{
        Node pre;
        Node next;
        int val;
    }
}
