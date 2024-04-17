package sheen.leetcode.array;

/**
 * @Classname 处理用时最长的那个任务的员工
 * @Date 2023/5/5 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 处理用时最长的那个任务的员工 {
    public int hardestWorker(int n, int[][] logs) {
        int now = 0;
        int res = 0;
        int max = -1;
        for(int i = 0; i < logs.length; i++) {
            int v = logs[i][1] - now;
            if(v >= max) {
                if(v == max) {
                    res = Math.min(logs[i][0], res);
                }else {
                    res = logs[i][0];
                }
                max = v;
            }
            now = logs[i][1];
        }

        return res;
    }
}
