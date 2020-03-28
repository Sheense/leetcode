package com.company.queue;

import com.company.util.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 全排列 {
    public static void main(String[] args) {
        全排列 s = new 全排列();
        ArrayUtils.print(s.permute(new int[]{1,2,3,5,6,7,8,9}));
    }

    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList();
        for(int i=0;i<nums.length;i++) {
           while(queue.peek()==null || queue.peek().size()==i) {
               List<Integer> list = queue.peek()==null?new ArrayList<>():queue.poll();
               for(int j=0;j<=list.size();j++) {
                   List<Integer> item = new ArrayList<>(list);
                   item.add(j, nums[i]);
                   queue.offer(item);
               }
           }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> item : queue) {
            res.add(item);
        }
        return res;
    }
}
