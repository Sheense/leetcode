package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 课程表IV
 * @Date 2023/9/12 00:43
 * @Created by sheen
 * @Description TODO
 */
public class 课程表IV {
    public static void main(String[] args) {
        课程表IV s = new 课程表IV();
        System.out.println(s.checkIfPrerequisite(2, new int[][]{{1,0}}, new int[][]{{0,1},{1,0}}));
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][0], x -> new HashSet<>()).add(prerequisites[i][1]);
        }
        List<Boolean> res = new ArrayList<>();

        Map<Integer, Set<Integer>> save = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            find(i, save, map);
        }

        for(int i = 0; i < queries.length; i++) {
            res.add(save.getOrDefault(queries[i][0], new HashSet<>()).contains(queries[i][1]));
        }
        return res;
    }

    public void find(int start, Map<Integer, Set<Integer>> save, Map<Integer, Set<Integer>> map) {
        if(save.containsKey(start)) {
            return;
        }

        Set<Integer> set = map.get(start);
        if(set == null) {
            save.put(start, new HashSet<>());
            return;
        }

        Set<Integer> item = new HashSet<>();
        item.addAll(set);
        for(int next : set) {
            find(next, save, map);
            item.addAll(save.get(next));
        }
        save.put(start, item);
    }


}
