package com.company.window;

import java.util.LinkedList;
import java.util.Queue;

public class 统计优美子数组 {

    public static void main(String[] args) {
        统计优美子数组 s = new 统计优美子数组();
        System.out.println(s.numberOfSubarrays(new int[]{1,1,1,1,1},1));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        int pre = 1;
        int last = 1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]%2==0) {
                if(queue.size()==0) {
                    pre++;
                }
                if(k==0) {
                    last++;
                }
            }else {
                if(k==0) {
                    res += pre*last;
                    int index = queue.poll();
                    queue.offer(i);
                    pre = queue.peek() - index;
                    last = 1;
                }else {
                    queue.offer(i);
                    k--;
                }
            }
        }
        if(k==0) res += last*pre;
        return res;
    }
}
