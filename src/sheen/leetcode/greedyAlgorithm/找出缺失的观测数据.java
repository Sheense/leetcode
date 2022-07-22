package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 找出缺失的观测数据
 * @Date 2022/3/27 1:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出缺失的观测数据 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int all = 0;
        for(int i = 0; i < rolls.length; i++) {
            all += rolls[i];
        }

        int yu = mean * (n + rolls.length) - all;
        if(yu < 0) {
            return new int[]{};
        }

        int item = yu / n;
        int y = yu % n;
        if(item > 6 || (item == 6 && y > 0) || item == 0) {
            return new int[]{};
        }

        int[] res = new int[n];
        for(int i = 0; i < res.length; i++) {
            res[i] = item;
            if(y > 0) {
                res[i] ++;
                y--;
            }
        }
        return res;
    }
}
