package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 两数之和IV_输入BST
 * @Date 2022/3/21 12:55 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两数之和IV_输入BST {
    public boolean findTarget(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        recall(root, list);
        for(int i = 0; i < list.size(); i++) {
            int f = k - list.get(i).val;
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if(list.get(mid).val == f) {
                    if(mid == i) {
                        int j = mid - 1;
                        int z = mid + 1;
                        if(j >= 0 && list.get(j).val == f) {
                            return true;
                        }
                        if(z < list.size() && list.get(z).val == f) {
                            return true;
                        }
                        break;
                    }else {
                        return true;
                    }
                }else if(list.get(mid).val > f) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public void recall(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return;
        }

        recall(root.left, list);
        list.add(root);
        recall(root.right, list);
    }
}
