package com.company.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname 推多米诺
 * @Date 2022/2/21 12:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 推多米诺 {
    public static void main(String[] args) {
        推多米诺 s = new 推多米诺();
        System.out.println(s.pushDominoes(".L.R."));
    }
    public String pushDominoes(String dominoes) {
        int L = 0;
        int R = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        char[] cs = dominoes.toCharArray();
        for(int i = 0; i < dominoes.length(); i++) {
            if(cs[i] == 'L' && i - 1 >= 0 && cs[i - 1] == '.') {
                queue.offer(new int[]{ i - 1, L});
            }else if(cs[i] == 'R' && i + 1 < dominoes.length() && cs[i+1] == '.'){
                queue.offer(new int[]{i + 1, R});
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<int[]> list = new ArrayList<>();
            while (size > 0) {
                int[] arr = queue.poll();
                size --;
                if(size > 0 && queue.peek()[0] == arr[0]) {
                    queue.poll();
                    size--;
                }else {
                    if(arr[1] == L) {
                        cs[arr[0]] = 'L';
                        if(arr[0] - 1 >= 0 && cs[arr[0] - 1] == '.') {
                            list.add(new int[]{arr[0] - 1, L});
                        }
                    }
                    if(arr[1] == R) {
                        cs[arr[0]] = 'R';
                        if(arr[0] + 1 < cs.length && cs[arr[0] + 1] == '.') {
                            list.add(new int[]{arr[0] + 1, R});
                        }
                    }
                }
            }
            for(int[] arr : list) {
                if(cs[arr[0]] == '.') {
                    queue.offer(arr);
                }
            }
        }
        return String.valueOf(cs);
    }
}
