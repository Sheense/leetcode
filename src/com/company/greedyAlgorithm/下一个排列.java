package com.company.greedyAlgorithm;


import java.util.Arrays;

public class 下一个排列 {

    public static void main(String[] args) {
        下一个排列 s = new 下一个排列();
        int[] arr = new int[]{4,2,4,4,3};
        s.nextPermutation(arr);

    }

    public void nextPermutation(int[] nums) {
        int index = process(nums, nums.length-1);
        Arrays.sort(nums, index, nums.length);
    }
    public int process(int[] nums, int end) {
        for(int i=end;i>0;i--) {
            if(nums[i-1]>=nums[i]) continue;
            for(int j=i-1;j>=0;j--) {
                for(int z=i;z<=end;z++) {
                    if(nums[z]>nums[j]&&((z+1<=end&&nums[z+1]<=nums[j])||z==end)) {
                        int temp = nums[z];
                        nums[z] = nums[j];
                        nums[j] = temp;
                        return i;
                    }
                }
            }
            return process(nums, i-1);
        }
        return 0;
    }
    //1、后面递增序列，找到第一个下降的点，这个点与后面上升序列中一个大于该点且下一个小等于该点的的数交换
//2、第一个下降的点不是，在往前面找，重复1的判断,直到满足
//3、第二步不满足，从第一个下降的点那里找上升序列，直到找到第一个下降，重复1，2操作
//4、找到正确的下降点并交换结束后，将下降点后面的数从小到大排列。找不到对应的下降点，则从0到length从小到大排列
}
