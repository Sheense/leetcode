package com.company.bfs;

import java.util.*;

public class 蛇梯棋 {
    public static void main(String[] args) {
        蛇梯棋 s = new 蛇梯棋();
        s.snakesAndLadders(new int[][] {{1,1,-1},{1,1,1},{-1,1,1}});
    }
    public int snakesAndLadders(int[][] board) {
        Set<Integer> set = new HashSet<>();
        int index = 1;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = board.length - 1; i>=0; i--) {
            int diff = board.length - 1 - i;
            if(diff % 2 == 0) {
                for(int j = 0; j < board[i].length; j++) {
                    map.put(index++, new int[]{i, j});
                }
            }else {
                for(int j = board[i].length - 1; j>=0;j--) {
                    map.put(index++, new int[]{i, j});
                }
            }
        }
        int target = board.length * board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int num = queue.poll();
                if(num == target) return res;
                if(set.contains(num)) continue;
                set.add(num);
                for(int i = 1; i <= 6 && i+num <= target; i++) {
                    int next = num + i;
                    int[] point = map.get(next);
                    if(board[point[0]][point[1]] == -1) {
                        queue.add(next);
                    } else {
                        queue.add(board[point[0]][point[1]]);
                    }
                }
            }
            res ++;
        }
        return -1;
    }
}
