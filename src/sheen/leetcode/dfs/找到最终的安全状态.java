package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 找到最终的安全状态
 * @Date 2021/8/5 1:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找到最终的安全状态 {
    public static void main(String[] args) {
        找到最终的安全状态 s = new 找到最终的安全状态();
        System.out.println(s.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
    }
    //res表示从该点走没有环
    //other表示从该点开始存在至少一条有环的路
    //set表示走过的路
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> other = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < graph.length; i++) {
            if(!res.contains(i) && !other.contains(i)) {
                recall(graph, res, other, set, i);
            }
        }
        List<Integer> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }

    public boolean recall(int[][] graph, Set<Integer> res, Set<Integer> other, Set<Integer> set, int i) {
        //到头了，说明没有环，回溯
        if(graph[i].length == 0) {
            res.add(i);
            return true;
        }

        set.add(i);
        for(int j = 0; j < graph[i].length; j++) {
            if(other.contains(graph[i][j]) || set.contains(graph[i][j])) {
                set.remove(i);
                other.add(i);
                return false;
            }
            //减枝，如果已经是没有环了，不走
            if(res.contains(graph[i][j])) {
                continue;
            }
            //下个节点有环，直接结束
            boolean flag = recall(graph, res, other, set, graph[i][j]);
            if(!flag) {
                other.add(i);
                set.remove(i);
                return false;
            }
        }
        set.remove(i);
        res.add(i);
        return true;
    }
}
