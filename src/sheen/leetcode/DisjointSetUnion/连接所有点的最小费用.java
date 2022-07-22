package sheen.leetcode.DisjointSetUnion;

import java.util.PriorityQueue;
import java.util.Queue;

public class 连接所有点的最小费用 {
    public static void main(String[] args) {
        连接所有点的最小费用 s = new 连接所有点的最小费用();
        System.out.println(s.minCostConnectPoints(new int[][]{{2,-3},{-17,-8},{13,8},{-17,-15}}));
    }
    public int minCostConnectPoints(int[][] points) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2)->{
            int o1Len = Math.abs(points[o1[0]][0]-points[o1[1]][0]) + Math.abs(points[o1[0]][1]-points[o1[1]][1]);
            int o2Len = Math.abs(points[o2[0]][0]-points[o2[1]][0]) + Math.abs(points[o2[0]][1]-points[o2[1]][1]);
            return o1Len - o2Len;
        });

        int [] union = new int [points.length];
        int [] mapNum = new int[points.length];
        for(int i=0;i<union.length;i++) {
            union[i] = i;
            mapNum[i] = 1;
        }
        for(int i=0;i<points.length-1;i++) {
            for(int j=i+1;j<points.length;j++) {
                queue.add(new int[]{i,j});
            }
        }


        int res = 0;
        while(!queue.isEmpty()) {
            int [] v = queue.poll();
            int i = v[0];
            int j = v[1];
            int r1 = findRoot(union, i);
            int r2 = findRoot(union, j);
            if(r1 != r2) {
                union[r1] = r2;
                res += Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]- points[j][1]);
                mapNum[r2] += mapNum[r1];
                if(mapNum[r2]==points.length) break;
            }
        }
        return res;
    }

    public int findRoot(int[] set, int i) {
        while(i!=set[i]) {
            i = set[i];
        }
        return i;
    }
}
