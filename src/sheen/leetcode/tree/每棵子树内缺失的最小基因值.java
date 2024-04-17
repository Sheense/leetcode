package sheen.leetcode.tree;

import java.util.*;

/**
 * @Classname 每棵子树内缺失的最小基因值
 * @Date 2023/10/31 00:09
 * @Created by sheen
 * @Description TODO
 */
public class 每棵子树内缺失的最小基因值 {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        Map<Integer, Node> map = new HashMap<>();

        Set<Integer>[] sets = new Set[parents.length];
        for(int i = 0; i < parents.length; i++) {
            map.put(i, new Node(i));
            sets[i] = new HashSet<>();
        }

        int[] res = new int[parents.length];
        Arrays.fill(res, 1);
        for(int i = 1; i < parents.length; i++) {
            Node parent = map.get(parents[i]);
            Node children = map.get(i);
            parent.next.add(children);
        }

        dfs(map, 0, res, sets, nums);
        return res;
    }

    public int dfs(Map<Integer, Node> map, int now, int[] res, Set<Integer>[] sets, int[] nums) {
        sets[now].add(nums[now]);
        for(Node next : map.get(now).next) {
            res[now] = Math.max(res[now], dfs(map, next.index, res, sets, nums));
            if (sets[now].size() < sets[next.index].size()) {
                sets[next.index].addAll(sets[now]);
                sets[now] = sets[next.index];
            }else {
                sets[now].addAll(sets[next.index]);
            }
        }

        while (sets[now].contains(res[now])) {
            res[now]++;
        }

        return res[now];
    }

    public static class Node {
        private List<Node> next = new ArrayList<>();
        private int index = -1;

        public Node(int index) {
            this.index = index;
        }
    }
}
