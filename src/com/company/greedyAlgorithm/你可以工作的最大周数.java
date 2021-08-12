package com.company.greedyAlgorithm;

import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname 你可以工作的最大周数
 * @Date 2021/8/1 10:56 上午
 * @Created by sheen
 * @Description TODO
 */
public class 你可以工作的最大周数 {
    public static void main(String[] args) {
        你可以工作的最大周数 s = new 你可以工作的最大周数();
        System.out.println(s.numberOfWeeks(new int[]{1,2,3}));
    }
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int max = 0;
        for(int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            if(milestones[i] > milestones[max]) {
                max = i;
            }
        }
        if(milestones[max] > sum - milestones[max]) {
            return (sum - milestones[max]) * 2 + 1;
        }
        return (int) sum;
    }


}
