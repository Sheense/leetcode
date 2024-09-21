package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @Classname 完成所有任务的最少时间
 * @Date 2024/5/15 00:13
 * @Created by sheen
 * @Description TODO
 */
public class 完成所有任务的最少时间 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (x, y) -> x[1] - y[1]);
        int[] run = new int[tasks[tasks.length - 1][1] + 1];
        int res = 0;
        for(int i = 0; i < tasks.length; i++) {
            int time = tasks[i][2];
            for(int j = tasks[i][0]; j <= tasks[i][1]; j++) {
                time -= run[j];
            }

            res += Math.max(0, time);
            for(int j = tasks[i][1]; j > 0 && time > 0; j--) {
                if(run[j] == 0) {
                    time--;
                    run[j]++;
                }
            }
        }
        return res;
    }
}
