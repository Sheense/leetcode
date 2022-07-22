package sheen.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 距离顺序排列矩阵单元格 {
    public static void main(String[] args) {
        距离顺序排列矩阵单元格 s = new 距离顺序排列矩阵单元格();
        System.out.println(s.allCellsDistOrder(2,2,0,1));
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] map = new int[R][C];
        Queue<int[]> queue = new LinkedList<>();
        int[][] res = new int[R*C][2];
        int index = 0;
        queue.offer(new int[]{r0, c0});
        map[r0][c0] = 1;
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            res[index++] = arr;
            if(arr[1]+1<C&&map[arr[0]][arr[1]+1]==0) {
                queue.offer(new int[]{arr[0],arr[1]+1});
                map[arr[0]][arr[1]+1]=1;
            }
            if(arr[1]-1>=0&&map[arr[0]][arr[1]-1]==0) {
                queue.offer(new int[]{arr[0],arr[1]-1});
                map[arr[0]][arr[1]-1]=1;
            }
            if(arr[0]+1<R&&map[arr[0]+1][arr[1]]==0) {
                queue.offer(new int[]{arr[0]+1, arr[1]});
                map[arr[0]+1][arr[1]]=1;
            }
            if(arr[0]-1>=0&&map[arr[0]-1][arr[1]]==0) {
                queue.offer(new int[]{arr[0]-1,arr[1]});
                map[arr[0]-1][arr[1]]=1;
            }
        }
        return res;
    }
}
