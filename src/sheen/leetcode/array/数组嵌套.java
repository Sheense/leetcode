package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class 数组嵌套 {

    public static void main(String[] args) {
        数组嵌套 s = new 数组嵌套();
        System.out.println(s.arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }

    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] flag = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(!flag[i]) {
                Set<Integer> root = new HashSet<>();
                dfs(i, nums, root, flag);
                res = Math.max(res, root.size());
            }
        }
        return res;
    }

    public void dfs(int index, int[] nums, Set<Integer> root, boolean[] flag) {
        if(root.contains(index)) {
            return;
        }
        root.add(index);
        flag[index] = true;
        dfs(nums[index], nums, root, flag);
    }


}
