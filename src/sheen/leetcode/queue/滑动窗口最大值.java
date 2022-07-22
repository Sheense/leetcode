package sheen.leetcode.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>((o1,o2)->o2[1] - o1[1]);
        int [] res = new int[nums.length-k+1];
        int index = 0;
        for(int i=0;i<nums.length;i++) {
            queue.add(new int[]{i, nums[i]});
            if(queue.size()<k) {
                continue;
            }
            while(!queue.isEmpty()&&queue.peek()[0]<=i-k) {
                queue.poll();
            }
            res[index++] = queue.peek()[1];
        }
        return res;
    }

    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0) return new int[0];
        if(k==1) return nums;
        int [] res = new int[nums.length-k+1];
        if(nums.length==0||k==0) return res;
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for(int j=0;j<k;j++) {
            if(nums[j]>max) {
                max = nums[j];
                max_index = j;
            }
        }
        res[0] = max;
        for(int j=1;j<=nums.length-k;j++) {
            if(max_index!=j-1) {
                max = nums[j+k-1]>=max?nums[j+k-1]:max;
                max_index = nums[j+k-1]>=max?j+k-1:max_index;
            }else {
                max = Integer.MIN_VALUE;
                for(int i=j;i<=j+k-1;i++) {
                    if(nums[i]>max) {
                        max = nums[i];
                        max_index = i;
                    }
                }
            }
            res[j] = max;
        }
        return res;
    }*/
}
