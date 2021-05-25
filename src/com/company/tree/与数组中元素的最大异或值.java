package com.company.tree;


import java.util.Arrays;

//前缀树
public class 与数组中元素的最大异或值 {
    public static void main(String[] args) {
        与数组中元素的最大异或值 s = new 与数组中元素的最大异或值();
        System.out.println(s.maximizeXor(new int[]{0,1,2,3,4}, new int[][]{{3,1},{1,3},{5,6}}));

    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[][] questions = new int[queries.length][3];
        for(int i = 0;i< queries.length;i++) {
            questions[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(questions, (o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        TireNode root = new TireNode();
        int i = 0;
        int j = 0;
        while (i < questions.length) {
            while (j<nums.length && nums[j] <= questions[i][1]) {
                buildTireTree(root, nums[j]);
                j++;
            }
            res[questions[i][2]] = findNum(root, questions[i][0]);
            i++;
        }
        return res;
    }

    public int findNum(TireNode root, int val) {
        if(root.left == null && root.right == null) return -1;
        int res = 0;
        for(int i = 30; i>=0; i--) {
            int n = val >> i;
            res<<=1;
            if(n%2 == 0) {
                if (root.right != null) {
                   res|=1;
                   root = root.right;
                } else {
                   root = root.left;
                }
            }else {
                if (root.left != null) {
                    res|=1;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return res;
    }

    public void buildTireTree(TireNode root, int val) {
        for (int i = 30;i>=0;i--) {
            int n = val >> i;
            if (n % 2 == 0) {
               if(root.left == null) {
                   root.left = new TireNode();
               }
               root = root.left;
            } else {
               if(root.right == null) {
                   root.right = new TireNode();
               }
               root = root.right;
            }
        }
    }

    public class TireNode{
        TireNode left; // 0
        TireNode right; // 1
    }
}
