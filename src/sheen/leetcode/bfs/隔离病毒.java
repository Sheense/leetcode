package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname 隔离病毒
 * @Date 2022/7/18 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 隔离病毒 {
    public int containVirus(int[][] isInfected) {
        int ans = 0;
        int row = isInfected.length;
        int col = isInfected[0].length;
        int[][] dic = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0 , 1}};
        while (true) {
            List<Set<Integer>> list = new ArrayList<>();
            List<Integer> resList = new ArrayList<>();
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(isInfected[i][j] == 1) {
                        Queue<Integer> queue = new LinkedList<>();
                        queue.offer(toOne(i , j, col));
                        Set<Integer> zeroSet = new HashSet<>();
                        int res = 0;
                        int idx = list.size() + 1;
                        isInfected[i][j] = -idx;
                        while (!queue.isEmpty()) {
                            int v = queue.poll();
                            int[] arr = toTwo(v, col);
                            for(int z = 0; z < dic.length; z++) {
                                int nextX = dic[z][0] + arr[0];
                                int nextY = dic[z][1] + arr[1];
                                if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                                    if(isInfected[nextX][nextY] == 0) {
                                        zeroSet.add(toOne(nextX, nextY, col));
                                        res ++;
                                    }else if(isInfected[nextX][nextY] == 1) {
                                        queue.offer(toOne(nextX, nextY, col));
                                        isInfected[nextX][nextY] = -idx;
                                    }
                                }
                            }
                            isInfected[arr[0]][arr[1]] = -idx;
                        }
                        list.add(zeroSet);
                        resList.add(res);
                    }
                }
            }
            if(list.size() == 0) {
                break;
            }

            int resIndex = 0;
            int maxSize = 0;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).size() > maxSize) {
                    resIndex = i;
                    maxSize = list.get(i).size();
                }
            }
            ans += resList.get(resIndex);

            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(isInfected[i][j] < 0) {
                        if(isInfected[i][j] != -(resIndex + 1)) {
                            isInfected[i][j] = 1;
                        }else {
                            isInfected[i][j] = 2;
                        }
                    }
                }
            }

            if(list.size() == 1) {
                break;
            }

            for(int i = 0; i < list.size(); i++) {
                if(i != resIndex) {
                    for(int val : list.get(i)) {
                        int[] arr = toTwo(val, col);
                        isInfected[arr[0]][arr[1]] = 1;
                    }
                }
            }

        }

        return ans;
    }

    public int toOne(int x, int y, int n) {
        return x * n + y;
    }

    public int[] toTwo(int v, int n) {
        return new int[]{v / n, v % n};
    }
}
