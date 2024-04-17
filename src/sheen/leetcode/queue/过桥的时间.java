package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 过桥的时间
 * @Date 2023/7/7 8:44 下午
 * @Created by sheen
 * @Description TODO
 */
public class 过桥的时间 {
    public static void main(String[] args) {
        过桥的时间 s = new 过桥的时间();
        System.out.println(s.findCrossingTime(3, 2, new int[][]{{1,9,1,8},{10,10,10,10}}));
    }

    public int findCrossingTime(int n, int k, int[][] time) {
        int now = 0;
        PriorityQueue<Integer> right = new PriorityQueue<>((x, y) -> {
            int v1 = time[x][0] + time[x][2];
            int v2 = time[y][0] + time[y][2];
            if(v1 == v2) {
                if(x > y){
                    return -1;
                }else {
                    return 1;
                }
            }
            if(v1 > v2) {
                return -1;
            }else {
                return 1;
            }
        });
        PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> {
            int v1 = time[x][0] + time[x][2];
            int v2 = time[y][0] + time[y][2];
            if(v1 == v2) {
                if(x > y){
                    return -1;
                }else {
                    return 1;
                }
            }
            if(v1 > v2) {
                return -1;
            }else {
                return 1;
            }
        });
        PriorityQueue<int[]> rightWait = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        PriorityQueue<int[]> leftWait = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for(int i = 0; i < time.length; i++) {
            left.offer(i);
        }
        int res = 0;

        while (n > 0 || !right.isEmpty() || !rightWait.isEmpty()) {

            while (!rightWait.isEmpty() && now >= rightWait.peek()[1]) {
                right.offer(rightWait.poll()[0]);
            }
            while (!leftWait.isEmpty() && leftWait.peek()[1] <= now) {
                left.offer(leftWait.poll()[0]);
            }
            if(right.isEmpty()) {
                if(n > 0 && !left.isEmpty()) {
                    int go = left.poll();
                    now += time[go][0];
                    n--;
                    rightWait.offer(new int[]{go, time[go][1] + now});
                }else {
                    if(rightWait.isEmpty()) {
                        now = leftWait.peek()[1];
                        while (!leftWait.isEmpty() && leftWait.peek()[1] == now) {
                            left.offer(leftWait.poll()[0]);
                        }
                    }else if(leftWait.isEmpty()) {
                        now = rightWait.peek()[1];
                        while (!rightWait.isEmpty() && rightWait.peek()[1] == now) {
                            right.offer(rightWait.poll()[0]);
                        }
                    }else {
                        now = Math.min(leftWait.peek()[1], rightWait.peek()[1]);
                        while (!rightWait.isEmpty() && rightWait.peek()[1] == now) {
                            right.offer(rightWait.poll()[0]);
                        }
                        while (!leftWait.isEmpty() && leftWait.peek()[1] == now) {
                            left.offer(leftWait.poll()[0]);
                        }
                    }
                }
            }else {
                int go = right.poll();
                now += time[go][2];
                if(right.isEmpty() && rightWait.isEmpty() && n == 0) {
                    res = now;
                }
                leftWait.offer(new int[]{go, now + time[go][3]});
            }
        }
        return res;
    }
}
