package sheen.leetcode.queue;

import java.util.*;

public class 分割数组为连续子序列 {
    public static void main(String[] args) {
        分割数组为连续子序列 s = new 分割数组为连续子序列();

        s.isPossible(new int[]{1,2,3,3,4,5});
    }
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i]-1)&&map.get(nums[i]-1).size()>0)  {
                int time = map.get(nums[i]-1).poll();
                PriorityQueue<Integer> p = map.computeIfAbsent(nums[i], x -> new PriorityQueue<>());
                p.add(time+1);
            } else {
                map.computeIfAbsent(nums[i], x-> new PriorityQueue<>()).add(1);
            }
        }
        for(PriorityQueue<Integer> p: map.values()) {
            if(p.size()>0) {
                for(int time:p) {
                    if(time<3) return false;
                }
            }
        }
        return true;
    }
}
