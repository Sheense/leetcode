package sheen.leetcode.greedyAlgorithm;

import java.util.*;

/**
 * @Classname 魔塔游戏
 * @Date 2024/2/6 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 魔塔游戏 {
    public static void main(String[] args) {
        魔塔游戏 s = new 魔塔游戏();
        System.out.println(s.magicTower(new int[]{-200,-300,400,0}));
    }
    public int magicTower(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pri = new PriorityQueue<>((x, y) -> {
            return nums[x] - nums[y];
        });

        long all = 0;
        for(int i = 0; i < nums.length; i++) {
            queue.offer(i);
            all += nums[i];
        }

        if(all + 1 <= 0) {
            return -1;
        }

        int res = 0;
        long v = 1;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if(nums[index] < 0) {
                pri.offer(index);
            }

            v += nums[index];
            while (!pri.isEmpty() && v <= 0) {
                int pop = pri.poll();
                queue.offer(pop);
                v -= nums[pop];
                res++;
            }

            if(v <= 0) {
                return -1;
            }
        }

        return res;
    }
}
