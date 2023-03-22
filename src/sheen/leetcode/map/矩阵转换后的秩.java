package sheen.leetcode.map;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 矩阵转换后的秩
 * @Date 2023/1/25 5:28 下午
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵转换后的秩 {
    public static void main(String[] args) {
        矩阵转换后的秩 s = new 矩阵转换后的秩();
        //ArrayUtils.print2(s.matrixRankTransform(new int[][]{{1, 2}, {3, 4}}));
        //ArrayUtils.print2(s.matrixRankTransform(new int[][]{{7, 7}, {7, 7}}));
        ArrayUtils.print2(s.matrixRankTransform(new int[][]{{20,-21,14}, {-19,4,19}, {22,-47,24}, {-19,4,19}}));
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        UnionSet unionSet = new UnionSet(m * n);
        for(int i = 0; i < matrix.length; i++) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int j = 0; j < matrix[0].length; j++) {
                map.computeIfAbsent(matrix[i][j], x -> new ArrayList<>()).add(transferOut(new int[]{i, j}, n));
            }

            for(List<Integer> item : map.values()) {
                for(int k = 1; k < item.size(); k++) {
                    unionSet.union(item.get(k), item.get(k - 1));
                }
            }
        }

        for(int i = 0; i < n; i++) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int j = 0; j < m; j++) {
                map.computeIfAbsent(matrix[j][i], x -> new ArrayList<>()).add(transferOut(new int[]{j, i}, n));
            }

            for(List<Integer> item : map.values()) {
                for(int k = 1; k < item.size(); k++) {
                    unionSet.union(item.get(k), item.get(k - 1));
                }
            }
        }

        List<Integer> roots = unionSet.getRoots();

        Map<Integer, Integer> rootToIndex = new HashMap<>();
        for(int i = 0; i < roots.size(); i++) {
            rootToIndex.put(roots.get(i), i);
        }

        Map<Integer, Set<Integer>> toDegree = new HashMap<>();
        Map<Integer, Integer> onDegree = new HashMap<>();
        for(int root : roots) {
            toDegree.computeIfAbsent(root, x -> new HashSet<>());
            onDegree.put(root, 0);
        }

        for(int i = 0; i < m; i++) {
            List<int[]> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(!set.contains(matrix[i][j])) {
                    list.add(new int[]{matrix[i][j], transferOut(new int[]{i, j}, n)});
                    set.add(matrix[i][j]);
                }
            }

            Collections.sort(list, (x, y) -> x[0] - y[0]);
            for(int k = 1; k < list.size(); k++) {
                int pre = unionSet.find(list.get(k - 1)[1]);
                int cur = unionSet.find(list.get(k)[1]);
                if(!toDegree.get(pre).contains(cur)) {
                    onDegree.put(cur, onDegree.get(cur) + 1);
                }
                toDegree.get(pre).add(cur);
            }
        }

        for(int i = 0; i < n; i++) {
            List<int[]> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < m; j++) {
                if(!set.contains(matrix[j][i])) {
                    list.add(new int[]{matrix[j][i], transferOut(new int[]{j, i}, n)});
                    set.add(matrix[j][i]);
                }
            }

            Collections.sort(list, (x, y) -> x[0] - y[0]);
            for(int k = 1; k < list.size(); k++) {
                int pre = unionSet.find(list.get(k - 1)[1]);
                int cur = unionSet.find(list.get(k)[1]);
                if(!toDegree.get(pre).contains(cur)) {
                    onDegree.put(cur, onDegree.get(cur) + 1);
                }
                toDegree.get(pre).add(cur);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int key : onDegree.keySet()) {
            if(onDegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        Map<Integer, Integer> res = new HashMap<>();
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int point = queue.poll();
                res.put(point, index);
                for(int next : toDegree.get(point)) {
                    onDegree.put(next, onDegree.get(next) - 1);
                    if(onDegree.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
            index++;
        }

        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = res.get(unionSet.find(transferOut(new int[]{i, j}, n)));
            }
        }

        return ans;
    }

    public int[] transferIn(int v, int n) {
       return new int[]{v / n, v % n};
    }

    public int transferOut(int[] arr, int n) {
        return n * arr[0] + arr[1];
    }

    public static class UnionSet{
        private int[] pre;
        private int[] size;
        public UnionSet(int len) {
            pre = new int[len];
            size = new int[len];
            for(int i = 0; i < len; i++) {
                pre[i] = i;
                size[i] = 1;
            }
        }

        public int find(int point) {
            while (pre[point] != point) {
                point = pre[point];
            }

            return point;
        }

        public void union(int v1, int v2) {
            int r1 = find(v1);
            int r2 = find(v2);
            if(r1 == r2) {
                return;
            }

            if(size[r1] >= size[r2]) {
                size[r1] += size[r2];
                pre[r2] = r1;
            }else {
                size[r2] += size[r1];
                pre[r1] = r2;
            }
        }

        public List<Integer> getRoots() {
            List<Integer> roots = new ArrayList<>();
            for(int i = 0; i < pre.length; i++) {
                if(pre[i] == i) {
                    roots.add(i);
                }
            }

            return roots;
        }
    }
}
