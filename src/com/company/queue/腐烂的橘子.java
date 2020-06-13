package com.company.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {

    public static void main(String[] args) {
        腐烂的橘子 s = new 腐烂的橘子();
        System.out.println(s.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]==2) {
                    queue.offer(i*grid[i].length+j);
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int res = 0;
        int s = 0;
        while(!queue.isEmpty()&&s<fresh) {
            int size = queue.size();
            res ++;
            for(int i=0;i<size;i++){
                int item = queue.poll();
                int x = item/grid[0].length;
                int y = item % grid[0].length;
                if(x-1>=0&&grid[x-1][y]==1) {
                    s++;
                    grid[x-1][y]=2;
                    queue.offer((x-1)*grid[0].length+y);
                }
                if(y-1>=0&&grid[x][y-1]==1) {
                    s++;
                    grid[x][y-1]=2;
                    queue.offer(x*grid[0].length+y-1);
                }
                if(x+1<grid.length&&grid[x+1][y]==1) {
                    s++;
                    grid[x+1][y]=2;
                    queue.offer((x+1)*grid[0].length+y);
                }
                if(y+1<grid[0].length&&grid[x][y+1]==1) {
                    s++;
                    grid[x][y+1]=2;
                    queue.offer(x*grid[0].length+y+1);
                }
            }
        }
        if(s==fresh) return res;
        return -1;
    }
}
