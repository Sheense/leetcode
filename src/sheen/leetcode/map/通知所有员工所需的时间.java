package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 通知所有员工所需的时间
 * @Date 2023/5/1 12:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 通知所有员工所需的时间 {
    public static void main(String[] args) {
        通知所有员工所需的时间 s = new 通知所有员工所需的时间();
        System.out.println(s.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < manager.length; i++) {
            if(i == headID) {
                continue;
            }
            map.computeIfAbsent(manager[i], x -> new ArrayList<>()).add(i);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int[] arr = queue.poll();
                List<Integer> list = map.get(arr[0]);
                if(list == null) {
                    res = Math.max(res, arr[1]);
                }else {
                    for(int next : list) {
                        queue.offer(new int[]{next, informTime[arr[0]] + arr[1]});
                    }
                }
            }
        }

        return res;
    }


}
