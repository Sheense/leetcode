package com.company.greedyAlgorithm;

public class 任务调度器 {

    public static void main(String[] args) {
        任务调度器 s = new 任务调度器();

        System.out.println(s.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));

        System.out.println(s.leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
    public int leastInterval(char[] tasks, int n) {
        int [] w = new int[26];
        for(int i=0;i<w.length;i++) {
            w[i] = i;
        }
        int[] arr = new int[26];
        for(int i=0;i<tasks.length;i++) {
            arr[tasks[i]-'A']++;
        }
        int res = 0;
        int flag = 0;
        sort(0,25,w,arr);
        while(arr[0]>0) {
            int i = 0;
            int item = 1;
            while(arr[i]!=0&&item<=n+1) {
                arr[i]--;
                i++;
                item++;
            }
            flag = item-1;
            res += n+1;
            sort(0,25,w,arr);
        }
        return res-(n+1-flag);
    }

    public void sort(int start, int end, int[]w,int[] arr) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int key = arr[left];
        int wei = w[left];
        while(left<right) {
            while(left<right&&key>=arr[right]) right--;
            arr[left] = arr[right];
            w[left] = w[right];
            while(left<right&&key<=arr[left]) left++;
            arr[right] = arr[left];
            w[right] = w[left];
        }
        arr[left] = key;
        w[left] = wei;
        sort(start,left-1,w,arr);
        sort(left+1,end,w,arr);
    }
}
