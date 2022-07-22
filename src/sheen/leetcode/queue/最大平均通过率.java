package sheen.leetcode.queue;

import java.util.PriorityQueue;

public class 最大平均通过率 {
    public static void main(String[] args) {
        最大平均通过率 s = new 最大平均通过率();
        System.out.println(s.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2)-> {
            double diff1 = diff(classes[o1]);
            double diff2 = diff(classes[o2]);
            if(diff2 - diff1>0) return 1;
            else if(diff2 - diff1<0) return -1;
            else return 0;
        });
        for(int i=0;i<classes.length;i++) {
            queue.add(i);
        }
        for(int i=0;i<extraStudents;i++) {
            int j = queue.poll();
            classes[j][0]++;
            classes[j][1]++;
            queue.offer(j);
        }
        double res = 0;
        while(!queue.isEmpty()){
            int i = queue.poll();
            double num = (double) classes[i][0] / classes[i][1];
            res += num;
        }
        return res/classes.length;
    }

    public double diff(int [] a) {
        return (double)(a[0]+1) / (a[1]+1) -  (double)a[0] / a[1];
    }


}
