package sheen.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname 推箱子
 * @Date 2023/5/8 10:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 推箱子 {
    public static void main(String[] args) {
        推箱子 s = new 推箱子();
        System.out.println(s.minPushBox(new char[][]{
                {'#','#','#','#','#','#'},
                {'#','T','#','#','#','#'},
                {'#','.','.','B','.','#'},
                {'#','.','#','#','.','#'},
                {'#','.','.','.','S','#'},
                {'#','#','#','#','#','#'}}));
    }
    private int[][] mat = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;
    private int m;
    private int n;
    public int minPushBox(char[][] grid) {
        int[] people = null;
        int[] target = null;
        int[] box = null;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                switch (grid[i][j]) {
                    case 'T' : {
                        target = new int[]{i, j};
                        break;
                    }
                    case 'S' : {
                        people = new int[]{i, j};
                        break;
                    }
                    case 'B' : {
                        box = new int[]{i, j};
                        break;
                    }
                }
            }
        }
        return bfs(grid, people, box, target);
    }

    public int bfs(char[][] grid, int[] people, int[] box, int[] target) {
        this.m = grid.length;
        this.n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        processNext(grid, box, people, queue, set);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int[] point = queue.poll();
                if(point[1] == target[0] && point[2] == target[1]) {
                    return res;
                }
                switch (point[0]) {
                    case LEFT:{
                        int nextX = point[1];
                        int nextY = point[2] + 1;
                        if(nextY < n && grid[nextX][nextY] != '#') {
                            processNext(grid, new int[]{nextX, nextY}, new int[]{point[1], point[2]}, queue, set);
                        }
                        break;
                    }
                    case RIGHT:{
                        int nextX = point[1];
                        int nextY = point[2] - 1;
                        if(nextY >= 0 && grid[nextX][nextY] != '#') {
                            processNext(grid, new int[]{nextX, nextY}, new int[]{point[1], point[2]}, queue, set);
                        }
                        break;
                    }
                    case UP:{
                        int nextX = point[1] + 1;
                        int nextY = point[2];
                        if(nextX < m && grid[nextX][nextY] != '#') {
                            processNext(grid, new int[]{nextX, nextY}, new int[]{point[1], point[2]}, queue, set);
                        }
                        break;
                    }
                    case DOWN:{
                        int nextX = point[1] - 1;
                        int nextY = point[2];
                        if(nextX >= 0 && grid[nextX][nextY] != '#') {
                            processNext(grid, new int[]{nextX, nextY}, new int[]{point[1], point[2]}, queue, set);
                        }
                        break;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    //人站的位置和箱子位置去除重复操作
    public String getKey(int[] point, int n) {
        return point[0] + "#" + (point[1] * n + point[2]);
    }

    public void processNext(char[][] grid, int[] box, int[] start, Queue<int[]> queue, Set<String> set) {
        for(int i = 0; i < mat.length; i++) {
            int[] free = new int[]{mat[i][0] + box[0], mat[i][1] + box[1]};
            if(free[0] >= 0 && free[0] < m && free[1] >= 0 && free[1] < n
                    && grid[free[0]][free[1]] != '#' && canArrive(grid, start, free, box, new HashSet<>())) {
                int direction = getDirection(box, free);
                int[] point = new int[]{direction, box[0], box[1]};
                String key = getKey(point, n);
                if(!set.contains(key)) {
                    queue.offer(point);
                    set.add(key);
                }
            }
        }
    }

    //判读下一次可以推的方向
    public int getDirection(int[] box, int[] free) {
        if(box[0] == free[0]) {
            if(box[1] > free[1]) {
                return LEFT;
            }else {
                return RIGHT;
            }
        }else if(box[0] < free[0]) {
            return DOWN;
        }else {
            return UP;
        }
    }

    //在当前box位置下，start位置是否能到达end
    public boolean canArrive(char[][] grid, int[] start, int[] end, int[] box, Set<Integer> set) {
        if(start[0] == end[0] && start[1] == end[1]) {
            return true;
        }

        set.add(start[0] * n + start[1]);
        for(int i = 0; i < mat.length; i++) {
            int nextX = start[0] + mat[i][0];
            int nextY = start[1] + mat[i][1];
            int nextV = nextX * n + nextY;
            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] != '#' && !set.contains(nextV)) {
                if(nextX != box[0] || nextY != box[1]) {
                    boolean res = canArrive(grid, new int[]{nextX, nextY}, end, box, set);
                    if(res) {
                        return res;
                    }
                }
            }
        }
        return false;
    }
}
