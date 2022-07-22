package sheen.leetcode.DisjointSetUnion;

import java.util.PriorityQueue;
import java.util.Queue;

public class 水位上升的泳池中游泳 {
    public static void main(String[] args) {
        水位上升的泳池中游泳 s= new 水位上升的泳池中游泳();
        System.out.println(s.swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));
    }
    public int swimInWater(int[][] grid) {
        UnionFind unionFind = new UnionFind(grid);
        Queue<int[]> queue = new PriorityQueue<>((o1, o2)->o1[0] - o2[0]);
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                queue.add(new int[]{grid[i][j], i, j});

            }
        }
        int len = grid[0].length;
        int threshold = 0;
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int row = arr[1];
            int col = arr[2];
            if(threshold<arr[0]) {
                threshold = arr[0];
            }
            if(row-1>=0&&grid[row-1][col]<=arr[0]&&unionFind.union(row*len+col, (row-1)*len+col)) {
                return threshold;
            }
            if(row+1<grid.length&&grid[row+1][col]<=arr[0]&&unionFind.union(row*len+col, (row+1)*len+col)) {
                return threshold;
            }
            if(col-1>=0&&grid[row][col-1]<=arr[0]&&unionFind.union(row*len+col, row*len+col-1)) {
                return threshold;
            }
            if(col+1<len&&grid[row][col+1]<=arr[0]&&unionFind.union(row*len+col, row*len+col+1)) {
                return threshold;
            }
        }
        return threshold;
    }

    public class UnionFind{
        int[] parents;
        public UnionFind(int[][] grid) {
            int size = grid.length * grid[0].length;
            parents = new int[size];
            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[0].length;j++) {
                    int index = i*grid[0].length+j;
                    parents[index] = index;
                }
            }
        }

        private int findRoot(int i) {
            while (i!=parents[i]) i = parents[i];
            return i;
        }

        public boolean union(int i, int j) {
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            if(r1 == r2) return false;
            updateRoot(r2, i);
            return findRoot(0) == findRoot(parents.length-1);
        }

        private void updateRoot(int root, int i) {
            while(i!=parents[i]) {
                int next = parents[i];
                parents[i] = root;
                i = next;
            }
            parents[i] = root;
        }


    }
}
