package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recall(root, list);
        for(int i=0;i<list.size();i++) {
            if(list.get(i).val>list.get(i+1).val) {
                int index = i+1;
                while(index+1<list.size()&&list.get(index).val<list.get(index+1).val) {
                    index++;
                }
                if(index+1==list.size()) {
                    int item = list.get(i+1).val;
                    list.get(i+1).val = list.get(i).val;
                    list.get(i).val = item;
                }else {
                    int item = list.get(index+1).val;
                    list.get(index+1).val = list.get(i).val;
                    list.get(i).val = item;
                }
                break;
            }
        }

    }

    public void recall(TreeNode root, List<TreeNode> list) {
        if(root==null) return;
        recall(root.left, list);
        list.add(root);
        recall(root.right, list);
    }
}
