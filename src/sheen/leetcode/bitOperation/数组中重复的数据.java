package sheen.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.List;

public class 数组中重复的数据 {

    public static void main(String[] args) {
        数组中重复的数据 s = new 数组中重复的数据();
        System.out.println(s.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                if(nums[nums[i]-1]<0) {
                    res.add(nums[i]);
                } else {
                    nums[nums[i]-1] = -nums[nums[i]-1];
                }
            }else {
                if(nums[-nums[i]-1]<0) {
                    res.add(-nums[i]);
                } else {
                    nums[-nums[i]-1] = -nums[-nums[i]-1];
                }

            }
        }
        return res;
    }
}
