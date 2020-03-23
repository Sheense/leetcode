package com.company.dp;

public class 按摩师 {
    public static void main(String[] args) {
        按摩师 s = new 按摩师();
        System.out.println(s.massage(new int[]{1,2,3}));
    }

    public int massage(int[] nums) {
        int index_first = -1;
        int value_first = 0;
        int index_second = -1;
        int value_second = 0;
        int max = 0;
        //初始化时第一与第二不会共享同一个大小
        for(int i=0;i<nums.length;i++) {
            if(index_first==-1||index_first+1!=i) {
                int temp_index = index_first;
                int temp_value = value_first;
                index_first = i;
                value_first = nums[i] + value_first;
                //更新第二的值
                //如果第二大的数的下标不是当前下标的前一位,就有两种选择
                if(index_second+1!=i) {
                    //second与当前数的和与原第一对比
                    if(value_second+nums[i]>temp_value) {
                        index_second = i;
                        value_second = value_second+nums[i];
                        continue;
                    }
                }
                //当前下标下,第二的数是原第一
                index_second = temp_index;
                value_second = temp_value;
            } else {
                //当前第一个不满足条件，用第二去加
                index_second = i;
                value_second = value_second + nums[i];
                //更新第一的值
                if(value_second>value_first) {
                   int temp_index = index_first ;
                   int temp_value = value_first;
                   index_first = index_second;
                   value_first = value_second;
                   index_second = temp_index;
                   value_second = temp_value;
                }
            }
            if(value_first>max) max = value_first;
        }
        return max;
    }
}
