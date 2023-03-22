package sheen.leetcode.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 从仓库到码头运输箱子
 * @Date 2022/12/5 12:41 上午
 * @Created by sheen
 * @Description TODO
 */
public class 从仓库到码头运输箱子 {
    public static void main(String[] args) {
        从仓库到码头运输箱子 s = new 从仓库到码头运输箱子();
        System.out.println(s.boxDelivering(new int[][]{{1,1},{2,1},{1,1}},2, 3, 3));
    }
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] f = new int[n + 1];
        int[] w = new int[n + 1];
        int[] g = new int[n + 1];
        int[] neg = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int port = boxes[i - 1][0];
            int weight = boxes[i - 1][1];
            w[i] = w[i - 1] + weight;
            if(i > 1) {
                neg[i] = neg[i - 1] + (port == boxes[i - 2][0] ? 0 : 1);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerFirst(0);
        for(int i = 1; i <= n; i++) {
            while (i - queue.peekFirst() > maxBoxes || w[i] - w[queue.peekFirst()] > maxWeight) {
                queue.pollFirst();
            }

            f[i] = g[queue.peekFirst()] + neg[i] + 2;
            if(i != n) {
                g[i] = f[i] - neg[i + 1];
                while (!queue.isEmpty() && g[i] <= g[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offerLast(i);
            }
        }

        return f[n];
    }
}
