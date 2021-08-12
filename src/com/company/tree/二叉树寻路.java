package com.company.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 二叉树寻路
 * @Date 2021/7/29 12:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树寻路 {
    public static void main(String[] args) {
        二叉树寻路 s = new 二叉树寻路();
        System.out.println(s.pathInZigZagTree(14));
    }
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        if(label == 1) {
            res.add(1);
            return res;
        }
        int floor = 1;
        while (label > Math.pow(2, floor) - 1) {
            floor++;
        }

        int num = label;//虚
        if(floor % 2 == 0) {
            int pos = label - (int)Math.pow(2, floor -1);
            num = (int)(Math.pow(2, floor) -1) - label + 1 + (int)(Math.pow(2, floor - 1) -1);
        }
        while (floor >= 1) {
            if(floor % 2 != 0) {
                res.add(num);
            }else {
               int item = (int)(Math.pow(2, floor) - 1) - (num - (int)(Math.pow(2, floor -1) - 1)) + 1;
               res.add(item);
            }
            num /= 2;
            floor--;
        }
        Collections.reverse(res);
        return res;
    }
}
