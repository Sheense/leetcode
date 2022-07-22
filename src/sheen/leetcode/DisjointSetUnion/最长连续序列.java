package sheen.leetcode.DisjointSetUnion;

import java.util.HashMap;
import java.util.Map;

/*public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums)set.add(num);
        int max = 0;
        for(int num:nums) {
        int pre = num-1;
        int next = num+1;
        while(set.remove(pre))--pre;
        while(set.remove(next))++next;
        max = next-pre-1>max?next-pre-1:max;
        }
        return max;
        }*/
public class 最长连续序列 {
    public static void main(String[] args) {
        最长连续序列 s = new 最长连续序列();
        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        UnionFind unionFind = new UnionFind(nums.length);
        for(int key: map.keySet()) {
            int value = key;
            if(map.containsKey(value-1)) {
                int index = map.get(value-1);
                unionFind.union(index, map.get(key));
            }
            if(map.containsKey(value+1)) {
                int index = map.get(value+1);
                unionFind.union(index, map.get(key));
            }
        }
        return unionFind.getMasxlen();
    }

    public class UnionFind{
        int parent[];
        int max[] ;
        public UnionFind(int len) {
            parent = new int[len];
            max = new int[len];
            for(int i=0;i<parent.length;i++) {
                parent[i]=i;
                max[i] = 1;
            }
        }

        public void union(int i, int j) {
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            if(r1 == r2) return ;
            unionRoot(r2, i);
            max[r2] = max[r1] + max[r2];
        }

        public int findRoot(int i) {
            while (i!=parent[i]) {
                i = parent[i];
            }
            return i;
        }

        private void unionRoot(int r, int i) {
            while (i!=parent[i]) {
                int next = parent[i];
                parent[i] = r;
                i = next;
            }
            parent[i] = r;
        }

        public int getMasxlen() {
            int max = 0;
            for(int i=0;i<this.max.length;i++) {
                if(max<this.max[i]) {
                    max = this.max[i];
                }
            }
            return max;
        }
    }
}
