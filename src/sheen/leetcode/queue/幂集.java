package sheen.leetcode.queue;

import java.util.ArrayList;
import java.util.List;

public class 幂集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size = res.size();
            for(int j = 0;j<size;j++) {
                List<Integer> copy = new ArrayList<>(res.get(j));
                copy.add(nums[i]);
                res.add(copy);
            }
        }
        return res;
    }
}
