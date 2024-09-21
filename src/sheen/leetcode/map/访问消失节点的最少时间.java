package sheen.leetcode.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname 访问消失节点的最少时间
 * @Date 2024/7/18 00:52
 * @Created by sheen
 * @Description TODO
 */
public class 访问消失节点的最少时间 {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] list = new List[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }


        for(int[] edge : edges) {
            int a = edge[0], b = edge[1], len = edge[2];
            list[a].add(new int[]{b, len});
            list[b].add(new int[]{a, len});
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int len = p[0];
            int idx = p[1];

            if(len != answer[idx]) {
                continue;
            }

            for(int[] next : list[idx]) {
                int nextP = next[0];
                int nextLen = next[1];
                if(nextLen + len < disappear[nextP] && (answer[nextP] == -1 || nextLen + len < answer[nextP])) {
                    answer[nextP] = nextLen + len;
                    queue.offer(new int[]{nextLen + len, nextP});
                }
            }
        }

        return answer;
    }
}
