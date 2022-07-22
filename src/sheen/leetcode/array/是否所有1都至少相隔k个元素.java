package sheen.leetcode.array;

public class 是否所有1都至少相隔k个元素 {

    public boolean kLengthApart(int[] nums, int k) {
        int i = 0;
        while(i<nums.length) {
            if(nums[i]==1) {
                int time = 0;
                int j = i+1;
                while(j<nums.length&&nums[j]!=1) {
                    time++;
                    j++;
                }
                if(j==nums.length) break;
                if(time<k) return false;
                i = j;
            }else {
                i++;
            }
        }
        return true;
    }
}
