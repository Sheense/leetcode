package com.company.greedyAlgorithm;

public class 完成所有任务的最少初始能量 {
    public int minimumEffort(int[][] tasks) {
        int all = 0;
        for(int i=0;i<tasks.length;i++) {
            all+=tasks[i][0];
        }
        int consume = all;
        sort(0, tasks.length-1, tasks);
        for(int i=0;i<tasks.length;i++) {
            if(tasks[i][1]<=consume) consume -= tasks[i][0];
            else {
                int value = tasks[i][1] - consume;
                all+=value;
                consume+=value;
                consume-=tasks[i][0];
            }
        }
        return all;
    }

    public void sort(int start, int end, int[][] tasks) {
        if(start>=end) return ;
        int left = start;
        int right = end;
        int[] mid = tasks[left];
        while(left<right) {
            while(left<right&&tasks[right][1]<=mid[1]) right--;
            tasks[left] = tasks[right];
            while(left<right&&tasks[left][1]>=mid[1]) left++;
            tasks[right] = tasks[left];
        }
        tasks[left] = mid;
        sort(start, left-1, tasks);
        sort(left+1, end, tasks);
    }
}
