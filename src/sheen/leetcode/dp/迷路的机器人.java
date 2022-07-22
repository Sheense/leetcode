package sheen.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class 迷路的机器人 {
    public static void main(String[] args) {
        迷路的机器人 s = new 迷路的机器人();
        System.out.println(s.pathWithObstacles(new int[][]
                {{0,0,0},{0,1,0},{0,0,0}}));
    }
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        boolean[][] map = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++) {
            for(int j=0;j<obstacleGrid[i].length;j++) {
                if(obstacleGrid[i][j] == 0) {
                    if(i==0&&j==0) {
                        map[i][j] = true;
                    }else if(i==0) {
                        map[i][j] = map[i][j-1];
                    }else if(j==0){
                        map[i][j] = map[i-1][j];
                    }else {
                        map[i][j] = map[i-1][j] || map[i][j-1];
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int x = map.length-1;
        int y = map[0].length - 1;
        if(!map[x][y]) return new ArrayList<>();
        res.add(List.of(x,y));
        while (x !=0 || y !=0) {
            if(x-1>=0&&map[x-1][y]) {
                res.add(List.of(x-1,y));
                x--;
                continue;
            }
            if(y-1>=0&&map[x][y-1]) {
                res.add(List.of(x, y-1));
                y--;
                continue;
            }
            return new ArrayList<>();
        }
        for(int i=0;i<res.size()/2;i++) {
            List<Integer> item = res.get(i);
            res.set(i, res.get(res.size()-1-i));
            res.set(res.size()-1-i, item);
        }
        return res;
    }
}
