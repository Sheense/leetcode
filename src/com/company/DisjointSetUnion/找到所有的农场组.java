package com.company.DisjointSetUnion;

import com.company.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 找到所有的农场组
 * @Date 2021/9/4 10:39 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找到所有的农场组 {
    public static void main(String[] args) {
        找到所有的农场组 s = new 找到所有的农场组();
        ArrayUtils.print2(s.findFarmland(new int[][]{{1,0,0},{0,1,1},{0,1,1}}));
    }
    public int[][] findFarmland(int[][] land) {
        UnionSet set = new UnionSet(land);
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                if(land[i][j] == 1) {
                    if(i-1 >= 0 && land[i-1][j] == 1) {
                        set.union((i-1)*land[0].length+j , i*land[0].length +j);
                    }else if(j - 1 >= 0 && land[i][j-1] == 1) {
                        set.union(i*land[0].length+j , i*land[0].length +j - 1);
                    }
                }
            }
        }
        return set.getRes();
    }

    public class UnionSet{
        private int[] arr;
        private int[] min;
        private int [] max;
        private int row;
        private int column;
        private int[][] map;
        public UnionSet(int[][] map) {
            this.row = map.length;
            this.column = map[0].length;
            int len = this.row * this.column;
            this.map = map;
            arr = new int[len];
            min = new int[len];
            max = new int[len];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = i;
                min[i] = i;
                max[i] = i;
            }
        }

        public void union(int i, int j) {
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            max[r1] = Math.max(max[r1], max[r2]);
            min[r1] = Math.min(min[r1], min[r2]);
            setRoot(j, r1);
        }

        public void setRoot(int i, int r) {
            while (i != arr[i]) {
                int item = arr[i];
                arr[i] = r;
                i = item;
            }
            arr[i] = r;
        }

        public int findRoot(int i) {
            while (i != arr[i]) {
                i = arr[i];
            }
            return i;
        }

        public int[][] getRes() {
            List<Integer> indexs = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                if(i == arr[i] && map[i/row][i%row] == 1) {
                    indexs.add(i);
                }
            }
            int[][] res = new int[indexs.size()][4];
            for(int i = 0; i < indexs.size(); i++) {
                int max = this.max[indexs.get(i)];
                int min = this.min[indexs.get(i)];
                res[i] = new int[]{min/column, min%column, max/column, max%column};
            }
            return res;
        }
    }
}
