package sheen.leetcode.bfs;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 颜色交替的最短路径
 * @Date 2023/2/2 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 颜色交替的最短路径 {
    public static void main(String[] args) {
        颜色交替的最短路径 s = new 颜色交替的最短路径();
        ArrayUtils.print(s.shortestAlternatingPaths(3, new int[][]{{0,1}}, new int[][]{{1, 2}}) );
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] answer = new int[n];
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for(int i = 0; i < redEdges.length; i++) {
            redMap.computeIfAbsent(redEdges[i][0], x -> new ArrayList<>()).add(redEdges[i][1]);
        }
        for(int i = 0; i < blueEdges.length; i++) {
            blueMap.computeIfAbsent(blueEdges[i][0], x -> new ArrayList<>()).add(blueEdges[i][1]);
        }

        List<Integer> nowRed = new ArrayList<>();
        List<Integer> nowBlue = new ArrayList<>();
        Set<Integer> redSet = new HashSet<>();
        Set<Integer> blueSet = new HashSet<>();
        nowRed.add(0);
        nowBlue.add(0);
        redSet.add(0);
        blueSet.add(0);
        Arrays.fill(answer, -1);
        answer[0] = 0;
        recall(nowRed, nowBlue, answer, redMap, blueMap, redSet, blueSet, 0);
        return answer;
    }

    public int recall(List<Integer> nowRed, List<Integer> nowBlue, int[] answer, Map<Integer, List<Integer>> redMap, Map<Integer, List<Integer>> blueMap,
                      Set<Integer> redSet, Set<Integer> blueSet, int count) {

        List<Integer> nextBlue = new ArrayList<>();
        for(int now : nowRed) {
            for(int next : blueMap.getOrDefault(now, new ArrayList<>())) {
                if(answer[next] == -1) {
                    answer[next] = count + 1;
                }

                if(!blueSet.contains(next)) {
                    nextBlue.add(next);
                    blueSet.add(next);
                }
            }
        }

        List<Integer> nextRed = new ArrayList<>();
        for(int now : nowBlue) {
            for(int next : redMap.getOrDefault(now, new ArrayList<>())) {
                if(answer[next] == -1) {
                    answer[next] = count + 1;
                }

                if(!redSet.contains(next)) {
                    nextRed.add(next);
                    redSet.add(next);
                }
            }
        }

        if(nextBlue.isEmpty() && nextRed.isEmpty()) {
            return -1;
        }

        return recall(nextRed, nextBlue, answer, redMap, blueMap, redSet, blueSet, count + 1);
    }
}
