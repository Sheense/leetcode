package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 四数之和
 * @Date 2023/7/15 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<=3) return res;
        Arrays.sort(nums);
        int bl = 0;
        int br = nums.length-1;
        while(nums.length-4>=bl) {
            while(br-bl>=3) {
                int sl = bl+1;
                int sr = br-1;
                long band = nums[br]+nums[bl];
                while(sl<sr) {
                    long and = band +(long)nums[sl]+nums[sr];
                    if(and==target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[br]);
                        list.add(nums[bl]);
                        list.add(nums[sl]);
                        list.add(nums[sr]);
                        while(sl<sr&&nums[sr]==nums[sr-1]) sr--;
                        while(sl<sr&&nums[sl]==nums[sl+1]) sl++;
                        sr--;
                        sl++;
                        res.add(list);
                    }else if(and>target) {
                        while(sl<sr&&nums[sr]==nums[sr-1]) sr--;
                        sr--;
                    }else if(and<target) {
                        while(sl<sr&&nums[sl]==nums[sl+1]) sl++;
                        sl++;
                    }
                }
                while(br-bl>=3&&nums[br-1]==nums[br]) {
                    br--;
                }
                br--;
            }
            br = nums.length-1;
            while(br-bl>=3&&nums[bl+1]==nums[bl]) {
                bl++;
            }
            bl++;
        }
        return res;
    }
}
