package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 重建序列
 * @Date 2022/7/23 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重建序列 {
    public static void main(String[] args) {
        重建序列 s = new 重建序列();
        System.out.println(s.sequenceReconstruction(new int[]{1}, new int[][]{{1}}));
    }
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] du = new int[nums.length + 1];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < sequences.length; i++) {
            if(sequences[i].length == 1) {
                set.add(sequences[i][0]);
                continue;
            }
            for(int j = 0; j < sequences[i].length - 1; j++) {
                map.computeIfAbsent(sequences[i][j], x -> new ArrayList<>()).add(sequences[i][j + 1]);
                du[sequences[i][j + 1]] ++;
                set.add(sequences[i][j]);
                set.add(sequences[i][j + 1]);
            }
        }

        if(set.size() != nums.length) {
            return false;
        }
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for(int i = 1; i <= nums.length; i++) {
            if(du[i] == 0) {
                queue1.offer(i);
            }
            queue2.offer(nums[i - 1]);
        }

        while (!queue1.isEmpty()) {
            int size = queue1.size();
            Set<Integer> s = new HashSet<>();
            while (size != 0) {
                int v = queue1.poll();
                s.add(v);
                for(int a : map.getOrDefault(v, new ArrayList<>())) {
                    du[a]--;
                    if(du[a] == 0) {
                        queue1.offer(a);
                    }
                }
                if(s.size() > 1) {
                    return false;
                }
                while (!queue2.isEmpty() && s.contains(queue2.peek())) {
                    queue2.poll();
                }
            }
        }

        return queue2.size() == 0;
    }
}
