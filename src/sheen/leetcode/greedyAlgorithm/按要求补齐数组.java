package sheen.leetcode.greedyAlgorithm;

public class 按要求补齐数组 {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        int index = 0;
        //right-1被覆盖了
        long right = 1;
        //[1,right-1]被覆盖，加上right就变成[1,2right-1]被覆盖
        if(nums.length==0) {
            res ++;
            right = 2;
        }
        while(right<=n){
            if(index<nums.length&&nums[index]<=right) {
                right+= nums[index];
                index++;
            }else {
                right = right*2;
                res++;
            }
        }
        return res;
    }
}
