package sheen.leetcode.window;

public class 乘积小于K的子数组 {
    public static void main(String[] args) {
        乘积小于K的子数组 s = new 乘积小于K的子数组();
        System.out.println(s.numSubarrayProductLessThanK(new int[]{1,1,1},1));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left =0;
        int right = 0;
        int all = 1;
        int res = 0;
        while(left<nums.length) {
            if(all>=k) {
                all/=nums[left];
                res+=right-left-1>=0?right-left-1:0;
                left++;
                if(left>right) right = left;
            }else {
                while(right<nums.length&&all<k){
                    all*=nums[right];
                    right++;
                }
                res+=all>=k?right-left-1:right-left;
                all/=nums[left];
                left++;
            }
        }
        return res;
    }
}
