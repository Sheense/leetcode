package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 装满杯子需要的最短总时长
 * @Date 2022/7/10 10:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 装满杯子需要的最短总时长 {
    public static void main(String[] args) {
        装满杯子需要的最短总时长 s = new 装满杯子需要的最短总时长();
        System.out.println(s.fillCups(new int[]{2, 4, 4}));
    }
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int res = 0;
        while (amount[0] > 0 && amount[1] > 0 && (amount[0] + amount[1]) > amount[2]) {
            amount[0] --;
            amount[1] --;
            res++;
        }

        res += Math.max(amount[2], (amount[0] + amount[1]));
        return res;
    }
}
