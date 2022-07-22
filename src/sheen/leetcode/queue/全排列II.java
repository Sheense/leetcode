package sheen.leetcode.queue;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

public class 全排列II {
    public static void main(String[] args) {
        全排列II s = new 全排列II();
        ArrayUtils.print2(s.permuteUnique(new int[]{1,1,2,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
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
            //去重操作，other存放无重复数据
            List<List<Integer>> other = new ArrayList<>();
            for(List<Integer> list : queue) {
                boolean flag = false;
                for(int j=0;j<other.size();j++) {
                    List<Integer> item = other.get(j);
                    for(int z=0;z<item.size();z++) {
                        if(item.get(z)!=list.get(z)) break;
                        if(z==item.size()-1) flag=true;
                    }
                    if(flag) break;
                }
                if(!flag) other.add(list);
            }
            queue = new LinkedList<>(other);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> item : queue) {
            res.add(item);
        }
        return res;
    }
}
