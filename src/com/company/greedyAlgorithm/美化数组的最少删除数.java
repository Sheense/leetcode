package com.company.greedyAlgorithm;

/**
 * @Classname 美化数组的最少删除数
 * @Date 2022/3/27 10:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 美化数组的最少删除数 {
    public static void main(String[] args) {
        美化数组的最少删除数 s= new 美化数组的最少删除数();
        System.out.println(s.minDeletion(new int[]{1,1,2,2,3,3}));
    }
    public int minDeletion(int[] nums) {
        int count = 0;
        int i = 0;
        int real = 0;
        while (i < nums.length) {
            int index = i;
            while (index < nums.length && nums[index] == nums[i]) {
                index++;
            }
            int v = index - i;
            if(v > 1) {
                if(real % 2 == 1) {
                    count += (v - 2);
                }else {
                    count += (v - 1);
                }
            }
            real = index - count;
            i = index;
        }
        if((nums.length - count) % 2 == 1) {
            count++;
        }
        return count;
    }
}
