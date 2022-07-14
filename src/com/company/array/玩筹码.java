package com.company.array;

/**
 * @Classname 玩筹码
 * @Date 2022/7/8 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 玩筹码 {
    public int minCostToMoveChips(int[] position) {
        int count = 0;
        for(int i = 0; i < position.length; i++)  {
            if(position[i] % 2 == 0) {
                count++;
            }
        }

        return Math.min(count, position.length - count);
    }
}
