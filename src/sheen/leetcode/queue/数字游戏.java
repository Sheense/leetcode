package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 数字游戏
 * @Date 2024/2/1 00:20
 * @Created by sheen
 * @Description TODO
 */
public class 数字游戏 {
    public int[] numsGame(int[] nums) {
        PriorityQueue<Integer> lower = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> upper = new PriorityQueue<>();
        int mod = (int)Math.pow(10 , 9) + 7;
        int[] res = new int[nums.length];
        long lowerSum = 0;
        long upperSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int v = nums[i] - i;
            if(lower.isEmpty() || lower.peek() >= v) {
                lower.offer(v);
                lowerSum += v;
                if(lower.size() > upper.size() + 1) {
                    int pop = lower.poll();
                    lowerSum -= pop;
                    upper.offer(pop);
                    upperSum += pop;
                }
            }else {
                upper.offer(v);
                upperSum += v;
                if(upper.size() > lower.size()) {
                    int pop = upper.poll();
                    upperSum -= pop;
                    lower.offer(pop);
                    lowerSum += pop;
                }
            }
            if((i + 1) % 2 == 0) {
                res[i] = (int)((upperSum - lowerSum) % mod);
            }else {
                res[i] = (int)((upperSum - lowerSum + lower.peek()) % mod);
            }
        }

        return res;
    }
}
