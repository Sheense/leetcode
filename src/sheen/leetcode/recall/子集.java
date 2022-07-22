package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {

    public static void main(String[] args) {
        子集 s = new 子集();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        recall(res, nums, 0);
        return res;
    }

    public void recall(List<List<Integer>> res, int[] nums, int index) {
        if(index>=nums.length) return ;
        List<Integer> list = new ArrayList<>();
        list.add(nums[index]);
        int size = res.size();
        for(int z=0;z<size;z++) {
            List<Integer> item = res.get(z);
            List<Integer> l = new ArrayList<>(item);
            l.addAll(list);
            res.add(l);
        }
        index++;
        recall(res, nums, index);
    }
}
