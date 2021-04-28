package com.company.test;


/*一个整数单链表，假设第一个节点我们定为下标为1，第二个为2，依次类推，同时假设下标为奇数的结点是升序排序，偶数的结点是降序排序，如何让整个链表升序？
 输入: 1->4->3->2->5->NULL
 输出: 1->2->3->4->5->NULL*/

public class Test {
    public static void main(String[] args) {
        Node[] arr = new Node[5];
        arr[0] = new Node(1);
        arr[1] = new Node(4);
        arr[2] = new Node(3);
        arr[3] = new Node(2);
        arr[4] = new Node(5);
        for(int i=0;i<4;i++) {
            arr[i].next = arr[i+1];
        }
        Node res = sort(arr[0]);
        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static class Node{
        public Node(int val) {
            this.val = val;
        }
        Node next;
        int val;
    }

    public static Node sort(Node root) {
        Node jiNode = null;
        Node jiNow = null;
        Node ouNode = null;
        Node ouNow = null;
        int index = 1;
        while (root != null) {
            if(index%2 == 0) {
                if(ouNode==null) {
                    ouNode = root;
                    ouNow = root;
                }else {
                    ouNow.next = root;
                    ouNow = ouNow.next;
                }
            }else {
                if(jiNode==null) {
                    jiNode = root;
                    jiNow = root;
                }else {
                    jiNow.next = root;
                    jiNow = jiNow.next;
                }
            }
            index++;
            root = root.next;
        }
        jiNow.next = null;
        ouNow.next = null;
        ouNode = reverse(ouNode);
        return sort(ouNode, jiNode);
    }

    public static Node sort(Node n1, Node n2) {
        Node res = null;
        Node now = null;
        while (n1!=null&&n2!=null) {
            if(n1.val<=n2.val) {
                if(res==null) {
                    res = n1;
                    now = n1;
                } else {
                    now.next = n1;
                    now = now.next;
                }
                n1 = n1.next;
            }else {
                if(res==null) {
                    res = n2;
                    now = n2;
                }
                else {
                    now.next = n2;
                    now = now.next;
                }
                n2 = n2.next;
            }
        }
        if(n1!=null) {
            now.next = n1;
        }
        if(n2!=null) {
            now.next = n2;
        }
        return res;
    }

    public static Node reverse(Node node) {
        Node pre = null;
        while (node!=null) {
            if(pre == null) {
                pre = node;
                node = node.next;
                pre.next = null;
            }else {
                Node item = node.next;
                node.next = pre;
                pre = node;
                node = item;
            }
        }
        return pre;
    }
}
