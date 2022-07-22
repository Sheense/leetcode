package sheen.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class 验证二叉树的前序序列化 {

    public static void main(String[] args) {
        验证二叉树的前序序列化 s = new 验证二叉树的前序序列化();
        System.out.println(s.isValidSerialization("9,#,#,1"));
    }
    public boolean isValidSerialization(String preorder) {
        if(preorder.length()==1) {
            if(preorder.equals("#")) return true;
        }
        if(preorder.charAt(0)=='#') return false;
        String arr[] = preorder.split(",");
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<arr.length;i++) {
            queue.offer(arr[i]);
        }

        return recall(queue) && queue.isEmpty();
    }

    public boolean recall(Queue<String> queue) {
        if(queue.isEmpty()) return false;
        String c = queue.poll();
        if(c.equals("#")) return true;
        boolean flag = recall(queue);
        if(!flag) return false;
        flag = recall(queue);
        if(!flag) return false;
        return true;
    }
}
