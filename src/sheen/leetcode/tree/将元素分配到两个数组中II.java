package sheen.leetcode.tree;

import java.util.*;

/**
 * @Classname 将元素分配到两个数组中II
 * @Date 2024/6/5 00:42
 * @Created by sheen
 * @Description TODO
 */
//https://blog.csdn.net/TheWayForDream/article/details/118436732
public class 将元素分配到两个数组中II {
    class BinaryIndexedTree {
        private int[] tree;

        public BinaryIndexedTree(int n) {
            tree = new int[n + 1];
        }

        public void add(int i) {
            while (i < tree.length) {
                tree[i]++;
                i += i & -i;
            }
        }

        public int get(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    class Solution {
        public int[] resultArray(int[] nums) {
            int n = nums.length;
            int[] sortedNums = Arrays.copyOf(nums, n);
            Arrays.sort(sortedNums);

            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < n; i++) {
                index.put(sortedNums[i], i + 1);
            }

            List<Integer> arr1 = new ArrayList<>(List.of(nums[0]));
            List<Integer> arr2 = new ArrayList<>(List.of(nums[1]));
            BinaryIndexedTree tree1 = new BinaryIndexedTree(n);
            BinaryIndexedTree tree2 = new BinaryIndexedTree(n);
            tree1.add(index.get(nums[0]));
            tree2.add(index.get(nums[1]));

            for (int i = 2; i < n; i++) {
                int count1 = arr1.size() - tree1.get(index.get(nums[i]));
                int count2 = arr2.size() - tree2.get(index.get(nums[i]));
                if (count1 > count2 || (count1 == count2 && arr1.size() <= arr2.size())) {
                    arr1.add(nums[i]);
                    tree1.add(index.get(nums[i]));
                } else {
                    arr2.add(nums[i]);
                    tree2.add(index.get(nums[i]));
                }
            }

            int i = 0;
            for (int a: arr1) {
                nums[i++] = a;
            }
            for (int a: arr2) {
                nums[i++] = a;
            }
            return nums;
        }
    }
}
