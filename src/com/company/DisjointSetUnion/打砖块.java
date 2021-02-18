package com.company.DisjointSetUnion;

import com.company.util.ArrayUtils;

public class 打砖块 {

    public static void main(String[] args) {
        打砖块 s = new 打砖块();
        ArrayUtils.print(s.hitBricks(new int[][]{{1,0,0,0},{1,1,1,0}}, new int[][]{{1,0}}));
    }
    private static int [][] DIRECTION = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[][] copy = new int[grid.length][grid[0].length];
        int size = grid.length * grid[0].length;
        int colLength = grid[0].length;
        UnionFind unionFind = new UnionFind(size+1);

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                copy[i][j] = grid[i][j];
            }
        }
        for(int i=0;i<hits.length;i++) {
            copy[hits[i][0]][hits[i][1]] = 0;
        }

        for(int i=0;i<grid[0].length;i++) {
            if(copy[0][i]==1) {
                unionFind.union(i, size);
            }
        }

        for(int i=1;i<copy.length;i++) {
            for(int j=0;j<copy[0].length;j++) {
                if(copy[i][j]==1) {
                    if(copy[i-1][j]==1) {
                        unionFind.union((i-1)*colLength+j, i*colLength+j);
                    }
                    if(j-1>=0&&copy[i][j-1]==1) {
                        unionFind.union(i*colLength+j-1, i*colLength+j);
                    }
                }
            }
        }

        int res[] = new int[hits.length];
        for(int i=hits.length-1;i>=0;i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y]==0) {
                continue;
            }
            int origin = unionFind.getSize(size);
            int index = x*colLength+y;
            if(x ==0) {
                unionFind.union(y, size);
            }
            for(int[] dir:DIRECTION) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(isArea(grid, newX, newY)&&copy[newX][newY]==1) {
                    int newIndex = newX*colLength+newY;
                    unionFind.union(index, newIndex);
                }
            }
            int current = unionFind.getSize(size);
            res[i] = Math.max(0, current-origin-1);

            copy[x][y] = 1;
        }
        return res;
    }

    public boolean isArea(int [][] grid, int i, int j) {
        if((i>=0&&i<grid.length)&&(j>=0&&j<grid[0].length)) return true;
        return false;
    }


    public class UnionFind{
        private int [] parent;
        private int [] num;
        public UnionFind(int size) {
            parent = new int[size];
            num = new int[size];
            for(int i=0;i<size;i++) {
                parent[i] = i;
                num[i] = 1;
            }
        }

        public int findRoot(int i) {
            while(i!=parent[i]) {
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            if(r1 == r2) return;
            parent[r1] = r2;
            num[r2] += num[r1];
        }

        public int getSize(int i) {
            int root = findRoot(i);
            return num[root];
        }

    }
}
