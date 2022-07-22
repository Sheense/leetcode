package sheen.leetcode.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class 吃苹果的最大数目 {
    public static void main(String[] args) {
        吃苹果的最大数目 s = new 吃苹果的最大数目();
        System.out.println(s.eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
    }
    public int eatenApples(int[] apples, int[] days) {
        Queue<int[]> queue  = new PriorityQueue<>((i1,i2)-> {
            return i1[0] - i2[0];
        });
        int res = 0;
        for(int i=0;i<apples.length||!queue.isEmpty();i++) {
            while(!queue.isEmpty()) {
                int[] arr = queue.peek();
                if(arr[0]<=i) {
                    queue.poll();
                }else {
                    break;
                }
            }
            if(i<apples.length&&apples[i]>0) {
                queue.add(new int[]{days[i]+i,apples[i]});
            }
            if(!queue.isEmpty()) {
                int[] arr = queue.peek();
                arr[1]--;
                res++;
                if(arr[1]==0) {
                    queue.poll();
                }
            }

        }
        return res;
    }
}
