package sheen.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 得到连续K个1的最少相邻交换次数
 * @Date 2022/12/18 12:42 上午
 * @Created by sheen
 * @Description TODO
 */
public class 得到连续K个1的最少相邻交换次数 {
    public int minMoves(int[] nums, int k) {
        int[] pos = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                pos[index++] = i;
            }
        }

        int mid = k / 2;
        int count = 0;
        for(int i = 1; i < k; i++) {
            count += (pos[i] - pos[i - 1] - 1) * Math.min(i, k - i);
        }
        int res = count;
        for(int i = k; i < index; i++) {
            count -= pos[i - k + mid] - pos[i - k];
            count += pos[i] - pos[i - mid];
            res = Math.min(res, count);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


        return res;


    }
}
