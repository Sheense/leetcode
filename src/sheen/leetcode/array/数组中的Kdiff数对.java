package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 数组中的Kdiff数对 {

    public static void main(String[] args) {
        数组中的Kdiff数对 s = new 数组中的Kdiff数对();
        System.out.println(s.findPairs(new int[]{2,9,0,8,9,6,5,9,8,1,9,6,9,2,8,8,7,5,7,8,8,3,7,4,1,1,6,2,9,9,3,9,2,4,6,5,6,5,1,5,9,9,8,1,4,3,2,8,5,3,5,4,5,7,0,0,7,6,4,7,2,4,9,3,6,6,5,0,0,0,8,9,9,6,5,4,6,2,1,3,2,5,0,1,4,2,6,9,5,4,9,6,0,8,3,8,0,0,2,1},1));
    }
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        int index = 0;
        int res = 0;
        do{
            if(k != 0) {
                int v = nums[index] - k;
                if(set.contains(v)) {
                    res++;
                }
            }
            set.add(nums[index]);
            int i = index;
            while (i < nums.length && nums[i] == nums[index]) {
                i++;
            }
            if(i - index> 1) {
                res++;
            }
            index = i;
        }while (index < nums.length);

        return res;
    }
}
