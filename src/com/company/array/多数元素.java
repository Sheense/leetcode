package com.company.array;

//Boyer-Moore 投票算法
public class 多数元素 {

    public static void main(String[] args) {
        多数元素 s = new 多数元素();
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    public int majorityElement(int[] nums) {
        int num = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(count==0) {
                num = nums[i];
                count++;
            }else {
                if(num==nums[i]) {
                    count++;
                }else {
                    count--;
                }
            }
        }
        return num;
    }
}
