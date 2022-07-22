package sheen.leetcode.queue;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

public class 单线程CPU {
    public static void main(String[] args) {
        单线程CPU s = new 单线程CPU();
        ArrayUtils.print(s.getOrder(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}}));
    }
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];
        List<Task> list = new ArrayList<>();
        for(int i=0;i<tasks.length;i++) {
            list.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(list, (o1, o2) -> o1.timestamp - o2.timestamp);

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
           if(list.get(o1).runTime == list.get(o2).runTime) {
               return list.get(o1).index - list.get(o2).index;
           }
           return  list.get(o1).runTime - list.get(o2).runTime;
        });
        int index = 0;
        int i = 0;
        long stop = 0;
        while (i < tasks.length) {
            if (queue.isEmpty()) {
                stop = list.get(i).timestamp;
                while (i<list.size()&&list.get(i).timestamp == stop) {
                    queue.offer(i++);
                }
            }

            int now = queue.poll();
            res[index++] = list.get(now).index;
            stop += list.get(now).runTime;
            while (i<list.size()&&list.get(i).timestamp<=stop) {
                queue.offer(i++);
            }
        }
        while (!queue.isEmpty()){
            res[index++] = list.get(queue.poll()).index;
        }
        return res;
    }

    private class Task{
        public Task(int index, int timestamp, int runTime) {
            this.index = index;
            this.timestamp = timestamp;
            this.runTime = runTime;
        }
        int index;
        int timestamp;
        int runTime;
    }


    /*public void sort(int start, int end, int[][] tasks, int[] indexs){
        if(start>=end) return;
        int left = start;
        int right = end;
        int[] m = tasks[left];
        int index = indexs[left];
        while (left<right) {
            while (left<right&&tasks[right][0]>=m[0]) right--;
            tasks[left] = tasks[right];
            indexs[left] = indexs[right];
            while (left<right&&tasks[left][0]<=m[0]) left++;
            tasks[right] = tasks[left];
            indexs[right] = indexs[left];
        }
        tasks[left] = m;
        indexs[left] = index;
        sort(start, left-1, tasks, indexs);
        sort(left+1, end, tasks, indexs);
    }*/

}
