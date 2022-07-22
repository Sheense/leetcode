package sheen.leetcode.window;

import java.util.LinkedList;
import java.util.Queue;
//改变次数的奇偶性
public class K连续位的最小翻转次数 {
    public int minKBitFlips(int[] A, int K) {
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for(int i=0;i<=A.length-K;i++) {
            while(!queue.isEmpty()&&queue.peek()<=i-K) {
                queue.poll();
            }
            if(A[i]==1) {
                if(queue.size()%2 == 1) {
                    res++;
                    queue.offer(i);
                }
            }else{
                if(queue.size()%2 == 0) {
                    res++;
                    queue.offer(i);
                }
            }
        }
        int index = A.length - K + 1;
        while(index<A.length) {
            while(!queue.isEmpty()&&queue.peek()<=index-K) {
                queue.poll();
            }
            if(A[index]==1) {
                if(queue.size()%2 == 1) {
                    return -1;
                }
            }else{
                if(queue.size()%2 == 0) {
                    return -1;
                }
            }
            index++;
        }
        return res;
    }
}
