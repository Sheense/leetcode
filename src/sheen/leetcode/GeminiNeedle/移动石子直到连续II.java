package sheen.leetcode.GeminiNeedle;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;

/**
*@Classname 移动石子直到连续II
*@Date 2023/4/7 12:21 上午
*@Created by sheen
*@Description TODO
*/public class 移动石子直到连续II {
    public static void main(String[] args) {
        移动石子直到连续II s = new 移动石子直到连续II();
        ArrayUtils.print(s.numMovesStonesII(new int[]{1,2,3,4,6}));
    }
    public int[] numMovesStonesII(int[] stones) {
        if(stones.length == 1) {
            return new int[]{0, 0};
        }

        Arrays.sort(stones);
        if(stones[stones.length - 1] - stones[0] + 1 == stones.length) {
            return new int[]{0, 0};
        }

        int max = Math.max(stones[stones.length - 1] - stones[1] + 1, stones[stones.length - 2] - stones[0] + 1) - (stones.length - 1);
        int min = stones.length;

        for(int i = 0, j = 0; i < stones.length && j + 1 < stones.length; i++) {
            while (j + 1 < stones.length && stones[j + 1] - stones[i] + 1 <= stones.length) {
                j++;
            }

            //应对{1, 2, 3, 4, 7}这种情况，{1, 2, 3, 4, 6}也会先走这里，但是结果为1是下一轮算出来的
            if(j - i + 1 == stones.length - 1 && stones[j] - stones[i] + 1 == stones.length - 1) {
                min = Math.min(min, 2);
            }else {
                min = Math.min(min, stones.length - (j - i + 1));
            }
        }


        return new int[]{min, max};
    }

}
