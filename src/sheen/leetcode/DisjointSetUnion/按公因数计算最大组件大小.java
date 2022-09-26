package sheen.leetcode.DisjointSetUnion;

import java.util.*;

/**
 * @Classname 按公因数计算最大组件大小
 * @Date 2022/7/30 2:25 下午
 * @Created by sheen
 * @Description TODO
 */
public class 按公因数计算最大组件大小 {
    public static void main(String[] args) {
        按公因数计算最大组件大小 s = new 按公因数计算最大组件大小();
        System.out.println(s.largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
    }
    public int largestComponentSize(int[] nums) {
        Set<Integer> factorSet = new HashSet<>();
        Map<Integer, List<Integer>> map = getFactor(nums, factorSet);
        //使用出现的质子数做并查集
        UnionSet set = new UnionSet(factorSet);
        for(List<Integer> list : map.values()) {
            set.add(list);
        }

        return set.getRes();
    }

    public Map<Integer, List<Integer>> getFactor(int[] nums, Set<Integer> set) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        List<Integer> factors = getFactor(max);

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for(int v : factors) {
                //优化
                if(v > num) {
                    break;
                }
                //已经是质子数，无需继续遍历
                if(search(factors, num)) {
                    map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(num);
                    set.add(num);
                    break;
                }
                if(num % v == 0) {
                    map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(v);
                    set.add(v);
                    //优化，让num变小，减少遍历次数
                    while (num % v == 0) {
                        num /= v;
                    }
                }
            }
        }
        return map;
    }

    public boolean search(List<Integer> list, int v) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(list.get(mid) >= v) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left < list.size() && list.get(left) == v;
    }

    public List<Integer> getFactor(int v) {
        List<Integer> res = new ArrayList<>();
        for(int i =2; i <= v; i++) {
            boolean flag = true;
            for(int j = 2; j <= (int)Math.sqrt(i); j++) {
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res.add(i);
            }
        }
        return res;
    }


    public static class UnionSet{
        private Map<Integer, Integer> indexMap = new HashMap<>();
        private int[] unionSet;
        private int[] count;
        public UnionSet(Set<Integer> factor) {
            unionSet = new int[factor.size()];
            count = new int[factor.size()];
            int index = 0;
            for(int i : factor) {
                indexMap.put(i, index);
                unionSet[index] = index;
                index++;
            }
        }

        public int findRoot(int v) {
            while (unionSet[v] != v) {
                v = unionSet[v];
            }
            return v;
        }

        public void union(int v1, int v2) {
            while (unionSet[v2] != v2) {
                int i = unionSet[v2];
                unionSet[v2] = v1;
                v2 = i;
            }

            unionSet[v2] = v1;
        }
        //根据每个数的质因数去关联，并查集中的其他元素
        public void add(List<Integer> list) {
            int root1 = findRoot(indexMap.get(list.get(0)));
            count[root1] ++;

            for(int i = 1; i < list.size(); i++) {
                int root2 = findRoot(indexMap.get(list.get(i)));
                if(root1 != root2) {
                    count[root1] += count[root2];
                    union(root1, indexMap.get(list.get(i)));
                }
            }
        }

        public int getRes() {
            int res = 0;
            for(int i = 0; i < count.length; i++) {
                res = Math.max(count[i], res);
            }

            return res;
        }
    }
}
